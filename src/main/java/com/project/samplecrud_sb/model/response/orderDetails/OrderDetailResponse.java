package com.project.samplecrud_sb.model.response.orderDetails;


import com.project.samplecrud_sb.model.entity.OrderDetailsEntity;

import java.io.Serializable;

public class OrderDetailResponse implements Serializable {

    private Long id;
    private String productName;
    private Double price;
    private Integer qty;

    public OrderDetailResponse(Long id, String productName, Double price, Integer qty) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.qty = qty;
    }

    public static OrderDetailResponse fromEntity(OrderDetailsEntity entity){
        return new OrderDetailResponse(
                entity.getId(),
                entity.getProductName(),
                entity.getPrice(),
                entity.getQty()        );
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQty() {
        return qty;
    }
}
