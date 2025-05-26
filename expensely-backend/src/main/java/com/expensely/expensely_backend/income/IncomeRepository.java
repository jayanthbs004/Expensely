package com.expensely.expensely_backend.income;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IncomeRepository extends MongoRepository<Income, String> {
    // Custom query methods can be added if needed, e.g., to get all incomes by userId
    List<Income> findByUserId(String userId);
}
