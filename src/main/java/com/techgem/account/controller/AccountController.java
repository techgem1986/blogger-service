package com.techgem.account.controller;

import com.techgem.account.model.Account;
import com.techgem.account.repository.AccountRepository;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/account")
@RestController
@Api(value="AccountController")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountRepository accountRepository;

    @GetMapping(path = "/getAll")
    public List<Account> getAllAccount() {
        logger.info("Entering getAllAccount method");
        return accountRepository.getAllAccount();
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public Account addAccount(@RequestBody Account account) {
        logger.info("Entering addAccount method");
        accountRepository.addAccount(account);
        return account;
    }

    @PostMapping(path = "/delete", consumes = "application/json")
    public void deleteAccount(@RequestBody Account account) {
        logger.info("Entering deletAccount method");
        accountRepository.deleteAccount(account);
    }

}
