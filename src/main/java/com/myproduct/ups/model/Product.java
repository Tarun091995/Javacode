package com.myproduct.ups.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity//1
@Table(name="product")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Product {
    @Id
    @Column(name="id",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="product_name")
    private String product_name;

    @Column(name="product_id")
    private int product_id;

    @Column(name="product_manufacturer")
    private String product_manufacturer;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Column(name = "product_model_number")
    private String product_model_number;

    @Column(name ="warranty")
    private String warranty;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }



    public String getProduct_manufacturer() {
        return product_manufacturer;
    }

    public void setProduct_manufacturer(String product_manufacturer) {
        this.product_manufacturer = product_manufacturer;
    }

    public String getProduct_model_number() {
        return product_model_number;
    }

    public void setProduct_model_number(String product_model_number) {
        this.product_model_number = product_model_number;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Product Details {" +
                "Product Name" + product_name +
                "Product Manufacture " + product_manufacturer +
                "Product Model Number" + product_model_number +
                "Product Warrant" + warranty +
                "Product Id" + product_id +
    "}";
    }
}










