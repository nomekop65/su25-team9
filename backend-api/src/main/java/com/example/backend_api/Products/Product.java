package com.example.backend_api.Products;

import jakarta.persistence.*;

@Entity
@Table(name = "item_types") // Use your actual table name
public class Product {
    @Id
    private Integer typeid;
    @Column(name = "typename")
    private String name;

    public Integer getId() { return typeid; }
    public void setId(Integer typeid) { this.typeid = typeid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}