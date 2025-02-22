package com.hosp.patient.services;

import com.hosp.patient.dtos.PatientDTO;
import com.hosp.patient.dtos.PatientResponseDTO;
import com.hosp.patient.entitie.Patient;
import com.hosp.patient.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@Service
public class PatientImpl implements UserService {

    private final PatientRepository repository;
    private final KafkaTemplate<String, Serializable> kafkaTemplate;


    public PatientImpl(PatientRepository repository, KafkaTemplate<String, Serializable> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void saveUser(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setAddress(patientDTO.getAddress());
        patient.setNumber(patientDTO.getNumber());
        patient.setCpf(patientDTO.getCpf());
        repository.save(patient);

        kafkaTemplate.send("Hospital",  0, "patientKey", patientDTO );
    }

    @Override
    public PatientResponseDTO getPatient(String cpf) {
        Patient patient = repository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        return new PatientResponseDTO(
                patient.getName(),
                patient.getAddress(),
                patient.getNumber(),
                patient.getCpf()
        );
    }
}
