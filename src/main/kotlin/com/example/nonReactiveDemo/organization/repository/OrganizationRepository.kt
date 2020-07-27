package com.example.nonReactiveDemo.organization.repository

import com.example.nonReactiveDemo.organization.model.DTDOrganization
import org.springframework.data.mongodb.repository.MongoRepository

interface OrganizationRepository : MongoRepository<DTDOrganization, String> {

    fun findOneById(id:String): DTDOrganization
}