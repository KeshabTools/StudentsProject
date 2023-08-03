package com.keshab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keshab.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
