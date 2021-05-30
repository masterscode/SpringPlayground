package spring.springdemo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloApp {
    @RequestMapping("/api")
    public String scatter(){
        return "<h1>you are scatttered!!!</h1>";
    }
}
