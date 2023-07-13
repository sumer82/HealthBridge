package com.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Doctor;
import com.application.model.Schedule;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findBySpecialization(String specialization);
 
    //List<Schedule> getScheduleByDoctorId(Long doctorId);
    
    // add other methods as per your requirements
}
