package com.zhao.controller;

import com.zhao.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProductController {
    @Resource
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
