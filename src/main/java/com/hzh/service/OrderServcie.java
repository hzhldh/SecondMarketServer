package com.hzh.service;

import java.util.List;

import com.hzh.entity.Order;

public interface OrderServcie {
	//下单-增加（成功返回编号，错误返回0）
	int addOrder(Order order);
	
	//删除订单
	boolean delOrder(int order_id);
	
	//撤销订单-对于下单者
	boolean revokeOrder(int order_id);
	
	//关闭订单(完成订单等原因)--对于发布者(在我发布物品中进行)
	boolean closeOrder(int goods_id);
	
	//查看订单详情
	Order selectOrderDetail(int order_id);
	
	//查看我收到的订单-用户名
	List<Order> selectOrderByPublisher(String publisher);
	
	//查看我下的订单-用户名
	List<Order> selectOrderByOrderPeople(String order_people);
	
	//统计参与该物品竞拍的人数(订单数)
	int selectOrderCount(int goods_id);
	
	//查询是否重复下单
	int selectRepeatOrder(Order order);
}
