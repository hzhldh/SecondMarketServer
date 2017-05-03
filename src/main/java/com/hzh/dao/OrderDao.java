package com.hzh.dao;

import java.util.List;

import com.hzh.entity.Order;

public interface OrderDao {
	//下单-增加
	boolean addOrder(Order order);
	
	//删除订单
	boolean delOrder(int order_id);
	
	//撤销订单-对于下单者
	boolean revokeOrder(int order_id);
	
	//完成订单
	boolean FinishOrder(int order_id);
	
	//达成交易后，其余关联订单关闭
	boolean closeOrderByFinish(int goods_id);
	
	//物品撤销发布后，关联订单关闭
	boolean closeOrderByRevoke(int goods_id);
	
	//查看订单详情
	Order selectOrderDetail(int order_id);
	
	//查看我收到的订单-未处理订单
	List<Order> selectUntreatedOrderByPublisher(String publisher);
	
	//查看我收到的订单-已关闭订单
	List<Order> selectClosedOrderByPublisher(String publisher);
	
	//查看我收到的订单-已完成订单
	List<Order> selectFinishedOrderByPublisher(String publisher);
	
	//查看我下的订单-未处理订单
	List<Order> selectUntreatedOrderByOrderPeople(String order_people);
	
	//查看我下的订单-已完成订单
	List<Order> selectFinishedOrderByOrderPeople(String order_people);
	
	//查看我下的订单-已关闭订单
	List<Order> selectClosedOrderByOrderPeople(String order_people);
	
	//查询是否重复下单
	int selectRepeatOrder(Order order);
	
	//查询新生成的订单编号
	int selectMaxOrderId();	
	
}
