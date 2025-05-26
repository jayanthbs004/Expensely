package com.expensely.expensely_backend.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/budgets")
@CrossOrigin(origins = "*")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @PostMapping
    public Budget createBudget(@RequestBody Budget budget) {
        return budgetService.createBudget(budget);
    }

    @GetMapping("/user/{userId}")
    public List<Budget> getBudgetsByUser(@PathVariable String userId) {
        return budgetService.getBudgetsByUser(userId);
    }

    @GetMapping("/user/{userId}/{month}/{year}")
    public List<Budget> getBudgetsByUserAndMonth(@PathVariable String userId,
                                                 @PathVariable int month,
                                                 @PathVariable int year) {
        return budgetService.getBudgetsByUserAndMonth(userId, month, year);
    }

    @PutMapping("/{id}")
    public Budget updateBudget(@PathVariable String id, @RequestBody Budget budget) {
        return budgetService.updateBudget(id, budget);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable String id) {
        budgetService.deleteBudget(id);
    }
}
