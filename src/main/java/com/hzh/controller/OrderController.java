package com.hzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzh.entity.Order;
import com.hzh.service.OrderServcie;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderServcie orderServcie;
	
	//物品下单
	@ResponseBody 
    @RequestMapping(value="/addOrder",produces = {"text/javascript;charset=UTF-8"})  
	public String addShoppingCar(@ModelAttribute Order order) {	
		//判断物品是否重复下单
		if (orderServcie.selectRepeatOrder(order)>0) {
			return "1";
		}else {
			orderServcie.addOrder(order);
	        return "0";
		}
	}
}
