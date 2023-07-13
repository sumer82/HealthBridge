package com.application.service;

import java.util.List;

import com.application.model.Appointment;
import com.application.model.Patient;
import com.application.model.Prescription;

public interface PatientService {
    Patient createPatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    void deletePatientById(Long id);
    List<Appointment> getAppointmentsByPatientId(Long patientId);
    Prescription createPrescription(Prescription prescription);
    List<Prescription> getPrescriptionsByPatientId(Long patientId);
	Patient updatePatient(Long patientId, Patient patientDetails);
}

