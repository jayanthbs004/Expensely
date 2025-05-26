package com.expensely.expensely_backend.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public List<Budget> getBudgetsByUser(String userId) {
        return budgetRepository.findByUserId(userId);
    }

    public List<Budget> getBudgetsByUserAndMonth(String userId, int month, int year) {
        return budgetRepository.findByUserIdAndMonthAndYear(userId, month, year);
    }

    public Budget updateBudget(String id, Budget updated) {
        return budgetRepository.findById(id).map(b -> {
            b.setLimit(updated.getLimit());
            b.setCategory(updated.getCategory());
            b.setMonth(updated.getMonth());
            b.setYear(updated.getYear());
            return budgetRepository.save(b);
        }).orElse(null);
    }

    public void deleteBudget(String id) {
        budgetRepository.deleteById(id);
    }
}
