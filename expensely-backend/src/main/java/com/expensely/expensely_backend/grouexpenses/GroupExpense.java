package com.expensely.expensely_backend.grouexpenses;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "group_expenses")
public class GroupExpense {

    @Id
    private String id;
    private String groupId;
    private String paidByUserId;
    private double totalAmount;
    private String description;

    // List of participants and how much they owe
    private List<SplitDetail> splits;

    @Data
    public static class SplitDetail {
        private String userId;
        private double amount;
    }
}
