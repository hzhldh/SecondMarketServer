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
	
	//撤销订单-对于下单者
	@ResponseBody 
    @RequestMapping(value="/revokeOrder",produces = {"text/javascript;charset=UTF-8"})  
	public String revokeOrder(int order_id,int goods_id) {	
		if (orderServcie.revokeOrder(order_id, goods_id)) {
			return "0";
		}else { 	
			return "1";
		}
	}
	
	//完成订单
	@ResponseBody 
    @RequestMapping(value="/FinishOrder",produces = {"text/javascript;charset=UTF-8"})  
	public String FinishOrder(int order_id,int goods_id) {	
		if (orderServcie.FinishOrder(order_id, goods_id)) {
			return "0";
		}else { 	
			return "1";
		}
	}
	
	//查看某物品的竞拍情况
	@ResponseBody 
    @RequestMapping(value="/selectAuctionByGoodsId",produces = {"text/javascript;charset=UTF-8"})  
	public String selectAuctionByGoodsId(int goods_id) throws JsonProcessingException {	
		List<Order> list=orderServcie.selectAuctionByGoodsId(goods_id);
		ObjectMapper mapper=new ObjectMapper(); 		
		String result=mapper.writeValueAsString(list);
		return result;
	}
	//查看我收到的订单-未处理订单
	@ResponseBody 
    @RequestMapping(value="/selectUntreatedOrderByPublisher",produces = {"text/javascript;charset=UTF-8"})  
	public String selectUntreatedOrderByPublisher(String publisher) throws JsonProcessingException {
		List<Order> list=orderServcie.selectUntreatedOrderByPublisher(publisher);
		ObjectMapper mapper=new ObjectMapper(); 		
		String result=mapper.writeValueAsString(list);
		return result;			
	}
	//查看我收到的订单-已关闭订单
	@ResponseBody 
    @RequestMapping(value="/selectClosedOrderByPublisher",produces = {"text/javascript;charset=UTF-8"})  
	public String selectClosedOrderByPublisher(String publisher) throws JsonProcessingException {
		List<Order> list=orderServcie.selectClosedOrderByPublisher(publisher);
		//将对象转换为json字符串
		ObjectMapper mapper=new ObjectMapper(); 		
		String result=mapper.writeValueAsString(list);
		return result;			
	}
	//查看我收到的订单-已完成订单
	@ResponseBody 
    @RequestMapping(value="/selectFinishedOrderByPublisher",produces = {"text/javascript;charset=UTF-8"})  
	public String selectFinishedOrderByPublisher(String publisher) throws JsonProcessingException {
		List<Order> list=orderServcie.selectFinishedOrderByPublisher(publisher);
		//将对象转换为json字符串
		ObjectMapper mapper=new ObjectMapper(); 		
		String result=mapper.writeValueAsString(list);
		return result;			
	}
	
	//查看我下的订单-未处理订单
	@ResponseBody 
    @RequestMapping(value="/selectUntreatedOrderByOrderPeople",produces = {"text/javascript;charset=UTF-8"})  
	public String selectUntreatedOrderByOrderPeople(String order_people) throws JsonProcessingException {
		List<Order> list=orderServcie.selectUntreatedOrderByOrderPeople(order_people);
		//将对象转换为json字符串
		ObjectMapper mapper=new ObjectMapper(); 		
		String result=mapper.writeValueAsString(list);
		return result;			
	}
	//查看我下的订单-已完成
	@ResponseBody 
    @RequestMapping(value="/selectFinishedOrderByOrderPeople",produces = {"text/javascript;charset=UTF-8"})  
	public String selectFinishedOrderByOrderPeople(String order_people) throws JsonProcessingException {
		List<Order> list=orderServcie.selectFinishedOrderByOrderPeople(order_people);
		//将对象转换为json字符串
		ObjectMapper mapper=new ObjectMapper(); 		
		String result=mapper.writeValueAsString(list);
		return result;			
	}
	//查看我下的订单-关闭的订单
	@ResponseBody 
    @RequestMapping(value="/selectClosedOrderByOrderPeople",produces = {"text/javascript;charset=UTF-8"})  
	public String selectClosedOrderByOrderPeople(String order_people) throws JsonProcessingException {
		List<Order> list=orderServcie.selectClosedOrderByOrderPeople(order_people);
		//将对象转换为json字符串
		ObjectMapper mapper=new ObjectMapper(); 		
		String result=mapper.writeValueAsString(list);
		return result;			
	}
}
