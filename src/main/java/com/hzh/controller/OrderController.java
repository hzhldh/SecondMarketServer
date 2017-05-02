package com.hzh.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzh.entity.Order;
import com.hzh.service.OrderServcie;
import com.hzh.service.ShoppingCarService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderServcie orderServcie;
	
	@Autowired
	private ShoppingCarService shoppingCarService;
	
	//物品下单
	@ResponseBody 
    @RequestMapping(value="/addOrder",produces = {"text/javascript;charset=UTF-8"})  
	public String addShoppingCar(@ModelAttribute Order order,int shopping_id) {	
		//判断物品是否重复下单
		if (orderServcie.selectRepeatOrder(order)>0) {
			return "-1";
		}else {
			String order_time = String.format("%1$tY-%1$tm-%1$td-%1$tH:%1$tM:%1$tS",new Date());
			order.setOrder_time(order_time);	
			int addResult=orderServcie.addOrder(order);//取得下单结果
			if (addResult==0) {//下单失败
				return "-100";
			}else { 
				String order_id=String.valueOf(addResult);
				//同时将该物品从购物车删除
				shoppingCarService.delShoppingCar(shopping_id);
				return order_id;
			}
		}
	}
	
	//订单详情
	@ResponseBody 
    @RequestMapping(value="/selectOrderDetail",produces = {"text/javascript;charset=UTF-8"})  
	public String selectOrderDetail(int order_id) throws JsonProcessingException {
		Order order=orderServcie.selectOrderDetail(order_id);
		//将对象转换为json字符串
		ObjectMapper mapper=new ObjectMapper(); 		
		String result=mapper.writeValueAsString(order);
		return result;			
	}
	
	//发布者的订单列表
	@ResponseBody 
    @RequestMapping(value="/selectOrderByPublisher",produces = {"text/javascript;charset=UTF-8"})  
	public String selectOrderByPublisher(String publisher) throws JsonProcessingException {
		List<Order> list=orderServcie.selectOrderByPublisher(publisher);
		//将对象转换为json字符串
		ObjectMapper mapper=new ObjectMapper(); 		
		String result=mapper.writeValueAsString(list);
		return result;			
	}
	
	//下单者的订单列表
	@ResponseBody 
    @RequestMapping(value="/selectOrderByOrderPeople",produces = {"text/javascript;charset=UTF-8"})  
	public String selectOrderByOrderPeople(String order_people) throws JsonProcessingException {
		List<Order> list=orderServcie.selectOrderByOrderPeople(order_people);
		//将对象转换为json字符串
		ObjectMapper mapper=new ObjectMapper(); 		
		String result=mapper.writeValueAsString(list);
		return result;			
	}
}
