package com.orderingsystem.orderservicedomain.ports.input.messagelistener.payment;

import com.orderingsystem.orderservicedomain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
