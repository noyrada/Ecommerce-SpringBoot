package com.project.samplecrud_sb.model.request.orderDetails;


import java.io.Serializable;

public class OrderDetailRequest implements Serializable {

    private String productName;
    private Integer gty;
    private Double price;

    public OrderDetailRequest(String productName, Integer gty, Double price) {
        this.productName = productName;
        this.gty = gty;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getGty() {
        return gty;
    }

    public void setGty(Integer gty) {
        this.gty = gty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
