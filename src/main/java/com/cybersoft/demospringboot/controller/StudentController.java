package com.cybersoft.demospringboot.controller;

import com.cybersoft.demospringboot.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private static List<Student> studentList = new ArrayList<>();

    @PostMapping("")
    public ResponseEntity<?> insertStudentByRequestParam(
            @RequestParam String name,
            @RequestParam int age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        studentList.add(student);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("/{name}/{age}")
    public ResponseEntity<?> insertStudentByPathVariable(
            @PathVariable String name,
            @PathVariable int age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        studentList.add(student);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> insertStudentByRequestBody(
            @RequestBody Student student) {
        studentList.add(student);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}
