package com.example.nonReactiveDemo.person.service

import com.example.nonReactiveDemo.Reference
import com.example.nonReactiveDemo.organization.model.DTDOrganization
import com.example.nonReactiveDemo.organization.repository.OrganizationRepository
import com.example.nonReactiveDemo.person.model.PersonDTO
import com.example.nonReactiveDemo.person.repository.PersonRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(
        val personRepository: PersonRepository,
        val referenceOrganization: Reference<DTDOrganization>,
        val organizationRepository: OrganizationRepository
): PersonService {

    override fun findAll(): List<PersonDTO> {
        return personRepository.findAll()   //limit rate to achieve back pressure
    }


    override  fun readResource(id: String): PersonDTO {
        return personRepository.findOneById(id)
       }

    override fun createPerson(personDTO: PersonDTO): PersonDTO {
        val id: String = ObjectId().toString();
        toReference(personDTO);
        //createFullName(personDTO);
        return personRepository.save(PersonDTO(
                id = id,
                name = personDTO.name,
                birthDate = personDTO.birthDate,
                gender = personDTO.gender,
                address = personDTO.address,
                managingOrganization = referenceOrganization
        ))
    }

    fun toReference(Person: PersonDTO) {
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