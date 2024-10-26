package com.orderingsystem.orderservicedomain.dto.message;

import com.orderingsystem.valueobject.OrderApprovalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ShopApprovalResponse {
    private String id;
    private String sagaId;
    private String orderId;
    private String shopId;
    private Instant createdAt;
    private OrderApprovalStatus orderApprovalStatus;
    private List<String> failureMessages;
}
