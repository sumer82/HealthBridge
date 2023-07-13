package com.application.service;

import java.util.List;

import com.application.model.Appointment;
import com.application.model.Doctor;
import com.application.model.Schedule;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
    List<Doctor> getAllDoctors();
    void deleteDoctorById(Long id);
    List<Appointment> getAppointmentsByDoctorId(Long doctorId);
   
}
