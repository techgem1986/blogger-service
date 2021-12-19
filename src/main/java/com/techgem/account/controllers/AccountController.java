package com.techgem.account.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/account")
@RestController
public class AccountController {

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Success";
    }

}
