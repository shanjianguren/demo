package com.zhao.could.product.service;

import com.zhao.could.product.vo.Product;

import java.util.List;

public interface IProductService {
    Product get(long id);
    boolean add(Product product);
    List<Product> list();
}
