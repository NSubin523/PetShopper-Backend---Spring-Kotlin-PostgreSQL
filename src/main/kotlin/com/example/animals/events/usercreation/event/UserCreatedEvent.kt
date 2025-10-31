package com.example.animals.events.usercreation.event

import com.example.animals.domain.model.UserModel

class UserCreatedEvent(source: Any, val user: UserModel)