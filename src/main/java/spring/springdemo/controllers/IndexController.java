package spring.springdemo.controllers;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public ResponseEntity<String> getIndex(){
        return
                new ResponseEntity<String>(" You are Authenticated!!!", HttpStatus.OK);
    }
} 
