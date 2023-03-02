package com.tms.controller;

import com.tms.domain.ProductExample;
import com.tms.repository.ProductExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/productexample", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductExampleController {

    private final ProductExampleRepository productExampleRepository;

    @Autowired
    public ProductExampleController(ProductExampleRepository productExampleRepository) {
        this.productExampleRepository = productExampleRepository;
    }

    @GetMapping
    public ResponseEntity<ArrayList<ProductExample>> getAllProductsEx() {
        return new ResponseEntity<>(productExampleRepository.getAllProductEx(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductExample> getProductById(@PathVariable int id) {
        ProductExample product = productExampleRepository.getProductExampleById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}