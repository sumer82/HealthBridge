package com.application.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Appointment;
import com.application.model.Patient;
import com.application.model.Prescription;
import com.application.repository.PatientRepository;
import com.application.repository.PrescriptionRepository;
import com.application.service.PatientService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    
    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    
    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    
    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }
    
    @Override
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return patientRepository.findById(patientId).orElse(null).getAppointments();
    }
    
    @Override
    public Prescription createPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }
    
    @Override
    public List<Prescription> getPrescriptionsByPatientId(Long patientId) {
        return prescriptionRepository.findByPatientId(patientId);
    }

	@Override
	public Patient updatePatient(Long patientId, Patient patientDetails) {
		// TODO Auto-generated method stub
		return null;
	}
}
