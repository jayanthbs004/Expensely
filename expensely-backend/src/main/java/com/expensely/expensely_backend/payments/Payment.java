package com.expensely.expensely_backend.payments;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "payments")
@Data
public class Payment {

    @Id
    private String id; // MongoDB’s ObjectId

    private String paymentId; // Custom formatted ID like PAY001

    private String groupId;
    private String fromUserId;  // Who owes
    private String toUserId;    // Who is owed
    private double amount;
    private boolean isSettled;
    private LocalDateTime settledAt;
}

