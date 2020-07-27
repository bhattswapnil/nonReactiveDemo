package com.example.nonReactiveDemo.person.controller

import com.example.nonReactiveDemo.person.model.PersonDTO
import com.example.nonReactiveDemo.person.service.PersonService
import org.springframework.web.bind.annotation.*
import java.time.Duration

@RestController
@RequestMapping(value= ["/person"],produces= ["application/stream+json"])
class PersonController(
        val personService: PersonService
) {

    @GetMapping
    fun getAllPersons(): List<PersonDTO> {
    return personService.findAll()
    }

    @GetMapping("/{id}")
     fun getPersonById(@PathVariable("id")id:String): PersonDTO {
        return personService.readResource(id)
    }

    @PostMapping
    fun createPerson(@RequestBody personDTO: PersonDTO): PersonDTO {
        return personService.createPerson(personDTO)
    }


}