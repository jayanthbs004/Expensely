package com.expensely.expensely_backend.income;

import com.expensely.expensely_backend.transactions.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionsRequest {
    private String userId;
    private String groupId; // null for personal income
    private TransactionType type;
    private double amount;
    private String category;
    private String subCategory;
    private String account;
    private String description;
    private LocalDateTime timestamp;
}
