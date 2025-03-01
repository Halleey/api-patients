package com.hosp.patient.services;

import com.hosp.patient.dtos.PatientDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@Service
public class PatientImpl implements UserService {


    private final KafkaTemplate<String, Serializable> kafkaTemplate;


    public PatientImpl( KafkaTemplate<String, Serializable> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void saveUser(PatientDTO patientDTO) {
        kafkaTemplate.send("Hospital",  0, "patientKey", patientDTO );
    }

}
