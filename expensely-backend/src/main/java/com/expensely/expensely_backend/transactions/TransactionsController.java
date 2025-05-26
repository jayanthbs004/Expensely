package com.expensely.expensely_backend.transactions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionsController {
    private final TransactionsService transactionService;

    @PostMapping
    public Transactions createTransaction(@RequestBody Transactions transactions) {
        return transactionService.createTransaction(transactions);
    }

    @GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions() {
        List<Transactions> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/users/{userId}")
    public List<Transactions> getByUser(@PathVariable String userId) {
        return transactionService.getByUserId(userId);
    }

    @GetMapping("/groups/{groupId}")
    public List<Transactions> getByGroup(@PathVariable String groupId) {
        return transactionService.getByGroupId(groupId);
    }

    @GetMapping("/{id}")
    public Transactions getById(@PathVariable String id) {
        return transactionService.getById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}
