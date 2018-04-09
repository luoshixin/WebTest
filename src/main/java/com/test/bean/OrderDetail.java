package com.test.bean;

/**
 * 订单详情（一个订单里面可能会有很多的订单详情，因为可能会买很多的商品）
 */
public class OrderDetail {
    //订单详情的id
    private Integer id;
    //商品的id
    private Integer itemId;
    //商品的数量
    private Integer itemNum;
}
