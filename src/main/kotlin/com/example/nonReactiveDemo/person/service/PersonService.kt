package com.example.nonReactiveDemo.person.service

import com.example.nonReactiveDemo.person.model.PersonDTO


interface PersonService {

    fun findAll(): List<PersonDTO>

    fun readResource(id: String): PersonDTO

    fun createPerson(personDTO: PersonDTO): PersonDTO

}