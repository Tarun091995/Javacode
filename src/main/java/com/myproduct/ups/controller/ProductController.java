package com.myproduct.ups.controller;

import com.myproduct.ups.model.Product;
import com.myproduct.ups.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // this specifies that the class is fpr  rest api
@Api(value = "Product Controller")//this line specifies the api value

@RequestMapping("/rest")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
//    public ResponseEntity<String> helloWorld()
//    {
//        return  new ResponseEntity<String>("hello world", HttpStatus.OK);
//    }

    @RequestMapping(value = "/products",method = RequestMethod.POST)
    @ApiOperation("Create Product")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody ResponseEntity createProduct(@RequestBody Product product)
    {
        System.out.println("Product Id"+product.getProduct_id());
        System.out.println("Product Name" + product.getProduct_name());
        System.out.println("Product Manufacturer"  + product.getProduct_manufacturer());
        System.out.println("Product Model Name" + product.getProduct_model_number());
        System.out.println("Product Warranty" + product.getWarranty());

        Product productfromdb = productService.createProduct(product);
        return new ResponseEntity<Product>(productfromdb,HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "products/",method = RequestMethod.GET)
    @ApiOperation("Fetch all Products")
    public @ResponseBody ResponseEntity getAllProducts()
    {
        List<Product> allproducts = productService.Allproducts();
        return new ResponseEntity<List<Product>>(allproducts,HttpStatus.OK);
    }

}
