package com.project.samplecrud_sb.service;

import com.project.samplecrud_sb.exceptions.NotFoundException;
import com.project.samplecrud_sb.model.entity.OrderDetailsEntity;
import com.project.samplecrud_sb.model.entity.OrderEntity;
import com.project.samplecrud_sb.model.request.order.OrderRequest;
import com.project.samplecrud_sb.model.request.orderDetails.OrderDetailRequest;
import com.project.samplecrud_sb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity create(OrderRequest req) throws Exception {
        //casting req to entity:
        OrderEntity order = req.toEntity();

        //declare variable for store total price & order details:
        double totalPrice = 0.0;
        ArrayList<OrderDetailsEntity> orderDetails = new ArrayList<>();


        for (OrderDetailRequest details: req.getDetails()){
            //Calculate total price:
            totalPrice += (details.getPrice() * details.getGty());

            //set new order details object:
            OrderDetailsEntity orderDetail = new OrderDetailsEntity();
            orderDetail.setProductName(details.getProductName());
            orderDetail.setPrice(details.getPrice());
            orderDetail.setQty(details.getGty());
            orderDetail.setOrder(order);
            //add to master entity:
            orderDetails.add(orderDetail);
        }

        //prepare data:
        order.setTotalPrice(totalPrice);
        order.setOrderDetails(orderDetails);

        try {
            return this.orderRepository.save(order);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    //Find all data: <pagination>
    public List<OrderEntity> findAll(){
        return this.orderRepository.findAll();
    }

    //Find One data by id
    public OrderEntity findOne(Long id) throws NotFoundException {
        return this.orderRepository.findById(id).orElseThrow(()->
                new NotFoundException("Order not found!"));
    }

    //Update data:
    public OrderEntity update(Long id, OrderRequest req) throws Exception {
        //validate id into db exist or not
        OrderEntity findOrder = this.orderRepository.findById(id).orElseThrow(()->
                new NotFoundException("Order not found!"));

        //declare variable for store total price & order details:
        double totalPrice = 0.0;
        ArrayList<OrderDetailsEntity> orderDetails = new ArrayList<>();


        for (OrderDetailRequest details: req.getDetails()){
            //Calculate total price:
            totalPrice += (details.getPrice() * details.getGty());

            //add new order details object:
            OrderDetailsEntity orderDetail = new OrderDetailsEntity();
            orderDetail.setProductName(details.getProductName());
            orderDetail.setPrice(details.getPrice());
            orderDetail.setQty(details.getGty());
            orderDetail.setOrder(findOrder);

            orderDetails.add(orderDetail);
        }

        //prepare data:
        findOrder.setCustomerName(req.getCustomerName());
        findOrder.setTotalPrice(totalPrice);
        findOrder.setOrderDetails(orderDetails);

        try {
            return this.orderRepository.save(findOrder);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    //Delete data:
    public OrderEntity delete(Long id) throws Exception {
        //check and validate id into db:
        OrderEntity foundOrder = this.orderRepository.findById(id).orElseThrow(()->
                new NotFoundException("Order not found!"));

        //
        try {
            this.orderRepository.deleteById(foundOrder.getId());
            return foundOrder;
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    //end crud:
}
