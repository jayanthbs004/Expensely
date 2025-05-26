package com.expensely.expensely_backend.transactions;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;




@Document(collection = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transactions {
    @Id
    private String id; // TXN0001, TXN0002 ...

    private String userId;
    private String groupId; // Optional
    private TransactionType type;
    private double amount;
    private String category;
    private String subCategory;
    private String account;
    private String description;
    private LocalDateTime timestamp;
}
