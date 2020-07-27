package com.example.nonReactiveDemo.medication.controller

import com.example.nonReactiveDemo.medication.model.DTDMedicationStatement
import com.example.nonReactiveDemo.medication.service.MedicationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/medication")
class MedicationController(
        private val medicationService: MedicationService
){

    @GetMapping
    fun getAllMedication(): List<DTDMedicationStatement> {
        return medicationService.findAll()
    }
    @GetMapping("/{id}")
    fun getMedicationById(@PathVariable("id")id:String):DTDMedicationStatement {
        return medicationService.readResource(id)
    }

    @PostMapping
    fun createMedication(@RequestBody request: DTDMedicationStatement): DTDMedicationStatement {
        return medicationService.createResource(request)
    }

}
