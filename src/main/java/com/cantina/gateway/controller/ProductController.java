package com.cantina.gateway.controller;

import com.cantina.gateway.request.ProductServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("gateway/products")//pre-path
public class ProductController
{
    @Autowired
    private ProductServiceRequest productServiceRequest;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Object product)
    {
        return new ResponseEntity<>(productServiceRequest.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long productId) throws IOException {
        productServiceRequest.delete(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts()
    {
        return ResponseEntity.ok(productServiceRequest.findByAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Object requestBody)throws IOException {
        return ResponseEntity.ok(productServiceRequest.update(id, requestBody));
    }

}
