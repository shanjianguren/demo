package com.zhao.could.product.mapper;

import com.zhao.could.product.vo.Product;
import org.apache.ibatis.annotations.*;

import javax.annotation.Resource;
import java.util.List;


@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO product(productName,productDesc) VALUES (#{vo.ProductName},#{vo.productDesc})")
    boolean create(@Param("vo") Product vo);
    @Select("select * from product where id=#{id}")
    @Results(id="productMap",value = {
        @Result(column = "id",property = "id"),
        @Result(column = "product_name",property = "productName"),
        @Result(column = "product_desc",property = "productDesc")
    })
    Product findById(@Param("id") Long id);
    @Select("select * from product")
    @ResultMap(value = "productMap")
    List<Product> findAll();
}
