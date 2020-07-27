package com.example.nonReactiveDemo.medication.service

import com.example.nonReactiveDemo.Reference
import com.example.nonReactiveDemo.medication.model.DTDMedicationStatement
import com.example.nonReactiveDemo.medication.repository.MedicationRepository
import com.example.nonReactiveDemo.person.model.PersonDTO
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class MedicationServiceImpl(
        private val medicationRepository: MedicationRepository,
        private var referencePerson: Reference<PersonDTO>
): MedicationService {

    override fun readResource(id: String): DTDMedicationStatement {
        return medicationRepository.findOneById(id)
    }

    override fun createResource(Medication: DTDMedicationStatement):DTDMedicationStatement {
        val id: String = ObjectId().toString();
        toReference(Medication);
        return medicationRepository.save(DTDMedicationStatement(
                id = id,
                status = Medication.status,
                subject = referencePerson,
                dosage = Medication.dosage
        ))
    }

    override fun findAll(): List<DTDMedicationStatement> {
      return medicationRepository.findAll()
    }

    /* override fun updateResource(request: DTDMedicationStatement, id: String): DTDMedicationStatement {
         val medication = medicationRepository.findOneById(id)
         toReference(request);
         return medicationRepository.save(DTDMedicationStatement(
                 id = id,
                 status = request.status,
                 subject = referencePerson,
                 dosage = request.dosage
         ))
     }*/


    fun toReference(Medication: DTDMedicationStatement) {
        val personId = Medication.subject?.identifier?.value;
        referencePerson.identifier = Medication.subject?.identifier;
        referencePerson.type =Medication.subject?.type;
        referencePerson.reference = "/person/${personId}";
    }
}