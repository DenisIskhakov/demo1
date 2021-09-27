package com.example.demo.controller;

import com.example.demo.entity.Customers;
import com.example.demo.entity.Orders;
import com.example.demo.repository.CustomerRep;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomersController {
    private final CustomerRep customerRep;

    @GetMapping("/get")
    public List<Customers> getList(){
        return customerRep.findAll();
    }
    @PostMapping("/post")
    public Customers postList(@RequestBody Customers customers){
        return customerRep.save(customers);
    }
    @GetMapping("/{id}")
    public Customers getId(@PathVariable int id){
        return customerRep.findById(id) // Optinal
                .orElseThrow(() -> new RuntimeException(String.format("Категория с указаным ID %d не найден", id)));
    }
    @PostMapping("/order/{id}")
    public Customers getCustomer( @PathVariable int id,@RequestBody Orders orders){
       Customers customers = customerRep.findById(id).get();
       customers.setOrders(orders);
       return customerRep.save(customers);
    }
}
