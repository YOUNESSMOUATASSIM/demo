package com.example.demo.controller;


import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.service.AuthService;
import com.example.demo.service.MyUserDetailsService;
import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class HomeController  {
    AuthService authService;
    private  final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;
    private  final MyUserDetailsService userDetailsService;

    @Autowired
    public HomeController(AuthenticationManager authenticationManager, JwtUtil jwtTokenUtil,
                          MyUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/home")
    public String getHome() {
        return "Welcome !";
    }



    @PostMapping(value="/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("username ou password est incorrect !", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());



        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));


    }



    @PostMapping(value = "/register-responsable")
    public ResponseEntity<?> saveUserResponsable(@RequestBody UtilisateurDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.saveResponsable(user));
    }
    @PostMapping(value = "/register-admin")
    public ResponseEntity<?> saveUserAdmin(@RequestBody UtilisateurDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.saveAdmin(user));
    }


}
