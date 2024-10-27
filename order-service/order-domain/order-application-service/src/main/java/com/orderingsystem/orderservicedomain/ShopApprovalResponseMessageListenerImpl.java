package com.orderingsystem.orderservicedomain;

import com.orderingsystem.orderservicedomain.dto.message.ShopApprovalResponse;
import com.orderingsystem.orderservicedomain.ports.input.messagelistener.shopapproval.ShopApprovalResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
public class ShopApprovalResponseMessageListenerImpl implements ShopApprovalResponseMessageListener {

    @Override
    public void orderApproved(ShopApprovalResponse shopApprovalResponse) {

    }

    @Override
    public void orderRejected(ShopApprovalResponse shopApprovalResponse) {

    }
}
