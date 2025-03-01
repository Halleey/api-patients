package com.hosp.patient.controllers;

import com.hosp.patient.dtos.PatientDTO;
import com.hosp.patient.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientControllerImpl implements PatientController {

    private final UserService userService;

    public PatientControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<String> savePatient(PatientDTO patientDTO) {
        userService.saveUser(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paciente criado com sucesso");
    }


}
