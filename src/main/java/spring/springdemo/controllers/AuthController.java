package spring.springdemo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.springdemo.models.User;
import spring.springdemo.models.auth.AuthRequest;
import spring.springdemo.models.auth.AuthResponse;
import spring.springdemo.models.auth.RegisterUser;
import spring.springdemo.security.util.JWTUtil;
import spring.springdemo.services.UserService;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<?> doLogin(@RequestBody AuthRequest request) throws Exception{
        System.err.println("in login");
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(), request.getPassword()
                        ));
        System.err.println("line 2");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.err.println("line 3");

        User userDetails = (User) userService.loadUserByUsername(request.getEmail());
        System.err.println(userDetails);
        final String jwtToken = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(jwtToken));
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterUser registerUser){
        User user = new User(registerUser.getEmail(),
                registerUser.getUsername(),
                encoder.encode(registerUser.getPassword()));

        return userService.saveUser(user);
    }
}

