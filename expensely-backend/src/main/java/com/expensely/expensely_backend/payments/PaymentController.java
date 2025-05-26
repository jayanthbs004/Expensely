package com.expensely.expensely_backend.payments;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @GetMapping("/groups/{groupId}")
    public List<Payment> getPaymentsByGroupId(@PathVariable String groupId) {
        return paymentService.getPaymentsByGroupId(groupId);
    }


    @GetMapping("/pending/{userId}")
    public List<Payment> getPendingPayments(@PathVariable String userId) {
        return paymentService.getPendingPaymentsForUser(userId);
    }

    @PostMapping("/settle/{paymentId}")
    public Payment markAsSettled(@PathVariable String paymentId, @RequestParam String recipientUserId) {
        return paymentService.markAsSettled(paymentId, recipientUserId);
    }

    @PatchMapping("/{paymentId}/settle")
    public Payment patchSettlePayment(@PathVariable String paymentId, @RequestParam String recipientUserId) {
        return paymentService.markAsSettled(paymentId, recipientUserId);
    }

}
