package com.tourhelper.tourhelperservice.controller;

import com.tourhelper.tourhelperservice.dto.AccountDto;
import com.tourhelper.tourhelperservice.exception.AccountAlreadyExistException;
import com.tourhelper.tourhelperservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/createAccount")
    public AccountDto createAccount(@RequestBody AccountDto account) throws AccountAlreadyExistException {
        return accountService.createAccount(account);
    }
}
