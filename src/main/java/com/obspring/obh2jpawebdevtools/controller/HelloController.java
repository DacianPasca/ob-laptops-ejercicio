package com.obspring.obh2jpawebdevtools.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saludo") // método que retorna un saludo
    public String saludo(){
        return "¡Saludos Invocador!";
    }
}
