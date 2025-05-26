package com.expensely.expensely_backend.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionIdGenerator {

    @Autowired
    private TransactionsRepository transactionRepository;

    public String generateNextTransactionId() {
        long count = transactionRepository.count();
        long nextIdNumber = count + 1;
        return String.format("TXN%04d", nextIdNumber);
    }
}
