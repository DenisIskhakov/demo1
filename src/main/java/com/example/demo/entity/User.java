package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "user")

    private List<Customers> list = new ArrayList<>();

   public void addToList(Customers customer){
       list.add(customer);
   }
   @ManyToMany(mappedBy = "userList",cascade = CascadeType.PERSIST) // Bidirection - связь
   public List<Company> companyList = new ArrayList<>();

   public void addToListCompany (Company company){
       companyList.add(company);
   }
}
