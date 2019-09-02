package com.zhao.could.product.controller;

import com.zhao.could.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("/product/{id}")
    public Object get(@PathVariable("id") Long id){
        return iProductService.get(id);
    }

    @GetMapping("/product/list")
    public Object list(){
        return iProductService.list();
    }
}
