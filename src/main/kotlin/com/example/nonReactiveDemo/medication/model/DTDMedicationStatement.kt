package com.example.nonReactiveDemo.medication.model

import com.example.nonReactiveDemo.Dosage
import com.example.nonReactiveDemo.Reference
import com.example.nonReactiveDemo.person.model.PersonDTO

class DTDMedicationStatement(
        val id:String?= null,
        val status: String?= null,
        val subject: Reference<PersonDTO>?= null,
        val dosage: Dosage?= null
)