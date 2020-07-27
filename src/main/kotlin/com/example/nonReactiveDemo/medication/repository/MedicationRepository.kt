package com.example.nonReactiveDemo.medication.repository

import com.example.nonReactiveDemo.medication.model.DTDMedicationStatement
import org.springframework.data.mongodb.repository.MongoRepository

interface MedicationRepository: MongoRepository<DTDMedicationStatement, String> {

    fun findOneById(id: String): DTDMedicationStatement

    fun findBySubjectIdentifierValue(personId: String): List<DTDMedicationStatement>?

}