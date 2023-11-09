package com.cybersoft.demospringboot03.controller;

import com.cybersoft.demospringboot03.entity.Student;
import com.cybersoft.demospringboot03.entity.UsersEntity;
import com.cybersoft.demospringboot03.payload.request.LoginRequest;
import com.cybersoft.demospringboot03.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Controller : Chi xai khi duong dan dang quy dinh tra ra la file html
 * @ResponseBody : Giup cho @Controller co the tra ra kieu String dung de viet API
 *
 * @RestController : Chi su dung khi noi dung tra ra la API, String (Ket hop cua @Controller va @ResponseBody) => Viet API
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    //Tham so truyen tren trinh duyet: @RequestParam
    //Tham so truyen ngam:  @RequestParam
    //Tham so dong vai tro nhu la 1 duong dan : @PathVariable
    //Tham so ngam la doi tuong: @RequestBody

    @Autowired
    private Student student;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("")
    public ResponseEntity<?> hello(@RequestParam String hoten, @RequestParam int tuoi){
        List<UsersEntity> listUser = userRepository.findAll();
//        return "Hello Spring boot " + hoten + " " +tuoi +" - IOC "+student.getName();
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }

    @PostMapping("/cybersoft")
    public String helloCybersoft(@RequestBody LoginRequest loginRequest) {
        return "Hello Spring Cybersoft " + loginRequest.getUsername() + " - "+loginRequest.getPassword();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id){
        return new ResponseEntity<>("Update "+id, HttpStatus.OK);
    }
}
