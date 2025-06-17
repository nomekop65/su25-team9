package com.example.backend_api.Products;

import jakarta.persistence.*;

@Entity
@Table(name = "item_types") // Use your actual table name
public class Product {
    @Id
    private Integer typeid;
    private String typename;

    public Integer getId() { return typeid; }
    public void setId(Integer typeid) { this.typeid = typeid; }

    public String getName() { return typename; }
    public void setName(String typename) { this.typename = typename; }
}