package com.example.nonReactiveDemo.organization.service

import com.example.nonReactiveDemo.organization.model.DTDOrganization
import com.example.nonReactiveDemo.organization.repository.OrganizationRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class OrganizationServiceImpl(
        val organizationRepository: OrganizationRepository

):OrganizationService {

    override fun createOrganization(dtdOrganization: DTDOrganization): DTDOrganization {
        val id: String = ObjectId().toString();
        return organizationRepository.save(DTDOrganization(
                id = id,
                name = dtdOrganization.name,
                address = dtdOrganization.address
        ))
    }

    override fun readResource(id: String): DTDOrganization {
        return organizationRepository.findOneById(id)
    }

    override fun findAll(): List<DTDOrganization> {
        return organizationRepository.findAll()
    }
}