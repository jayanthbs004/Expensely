package com.expensely.expensely_backend.transactions;

import java.util.List;

public interface TransactionsRepository extends org.springframework.data.mongodb.repository.MongoRepository<Transactions, String> {
    List<Transactions> findByUserId(String userId);
    List<Transactions> findByGroupId(String groupId);
}
