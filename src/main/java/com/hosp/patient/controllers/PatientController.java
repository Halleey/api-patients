package com.hosp.patient.controllers;

import com.hosp.patient.dtos.PatientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PatientController {

    @PostMapping
    public ResponseEntity<String> savePatient(@RequestBody  PatientDTO patientDTO);


}
