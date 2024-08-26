package com.project.samplecrud_sb.model.entity;

import com.project.samplecrud_sb.infrastructure.model.entity.BaseEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "order_details")
public class OrderDetailsEntity extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer qty;

    @Column(nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId",nullable = false,referencedColumnName = "id")
    private OrderEntity order;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsEntity that = (OrderDetailsEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(productName, that.productName) && Objects.equals(qty, that.qty) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), productName, qty, price);
    }
}
