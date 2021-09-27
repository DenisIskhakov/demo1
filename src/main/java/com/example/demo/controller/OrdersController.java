package com.example.demo.controller;

import com.example.demo.entity.Customers;
import com.example.demo.entity.Orders;
import com.example.demo.repository.CustomerRep;
import com.example.demo.repository.OrdersRep;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersRep ordersRep;
    private final CustomerRep customerRep;
    @GetMapping("/get")
    public List<Orders> getList(){
        return ordersRep.findAll();
    }
    @PostMapping("/post")
    public Orders postList(@RequestBody Orders orders){
        return ordersRep.save(orders);
    }
    @GetMapping("/{id}")
    public Orders getId(@PathVariable int id){
        return ordersRep.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Категория с указаным ID %d не найден", id)));
    }
    @PutMapping("customers/{id}")
    public Orders getOrders(@PathVariable int id, @RequestBody Customers customers){
        Orders orders = ordersRep.findById(id).get();
        orders.setCustomers(customers);
        customers.setOrders(orders);
        customerRep.save(customers);
        return ordersRep.save(orders);
    }
}
