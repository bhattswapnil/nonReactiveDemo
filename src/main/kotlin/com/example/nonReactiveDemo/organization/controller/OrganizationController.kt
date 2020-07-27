package com.example.nonReactiveDemo.organization.controller

import com.example.nonReactiveDemo.organization.model.DTDOrganization
import com.example.nonReactiveDemo.organization.service.OrganizationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/Organization")
class OrganizationController(
        val organizationService: OrganizationService
) {

    @GetMapping
    fun getAllOrganization(): List<DTDOrganization> {
        return organizationService.findAll()
    }

    @GetMapping("/{id}")
    fun getOrganizationById(@PathVariable("id")id:String):DTDOrganization {
        return organizationService.readResource(id)
    }
    @PostMapping
    fun createOrganization(@RequestBody request: DTDOrganization): DTDOrganization {
        return organizationService.createOrganization(request)
    }

}