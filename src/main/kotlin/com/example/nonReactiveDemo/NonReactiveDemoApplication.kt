package com.example.nonReactiveDemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NonReactiveDemoApplication

fun main(args: Array<String>) {
	runApplication<NonReactiveDemoApplication>(*args)
}
