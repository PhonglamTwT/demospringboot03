package com.cybersoft.demospringboot03.controller;

import com.cybersoft.demospringboot03.payload.request.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("")
    public String hello(@RequestParam String hoten, @RequestParam int tuoi){
        return "Hello Spring boot " + hoten + " " +tuoi;
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
