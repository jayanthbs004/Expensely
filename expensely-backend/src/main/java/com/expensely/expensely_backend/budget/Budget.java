package com.expensely.expensely_backend.budget;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "budgets")
public class Budget {

    @Id
    private String id;

    private String userId;      // User associated with this budget
    private String category;    // Category like "Food", "Rent", etc.
    private int month;          // 1-12 for Jan–Dec
    private int year;           // e.g., 2025
    private double limit;       // Max allowed spending
    private double spent;       // Auto-updated from expenses (optional for now)

    public Budget() {}

    public Budget(String userId, String category, int month, int year, double limit) {
        this.userId = userId;
        this.category = category;
        this.month = month;
        this.year = year;
        this.limit = limit;
        this.spent = 0;
    }
}

