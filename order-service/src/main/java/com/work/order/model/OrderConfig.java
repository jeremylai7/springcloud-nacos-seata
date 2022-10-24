package com.work.order.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: laizc
 * @date: created in 2022/10/23
 * @desc:
 **/
@ConditionalOnBean(DataSource.class)
public class OrderConfig {

    @Bean
    public Order order() {
        Order order = new Order();
        order.setSn("345");
        return order;
    }
}
