package com.example.nonReactiveDemo.organization.model

import com.example.nonReactiveDemo.Address
import com.example.nonReactiveDemo.DomainResource


data class DTDOrganization(

        var id: String?= null,
        var name: String? = null,
        var address: MutableSet<Address>? = null
): DomainResource(){

}