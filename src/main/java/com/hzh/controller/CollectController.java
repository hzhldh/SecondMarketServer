package com.hzh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzh.entity.Collect;
import com.hzh.service.CollectService;

@Controller
@RequestMapping("/collect")
public class CollectController {
	@Autowired
	private CollectService collectService;
	
	//增加物品收藏
	@ResponseBody 
    @RequestMapping(value="/addCollect",produces = {"text/javascript;charset=UTF-8"})  
	public String addCollect(int goods_id, String username) {	
		if (collectService.addCollect(goods_id, username)) {
			return "0";
		}else {
	        return "1";
		}
	}
	
	//取消物品收藏
	@ResponseBody 
    @RequestMapping(value="/delCollect",produces = {"text/javascript;charset=UTF-8"})  
	public String delCollect(int goods_id, String username) {
        if (collectService.delCollect(goods_id, username)) {
        	return "0";
		} else {
			return "1";
		}
	}
	
	//显示某用户收藏用品列表
	@ResponseBody  
    @RequestMapping(value="/selectCollectByName")  
	public List<Collect> selectCollectByName(String username) {  
		List<Collect> list=collectService.selectCollectByName(username);
	    return list;
	}

}
