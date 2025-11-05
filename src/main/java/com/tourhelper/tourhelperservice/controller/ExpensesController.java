package com.tourhelper.tourhelperservice.controller;

import com.tourhelper.tourhelperservice.dto.Expenses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    @PostMapping("/addExpense")
    public Expenses addExpense(@RequestBody Expenses expenses){
        return null;
    }
}
