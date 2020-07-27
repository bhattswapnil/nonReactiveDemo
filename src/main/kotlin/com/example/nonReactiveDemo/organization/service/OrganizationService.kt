package com.example.nonReactiveDemo.organization.service

import com.example.nonReactiveDemo.organization.model.DTDOrganization


interface OrganizationService{

    fun createOrganization(dtdOrganization: DTDOrganization): DTDOrganization

    fun readResource(id: String): DTDOrganization

    fun findAll(): List<DTDOrganization>
}