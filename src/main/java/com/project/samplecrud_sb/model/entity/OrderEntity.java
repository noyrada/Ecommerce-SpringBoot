package com.project.samplecrud_sb.model.entity;

import com.project.samplecrud_sb.infrastructure.model.entity.BaseEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity<Long> {

    @Column(length = 50,nullable = false)
    private String customerName;

    @Column(nullable = false)
    private Double TotalPrice;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderDetailsEntity> orderDetails;

    public List<OrderDetailsEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        TotalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(customerName, that.customerName) && Objects.equals(TotalPrice, that.TotalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), customerName, TotalPrice);
    }
}
