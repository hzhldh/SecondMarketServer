package com.hzh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzh.entity.Goods;
import com.hzh.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	//发布物品信息
	@ResponseBody 
    @RequestMapping(value="/AddGoods",produces = {"text/javascript;charset=UTF-8"})  
	public String AddGoods(String source_type, String goods_name, String publisher,String description, String type, String goods_img, double original_price, double second_price, String old_degree) {
        Goods goods=new Goods(source_type, goods_name, publisher, description, type, goods_img, original_price, second_price, old_degree);
        if (goodsService.AddGoods(goods)) {
        	return "物品发布成功";
		} else {
			return "物品发布失败";
		}
	}
	
	//删除发布的物品
	@ResponseBody 
    @RequestMapping(value="/DelGoods",produces = {"text/javascript;charset=UTF-8"})  
	public String DelGoods(int goods_id) {
        if (goodsService.DelGoods(goods_id)) {
        	return "物品删除成功";
		} else {
			return "物品删除失败";
		}
	}
    
    //修改发布的物品信息
	@ResponseBody 
    @RequestMapping(value="/UpdateGoods",produces = {"text/javascript;charset=UTF-8"})  
	public String UpdateGoods(int goods_id,String goods_name,String description, String type, String goods_img, double original_price, double second_price, String old_degree) {
		//先根据物品编号获取该对象
		Goods goods=goodsService.selectGoodsById(goods_id);
		goods.setGoods_name(goods_name);
		goods.setDescription(description);
		goods.setType(type);
		goods.setGoods_img(goods_img);
		goods.setOriginal_price(original_price);
		goods.setSecond_price(second_price);
		goods.setOld_degree(old_degree);
		if (goodsService.UpdateGoods(goods)) {
			return "修改商品信息成功";
		}else {
			return "修改失败";
		}
		
	}

    
    //显示自己发布的物品信息
	@ResponseBody  
    @RequestMapping(value="/selectGoodsByName")  
	public List<Goods> selectGoodsByName(String username) {  
		List<Goods> list=goodsService.selectGoodsByName(username);
	    return list;
	}
    
    //显示全部有效物品信息
	@ResponseBody  
    @RequestMapping(value="/selectValidGoods")  
	public List<Goods> selectValidGoods() {  
		List<Goods> list=goodsService.selectValidGoods();
	    return list;
	}
}
