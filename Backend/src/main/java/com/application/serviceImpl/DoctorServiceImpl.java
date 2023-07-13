package com.application.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Appointment;
import com.application.model.Doctor;
import com.application.model.Schedule;
import com.application.repository.DoctorRepository;
import com.application.repository.ScheduleRepository;
import com.application.service.DoctorService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private ScheduleRepository scheduleRepository;
    
    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    
    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    
    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
    
    @Override
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return doctorRepository.findById(doctorId).orElse(null).getAppointments();
    }
    
    
}

