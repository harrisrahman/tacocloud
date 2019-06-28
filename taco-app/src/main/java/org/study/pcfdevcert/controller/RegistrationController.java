package org.study.pcfdevcert.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.study.pcfdevcert.domain.RegistrationForm;
import org.study.pcfdevcert.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping()
    public String registerUser(){
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm registrationForm){
        userRepository.save(registrationForm.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
