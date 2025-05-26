package com.expensely.expensely_backend.payments;


import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends MongoRepository<Payment, String> {
    List<Payment> findByGroupId(String groupId);
    List<Payment> findByToUserIdAndIsSettledFalse(String userId);
    Optional<Payment> findByPaymentId(String paymentId);
}
