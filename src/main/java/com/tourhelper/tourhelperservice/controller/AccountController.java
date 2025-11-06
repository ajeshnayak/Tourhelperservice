package com.tourhelper.tourhelperservice.controller;

import com.tourhelper.tourhelperservice.dto.AccountDto;
import com.tourhelper.tourhelperservice.exception.AccountAlreadyExistException;
import com.tourhelper.tourhelperservice.exception.AccountDoesnotExistException;
import com.tourhelper.tourhelperservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/createAccount")
    public AccountDto createAccount(@RequestBody AccountDto account) throws AccountAlreadyExistException {
        return accountService.createAccount(account);
    }

    @DeleteMapping("/deleteAccount")
    public AccountDto deleteAccount(@RequestBody AccountDto account) throws AccountDoesnotExistException {
        return accountService.deleteAccount(account);
    }
}
