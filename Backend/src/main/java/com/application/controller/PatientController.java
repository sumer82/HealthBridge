package com.application.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.exception.ResourceNotFoundException;
import com.application.model.Patient;
import com.application.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/{patientId}")
    public Patient updatePatient(@PathVariable Long patientId, @RequestBody Patient patientDetails) throws ResourceNotFoundException {
        return patientService.updatePatient(patientId, patientDetails);
    }

    @DeleteMapping("/{patientId}")
    public void deletePatient(@PathVariable Long patientId) throws ResourceNotFoundException {
        patientService.deletePatientById(patientId);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{patientId}")
    public Patient getPatientById(@PathVariable Long patientId) throws ResourceNotFoundException {
        return patientService.getPatientById(patientId);
    }
}


