package com.zhao.could.product.service.impl;

import com.zhao.could.product.mapper.ProductMapper;
import com.zhao.could.product.service.IProductService;
import com.zhao.could.product.vo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public Product get(long id) {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }

    @Override
    public boolean add(Product product) {
        return productMapper.create(product);
    }
}
