package com.hosp.patient.controllers;

import com.hosp.patient.dtos.PatientDTO;
import com.hosp.patient.dtos.PatientResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface PatientController {

    @PostMapping
    public ResponseEntity<String> savePatient(@RequestBody  PatientDTO patientDTO);

    @GetMapping
    public ResponseEntity<PatientResponseDTO> getPatient(@RequestParam String cpf);

}
