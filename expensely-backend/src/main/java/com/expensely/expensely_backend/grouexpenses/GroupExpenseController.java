package com.expensely.expensely_backend.grouexpenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group-expenses")
@CrossOrigin(origins = "*")
public class GroupExpenseController {

    @Autowired
    private GroupExpenseService groupExpenseService;

    @PostMapping
    public GroupExpense addExpense(@RequestBody GroupExpense expense) {
        return groupExpenseService.addGroupExpense(expense);
    }

    @GetMapping("/group/{groupId}")
    public List<GroupExpense> getExpensesByGroup(@PathVariable String groupId) {
        return groupExpenseService.getExpensesByGroup(groupId);
    }

    @GetMapping
    public List<GroupExpense> getAll() {
        return groupExpenseService.getAll();
    }
}

