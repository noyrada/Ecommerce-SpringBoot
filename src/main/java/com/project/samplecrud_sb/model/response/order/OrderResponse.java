package com.project.samplecrud_sb.model.response.order;

import com.project.samplecrud_sb.model.entity.OrderEntity;
import com.project.samplecrud_sb.model.response.orderDetails.OrderDetailResponse;

import java.io.Serializable;
import java.util.List;

public class OrderResponse implements Serializable {

    private Long id;
    private String customerName;
    private Double totalPrice;

    private List<OrderDetailResponse> details;

    public OrderResponse(Long id, String customerName, Double totalPrice, List<OrderDetailResponse> details) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.details = details;
    }

    public static OrderResponse fromEntity(OrderEntity entity){
        return new OrderResponse(
                entity.getId(),
                entity.getCustomerName(),
                entity.getTotalPrice(),
                entity.getOrderDetails().stream().map(OrderDetailResponse::fromEntity).toList()
        );
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public List<OrderDetailResponse> getDetails() {
        return details;
    }
}
