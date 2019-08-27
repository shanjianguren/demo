package com.test;

import com.zhao.ProductApplication;
import com.zhao.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = ProductApplication.class)
@RunWith(SpringRunner.class)
public class ProductTest {
    @Autowired
    private IProductService iProductService;

    @Test
    public void testFind(){
        System.out.println(iProductService.get(1));
    }

}
