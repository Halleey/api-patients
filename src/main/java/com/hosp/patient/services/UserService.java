package com.hosp.patient.services;


import com.hosp.patient.dtos.PatientDTO;
import com.hosp.patient.dtos.PatientResponseDTO;
import com.hosp.patient.entitie.Patient;

public interface UserService {

    public void saveUser(PatientDTO patientDTO);

    PatientResponseDTO getPatient(String cpf);
}
