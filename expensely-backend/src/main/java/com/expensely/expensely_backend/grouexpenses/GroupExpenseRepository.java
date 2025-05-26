package com.expensely.expensely_backend.grouexpenses;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GroupExpenseRepository extends MongoRepository<GroupExpense, String> {
    List<GroupExpense> findByGroupId(String groupId);
}

