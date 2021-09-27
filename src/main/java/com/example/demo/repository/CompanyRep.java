package com.example.demo.repository;

import com.example.demo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRep extends JpaRepository<Company,Long> {
}
