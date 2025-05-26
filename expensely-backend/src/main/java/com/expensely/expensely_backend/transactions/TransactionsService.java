package com.expensely.expensely_backend.transactions;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
class TransactionsService {
    private final TransactionsRepository transactionsRepository;
    private final AtomicInteger counter = new AtomicInteger(1);
    private final TransactionIdGenerator transactionIdGenerator;

    public Transactions createTransaction(Transactions transactions) {
        transactions.setId(transactionIdGenerator.generateNextTransactionId());
        transactions.setTimestamp(LocalDateTime.now());
        return transactionsRepository.save(transactions); // This must return the saved entity
    }


    public List<Transactions> getAllTransactions() {
        return transactionsRepository.findAll(Sort.by(Sort.Direction.DESC, "timestamp"));
    }

    public List<Transactions> getByUserId(String userId) {
        return transactionsRepository.findByUserId(userId);
    }

    public List<Transactions> getByGroupId(String groupId) {
        return transactionsRepository.findByGroupId(groupId);
    }

    public Optional<Transactions> getById(String id) {
        return transactionsRepository.findById(id);
    }

    private String generateTransactionId() {
        int current = counter.getAndIncrement();
        return String.format("TXN%04d", current);
    }
}