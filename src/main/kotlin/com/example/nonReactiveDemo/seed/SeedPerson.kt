package com.example.nonReactiveDemo.seed

import com.example.nonReactiveDemo.Address
import com.example.nonReactiveDemo.HumanName
import com.example.nonReactiveDemo.Reference
import com.example.nonReactiveDemo.organization.model.DTDOrganization
import com.example.nonReactiveDemo.person.model.PersonDTO
import com.example.nonReactiveDemo.person.repository.PersonRepository
import com.example.nonReactiveDemo.person.service.PersonService
import io.github.serpro69.kfaker.Faker
import org.apache.logging.log4j.LogManager
import org.bson.types.ObjectId
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class SeedPerson(
        var personRepository: PersonRepository,
        val referenceOrganization: Reference<DTDOrganization>,
        var personService: PersonService


){
    companion object {
        val LOGGER = LogManager.getLogger(SeedPerson::class.java)
    }

    @EventListener()
    fun seed(event: ContextRefreshedEvent){

        var i = 10000
        while(i>0) {
            var person= getPerson()
            createPerson(person)
            i--
        }
    }


    fun getPerson(): PersonDTO {
        val faker = Faker()
        return PersonDTO(
                id = ObjectId().toString(),
                name = mutableSetOf(
                        HumanName(
                                family = faker.name.lastName(),
                                given = mutableSetOf(
                                        faker.name.firstName()
                                )
                        )
                        ),

                gender = faker.gender.toString(),
                address = mutableSetOf(Address(
                        use = faker.address.toString(),
                        type = faker.address.toString(),
                        text= faker.address.fullAddress(),
                        city = faker.address.city(),
                        district = faker.address.city(),
                        state = faker.address.state(),
                        postalCode = faker.address.postcode(),
                        country =faker.address.country()
                )),
                birthDate = LocalDate.now())
    }

    fun createPerson(personDTO: PersonDTO) {
        toReference(personDTO);
        createFullName(personDTO);
        personRepository.save(PersonDTO(
                id = personDTO.id,
                name = personDTO.name,
                birthDate = personDTO.birthDate,
                gender = personDTO.gender,
                address = personDTO.address,
                managingOrganization = referenceOrganization
        ))
        //LOGGER.info("Person created")
    }

    fun toReference(Person: PersonDTO) {
        Person.managingOrganization?.identifier?.value = ObjectId().toString();
        val organizationId = Person.managingOrganization?.identifier?.value;
        referenceOrganization.identifier = Person.managingOrganization?.identifier;
        referenceOrganization.type = Person.managingOrganization?.type;
        referenceOrganization.reference = "/Organization/${organizationId}";
    }

    fun createFullName(Person: PersonDTO){
        for(humanName in Person.name!!)
            for(lastName in humanName.given!!) {
                val fullName = lastName + humanName.family
                humanName.text = fullName.toLowerCase()
            }
    }
}