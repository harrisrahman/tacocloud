package org.study.pcfdevcert.controller;

import org.springframework.web.bind.annotation.GetMapping;

// Not used
// see tacos.configuration.TacoViewConfigurer
public class HomeController {

    @GetMapping(path = "/")
    public String home(){
        return "home";
    }
}
