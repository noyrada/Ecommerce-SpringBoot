package com.project.samplecrud_sb.model.request.order;

import com.project.samplecrud_sb.model.entity.OrderEntity;
import com.project.samplecrud_sb.model.request.orderDetails.OrderDetailRequest;

import java.io.Serializable;
import java.util.List;

public class OrderRequest implements Serializable {

    private String customerName;
    private List<OrderDetailRequest> details;

    public OrderEntity toEntity(){
        OrderEntity order = new OrderEntity();
        order.setCustomerName(this.customerName);
        return order;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderDetailRequest> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailRequest> details) {
        this.details = details;
    }
}
