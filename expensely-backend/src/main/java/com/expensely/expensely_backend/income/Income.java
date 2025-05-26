package com.expensely.expensely_backend.income;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "income")
public class Income {

    @Id
    private String id;

    private String userId;        // User who earned the income
    private double amount;         // Amount of the income
    private String source;         // Source of the income (e.g., salary, freelance)
    private String frequency;      // Frequency of income (e.g., monthly, weekly)
    private String category;       // Category for income (e.g., salary, gift)
    private String transactionId; // ID from the Transaction microservice

    // Default constructor
    public Income() {}

    // Constructor with fields
    public Income(String userId, double amount, String source, String frequency, String category) {
        this.userId = userId;
        this.amount = amount;
        this.source = source;
        this.frequency = frequency;
        this.category = category;
    }
}
