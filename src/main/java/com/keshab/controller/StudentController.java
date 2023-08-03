package com.keshab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keshab.entity.Student;
import com.keshab.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public ResponseEntity<?> createStudent(@RequestBody Student student) {
		List<String> errors = studentService.validateStudent(student);
		if (!errors.isEmpty()) {
			return ResponseEntity.badRequest().body(errors);
		}

		student.setTotal(studentService.calculateTotalMarks(student));

		Student createdStudent = studentService.createStudent(student);
		return ResponseEntity.ok(createdStudent);
	}
}
