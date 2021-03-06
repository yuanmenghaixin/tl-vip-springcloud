package com.tuling.controller;

import com.tuling.vo.OrderVo;
import com.tuling.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;


/**
 * Created by smlz on 2019/5/6.
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/queryOrderInfoById/{userId}")
    public OrderVo queryOrderInfoById(@PathVariable("userId") Integer userId) {
        log.info("根据用户id{}查询订单信息",userId);
        OrderVo orderVo = new OrderVo();
        orderVo.setUserId(userId);
        orderVo.setOrderId(1);
        orderVo.setOrderMoney(new BigDecimal(1900));
        orderVo.setDbSource("test db");

        if(userId==1) {
            throw new RuntimeException("人为抛出异常");
        }

        return orderVo;
    }
}
