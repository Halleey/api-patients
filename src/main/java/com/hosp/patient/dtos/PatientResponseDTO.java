package com.hosp.patient.dtos;

public class PatientResponseDTO {

    private String name;
    private String address;
    private String number;
    private String cpf;

    public PatientResponseDTO(String name, String cpf, String number, String address) {
        this.name = name;
        this.cpf = cpf;
        this.number = number;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
