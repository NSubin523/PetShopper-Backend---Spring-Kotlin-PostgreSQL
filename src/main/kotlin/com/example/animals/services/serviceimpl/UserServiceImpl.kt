package com.example.animals.services.serviceimpl

import com.example.animals.data.dto.inventory.InventoryListResponseDto
import com.example.animals.data.mapper.inventory.InventoryMapper
import com.example.animals.data.mapper.inventory.InventoryMapper.toListItemResponse
import com.example.animals.domain.model.UserModel
import com.example.animals.events.usercreation.event.UserCreatedEvent
import com.example.animals.exception.duplicate.DuplicateResourceException
import com.example.animals.repository.InventoryRepository
import com.example.animals.repository.UserRepository
import com.example.animals.services.service.UserService
import com.example.animals.util.Constants
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.domain.PageRequest
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServiceImpl(
    private val userRepo: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val eventPublisher: ApplicationEventPublisher,
    private val redisTemplate: RedisTemplate<String, String>,
    private val inventoryRepository: InventoryRepository
) : UserService {
    override fun createUser(user: UserModel): Int {

        val logger = LoggerFactory.getLogger(UserServiceImpl::class.java)

        if (userRepo.existsByEmail(user.email)){
            throw DuplicateResourceException(
                "User",
                "email",
                user.email
            )
        }

        return runCatching {
            val encodedUser = user.copy(password = passwordEncoder.encode(user.password))
            val created = userRepo.save(encodedUser)
            eventPublisher.publishEvent(UserCreatedEvent(this, created))
            HttpStatus.CREATED.value()
        }.getOrElse { ex ->
            logger.error("Error while creating new user - " + ex.message, ex)
            HttpStatus.INTERNAL_SERVER_ERROR.value()
        }
    }

    override fun getUserByEmail(email: String): UserModel? {
        return userRepo.findByEmail(email)
    }



    override fun getUserFavorites(
        userId: String,
        page: Int,
        pageSize: Int
    ): InventoryListResponseDto {
        val redisKey = Constants.getUserFavoriteKeyForRedis(userId)
        val favoritePetsIds: MutableSet<String>? = redisTemplate.opsForSet().members(redisKey)
        if(favoritePetsIds.isNullOrEmpty()){
            return InventoryListResponseDto(emptyList(), page, pageSize, 0, false)
        }

        val uuids = favoritePetsIds.map { UUID.fromString(it) }
        val pageable = PageRequest.of(page, pageSize)
        val pageResult = inventoryRepository.findAllByUuidIn(uuids, pageable)
        val pets = pageResult.content.map(InventoryMapper::toListItemResponse)

        return InventoryListResponseDto(
            items = pets,
            page = page,
            pageSize = pageSize,
            totalCount = pageResult.totalElements.toInt(),
            hasMore = pageResult.hasNext()
        )
    }

    override fun toggleFavorite(userId: String, inventoryId: UUID) {
        val redisKey = Constants.getUserFavoriteKeyForRedis(userId)
        val idString = inventoryId.toString()
        val isMember = redisTemplate.opsForSet().isMember(redisKey, idString) ?: false

        if(isMember){
            redisTemplate.opsForSet().remove(redisKey, idString)
        } else {
            redisTemplate.opsForSet().add(redisKey, idString)
        }
    }
}