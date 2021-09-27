package com.example.demo.controller;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRep;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/company")
public class CompanyController {
   private CompanyRep companyRep;

   private UserRepository userRepository;

    @GetMapping("/listCompany")
    public List<Company> addToListCompany(){
        return companyRep.findAll();
    }

}
