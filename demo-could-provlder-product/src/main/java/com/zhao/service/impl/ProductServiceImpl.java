package com.zhao.service.impl;

import com.zhao.mapper.ProductMapper;
import com.zhao.service.IProductService;
import com.zhao.vo.Product;
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
    public boolean add(Product product) {
        return productMapper.create(product);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }
}
