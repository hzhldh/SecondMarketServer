package com.hzh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzh.dao.OrderDao;
import com.hzh.entity.Order;
import com.hzh.service.OrderServcie;

@Service
public class OrderServiceImpl  implements OrderServcie{
	@Autowired
    private OrderDao orderDao;

	@Transactional
	public int addOrder(Order order) {
		if (orderDao.addOrder(order)) {
			//查询新生成的订单编号
			return orderDao.selectMaxOrderId();
		}else {
			return 0;
		}	
	}

	@Transactional
	public boolean delOrder(int order_id) {
		return false;
	}

	@Transactional
	public boolean revokeOrder(int order_id) {
		return false;
	}

	@Transactional
	public boolean closeOrder(int goods_id) {
		return false;
	}

	public Order selectOrderDetail(int order_id) {
		return orderDao.selectOrderDetail(order_id);
	}

	public List<Order> selectOrderByPublisher(String publisher) {
		return orderDao.selectOrderByPublisher(publisher);
	}

	public List<Order> selectOrderByOrderPeople(String order_people) {
		return orderDao.selectOrderByOrderPeople(order_people);
	}

	public int selectOrderCount(int goods_id) {
		return 0;
	}

	public int selectRepeatOrder(Order order) {
		return orderDao.selectRepeatOrder(order);
	}

}
