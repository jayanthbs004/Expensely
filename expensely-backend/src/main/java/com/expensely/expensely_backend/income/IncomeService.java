package com.expensely.expensely_backend.income;


import com.expensely.expensely_backend.transactions.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String TRANSACTION_SERVICE_URL = "http://localhost:8080/api/transactions";

    public Income addIncome(Income income) {
        // Save income to DB
        income.setId(UUID.randomUUID().toString());
        Income savedIncome = incomeRepository.save(income);

        // Send transaction to transaction service
        TransactionsRequest txn = TransactionsRequest.builder()
                .userId(income.getUserId())
                .groupId(null)
                .type(TransactionType.CREDIT)
                .amount(income.getAmount())
                .category("Income")
                .subCategory(income.getSource())
                .timestamp(LocalDateTime.now())
                .build();

        try {
            restTemplate.postForObject(TRANSACTION_SERVICE_URL, txn, String.class);
        } catch (Exception e) {
            System.out.println("⚠️ Failed to create transaction for income: " + e.getMessage());
        }

        return savedIncome;
    }

    public List<Income> getIncomesByUserId(String userId) {
        return incomeRepository.findByUserId(userId);
    }

    public Income getIncomeById(String id) {
        return incomeRepository.findById(id).orElse(null);
    }

    public Income updateIncome(String id, Income income) {
        income.setId(id);
        return incomeRepository.save(income);
    }

    public boolean deleteIncome(String id) {
        if (incomeRepository.existsById(id)) {
            incomeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
