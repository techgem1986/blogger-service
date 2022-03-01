package com.techgem.account.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/account")
@RestController
@Api(value="AccountController")
public class AccountController {

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Welcome Sandipan!";
    }

}
