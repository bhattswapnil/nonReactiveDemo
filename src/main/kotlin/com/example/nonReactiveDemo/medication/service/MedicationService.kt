package com.example.nonReactiveDemo.medication.service

import com.example.nonReactiveDemo.medication.model.DTDMedicationStatement


interface MedicationService {

    fun readResource(id: String): DTDMedicationStatement

    fun createResource(medication: DTDMedicationStatement): DTDMedicationStatement

    //fun updateResource(medication: DTDMedicationStatement ,id:String): DTDMedicationStatement

    fun findAll(): List<DTDMedicationStatement>
}