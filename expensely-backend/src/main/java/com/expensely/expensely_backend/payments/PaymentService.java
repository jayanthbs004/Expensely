package com.expensely.expensely_backend.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        long sequence = sequenceGenerator.generateSequence("payment_sequence");
        payment.setPaymentId(String.format("PAY%03d", sequence)); // PAY001, PAY002, etc.
        return paymentRepository.save(payment);
    }


    public List<Payment> getPaymentsForGroup(String groupId) {
        return paymentRepository.findByGroupId(groupId);
    }

    public List<Payment> getPendingPaymentsForUser(String userId) {
        return paymentRepository.findByToUserIdAndIsSettledFalse(userId);
    }

    public List<Payment> getPaymentsByGroupId(String groupId) {
        return paymentRepository.findByGroupId(groupId);
    }

    public Payment markAsSettled(String paymentId, String recipientUserId) {
        Payment payment = paymentRepository.findByPaymentId(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found."));

        if (!payment.getToUserId().equals(recipientUserId)) {
            throw new RuntimeException("Only the recipient can mark this payment as settled.");
        }

        payment.setSettled(true);
        payment.setSettledAt(LocalDateTime.now());
        return paymentRepository.save(payment);
    }
}

