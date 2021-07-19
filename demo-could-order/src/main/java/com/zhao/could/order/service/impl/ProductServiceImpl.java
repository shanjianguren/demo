package com.zhao.could.order.service.impl;

import com.zhao.could.order.service.OrderService;
import com.zhao.could.product.vo.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
@Service
class OrderServiceImpl implements OrderService {

    public static final String PRODUCT_QUERY_URL="http://localhost:10001";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders httpHeaders;
    @Override
    public Object list() {
        return restTemplate.exchange(PRODUCT_QUERY_URL+"product/list",HttpMethod.GET,new HttpEntity<Object>(httpHeaders),List.class).getBody();
    }

    @Override
    public Object findOne(Long id) {
        return restTemplate.exchange(PRODUCT_QUERY_URL+"product/"+id,HttpMethod.GET,new HttpEntity<Object>(httpHeaders),Product.class).getBody();
    }
}
