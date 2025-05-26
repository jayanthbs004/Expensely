package com.expensely.expensely_backend.income;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
@CrossOrigin(origins = "*")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    // Endpoint to add income
    @PostMapping
    public Income addIncome(@RequestBody Income income) {
        return incomeService.addIncome(income);
    }

    // Endpoint to get all incomes for a user
    @GetMapping("/user/{userId}")
    public List<Income> getIncomesByUserId(@PathVariable String userId) {
        return incomeService.getIncomesByUserId(userId);
    }

    // Endpoint to get income by ID
    @GetMapping("/{id}")
    public Income getIncomeById(@PathVariable String id) {
        return incomeService.getIncomeById(id);
    }

    // Endpoint to update income
    @PutMapping("/{id}")
    public Income updateIncome(@PathVariable String id, @RequestBody Income income) {
        return incomeService.updateIncome(id, income);
    }

    // Endpoint to delete income by ID
    @DeleteMapping("/{id}")
    public boolean deleteIncome(@PathVariable String id) {
        return incomeService.deleteIncome(id);
    }
}
