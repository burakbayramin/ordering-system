package com.orderingsystem.orderservicedomain.ports.input.messagelistener.shopapproval;

import com.orderingsystem.orderservicedomain.dto.message.ShopApprovalResponse;

public interface ShopApprovalResponseMessageListener {

    void orderApproved(ShopApprovalResponse shopApprovalResponse);

    void orderRejected(ShopApprovalResponse shopApprovalResponse);
}
