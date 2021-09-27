package com.example.demo.controller;

import com.example.demo.entity.Company;
import com.example.demo.entity.Customers;
import com.example.demo.entity.Orders;
import com.example.demo.entity.User;
import com.example.demo.repository.CompanyRep;
import com.example.demo.repository.CustomerRep;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    private final CustomerRep customerRep;
    private final CompanyRep companyRep;
    @GetMapping("/list")
    List<User> list(){
        return userRepository.findAll();
    }
    @PostMapping("/addToList/{userId}/{customerId}")
    public User addList(@PathVariable Long userId, @PathVariable int customerId){
        User user = userRepository.findById(userId).get();
        Customers customers = customerRep.findById(customerId).get();
        customers.setUser(user);
        user.addToList(customers);
        return userRepository.save(user);
    }

    @PostMapping("/listUser/{id}")
    public Company addToListUser(@PathVariable Long id , @RequestBody User user){
        Company company = companyRep.findById(id).get();
        company.addToListUser(user);
        return companyRep.save(company);
    }

    @PostMapping("/companyUser/{userId}/{companyId}")
    public User addToListCompany(@PathVariable Long userId,@PathVariable Long companyId){
        User user = userRepository.findById(userId).get();
        Company company1 = companyRep.findById(companyId).get();
        user.addToListCompany(company1);
        company1.addToListUser(user);
        companyRep.save(company1);
        return userRepository.save(user);
    }
}
