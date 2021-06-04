package spring.springdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springdemo.models.GitProfile;
import spring.springdemo.services.ThirdPartyAPIService;

@RestController
public class IndexController {
    @Autowired
    ThirdPartyAPIService apiService;
    @GetMapping("/")
    public ResponseEntity<GitProfile> getIndex() {
        return
                ResponseEntity.ok(apiService.getUserProfile() );
    }

    @GetMapping("/webclient")
    public ResponseEntity<?> getUserProfile(){
        return ResponseEntity.ok(
                apiService.getUserProfileWithWebClient()
        );
    }
} 
