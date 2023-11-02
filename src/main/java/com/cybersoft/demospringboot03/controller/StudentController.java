package com.cybersoft.demospringboot03.controller;

import com.cybersoft.demospringboot03.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class StudentController {
    ArrayList<Student> liststudent = new ArrayList<Student>();
    @PostMapping("/requestbody")
    public ResponseEntity<?> addStudent(@RequestBody Student studentRequest){
            Student s1 = new Student(studentRequest.getName(),studentRequest.getAge());
            liststudent.add(s1);
            return new ResponseEntity<>(liststudent, HttpStatus.OK);
    }

    @PostMapping("/requestparam")
    public ResponseEntity addStudent1(@RequestParam String name, @RequestParam int age){
        Student s1 = new Student(name,age);
        liststudent.add(s1);
        return new ResponseEntity<>(liststudent, HttpStatus.OK);
    }

    @PostMapping("/pathvariable/{name}/{age}")
    public ResponseEntity addStudent2(@PathVariable String name, @PathVariable int age){
        Student s1 = new Student(name,age);
        liststudent.add(s1);
        return new ResponseEntity<>(liststudent, HttpStatus.OK);
    }
}
