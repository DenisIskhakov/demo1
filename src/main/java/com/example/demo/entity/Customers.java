package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private Integer age;
    private String firstName;
    private String lastName;
    private String phone;



    @OneToOne(mappedBy = "customers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customers") // избавляемся от циркулярной ошибки(StackOverFlow)
    private Orders orders;

    @ManyToOne()
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;
}