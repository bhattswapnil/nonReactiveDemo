package com.example.nonReactiveDemo.person.model

import com.example.nonReactiveDemo.Address
import com.example.nonReactiveDemo.DomainResource
import com.example.nonReactiveDemo.HumanName
import com.example.nonReactiveDemo.Reference
import com.example.nonReactiveDemo.organization.model.DTDOrganization
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate

data class PersonDTO(
        @JsonIgnore var id: String? = null,
        val name: MutableSet<HumanName>?= null,
        @JsonIgnore var gender: String?= null,
        @JsonIgnore var birthDate: LocalDate? = null,
        @JsonIgnore val address: MutableSet<Address>?= null,
        @JsonIgnore val managingOrganization: Reference<DTDOrganization>? = null
): DomainResource(){

}