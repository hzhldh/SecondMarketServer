package com.hzh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzh.dao.GoodsDao;
import com.hzh.dao.OrderDao;
import com.hzh.entity.Order;
import com.hzh.service.OrderServcie;

@Service
public class OrderServiceImpl  implements OrderServcie{
	@Autowired
    private OrderDao orderDao;
	
	@Autowired
    private GoodsDao goodsDao;

	@Transactional
	public int addOrder(Order order) {
		if (orderDao.addOrder(order)) {
			//对应物品的竞拍人数+1
			goodsDao.addAuctionCount(order.getGoods_id());
			//查询新生成的订单编号并返回
			return orderDao.selectMaxOrderId();
		}else {
			return 0;
		}	
	}

	@Transactional
	public boolean delOrder(int order_id) {
		return false;
	}

	//查看订单详情
	public Order selectOrderDetail(int order_id) {
		return orderDao.selectOrderDetail(order_id);
	}

	//查询重复下单数
	public int selectRepeatOrder(Order order) {
		return orderDao.selectRepeatOrder(order);
	}

	//撤销订单-对于下单者
	@Transactional
	public boolean revokeOrder(int order_id,int goods_id) {
		//对应物品的竞拍人数-1
		goodsDao.reduceAuctionCount(goods_id);
		if (orderDao.revokeOrder(order_id)) {
			return true;
		}else {
			return false;
		}	
	}

	//完成交易
	@Transactional
	public boolean FinishOrder(int order_id,int goods_id) {
		if (orderDao.FinishOrder(order_id)) {
			//达成交易后，其余关联订单关闭
			orderDao.closeOrderByFinish(goods_id);
			return true;
		} else {
			return false;
		}
	}

	public List<Order> selectUntreatedOrderByPublisher(String publisher) {
		return orderDao.selectUntreatedOrderByPublisher(publisher);
	}

	public List<Order> selectClosedOrderByPublisher(String publisher) {
		return orderDao.selectClosedOrderByPublisher(publisher);
	}

	public List<Order> selectFinishedOrderByPublisher(String publisher) {
		return orderDao.selectFinishedOrderByPublisher(publisher);
	}

	public List<Order> selectUntreatedOrderByOrderPeople(String order_people) {
		return orderDao.selectUntreatedOrderByOrderPeople(order_people);
	}

	public List<Order> selectFinishedOrderByOrderPeople(String order_people) {
		return orderDao.selectFinishedOrderByOrderPeople(order_people);
	}

	public List<Order> selectClosedOrderByOrderPeople(String order_people) {
		return orderDao.selectClosedOrderByOrderPeople(order_people);
	}


}
