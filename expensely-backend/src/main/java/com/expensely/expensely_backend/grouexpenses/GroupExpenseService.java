package com.expensely.expensely_backend.grouexpenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupExpenseService {

    @Autowired
    private GroupExpenseRepository groupExpenseRepository;

    public GroupExpense addGroupExpense(GroupExpense expense) {
        return groupExpenseRepository.save(expense);
    }

    public List<GroupExpense> getExpensesByGroup(String groupId) {
        return groupExpenseRepository.findByGroupId(groupId);
    }

    public List<GroupExpense> getAll() {
        return groupExpenseRepository.findAll();
    }
}

