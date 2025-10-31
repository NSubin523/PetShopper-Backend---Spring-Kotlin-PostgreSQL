package com.example.animals

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AnimalsApplication

fun main(args: Array<String>) {
	runApplication<AnimalsApplication>(*args)
}
