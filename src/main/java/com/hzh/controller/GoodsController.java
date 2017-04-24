package com.hzh.controller;


import java.util.Date;
import java.util.List;








import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;












import com.hzh.entity.Goods;
import com.hzh.entity.GoodsAndUser;
import com.hzh.service.GoodsService;


@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	//发布物品信息
	@ResponseBody 
    @RequestMapping(value="/addGoods",produces = {"text/javascript;charset=UTF-8"})  
	public String AddGoods(@ModelAttribute Goods goods,HttpServletRequest request) {	
		String publish_time = String.format("%1$tY-%1$tm-%1$td",new Date());//获取当前日期
		goods.setPublish_time(publish_time);
		
		if (goods.getGoods_img()=="") {//未上传图片
			goods.setGoods_img("no_img.jpg");	   
		}else {
			//获取服务器存储图片的目录
		   String path=request.getServletContext().getRealPath("/WEB-INF/classes/img/goodsImg");
		   String goods_img= goodsService.GenerateImage(goods.getGoods_img(),path);	  
		   //更新goods对象中的goods_img
		   goods.setGoods_img(goods_img);
		}
       goodsService.AddGoods(goods);
	   
       return "0";
	}
	
	//删除发布的物品
	@ResponseBody 
    @RequestMapping(value="/delGoods",produces = {"text/javascript;charset=UTF-8"})  
	public String DelGoods(int goods_id) {
        if (goodsService.DelGoods(goods_id)) {
        	return "物品删除成功";
		} else {
			return "物品删除失败";
		}
	}
    
    //修改发布的物品信息
	@ResponseBody 
    @RequestMapping(value="/updateGoods",produces = {"text/javascript;charset=UTF-8"})  
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

	
	//根据物品编号查询全部信息-显示物品详情-联表
	@ResponseBody  
    @RequestMapping(value="/selectGoodsDetails")  
	public List<GoodsAndUser> selectGoodsDetails(int goods_id) {  
		List<GoodsAndUser> list=goodsService.selectGoodsDetails(goods_id);
	    return list;
	}
	
}
