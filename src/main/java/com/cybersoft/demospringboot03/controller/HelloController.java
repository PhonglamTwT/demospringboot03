package com.cybersoft.demospringboot03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller : Chi xai khi duong dan dang quy dinh tra ra la file html
 * @ResponseBody : Giup cho @Controller co the tra ra kieu String dung de viet API
 *
 * @RestController : Chi su dung khi noi dung tra ra la API, String (Ket hop cua @Controller va @ResponseBody) => Viet API
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("")
    public String hello(){
        return "Hello Spring boot";
    }

    @GetMapping("/cybersoft")
    public String helloCybersoft(){
        return "Hello Spring Cybersoft";
    }
}
