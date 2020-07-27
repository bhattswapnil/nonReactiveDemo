package com.example.nonReactiveDemo.person.repository

import com.example.nonReactiveDemo.person.model.PersonDTO
import org.springframework.data.mongodb.repository.MongoRepository


interface PersonRepository: MongoRepository<PersonDTO, String> {

    fun findOneById(id: String): PersonDTO


}