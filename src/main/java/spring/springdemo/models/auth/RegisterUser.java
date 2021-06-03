package spring.springdemo.models.auth;

import lombok.Data;

@Data
public class RegisterUser {
    private String email;
    private String password;
    private String username;
}
