package com.hzh.service;

import java.util.List;

import com.hzh.entity.Goods;
import com.hzh.entity.GoodsAndUser;


public interface GoodsService {
	//发布物品信息
    boolean AddGoods(Goods goods);
    
    //删除发布的物品
    boolean DelGoods(int goods_id);
    
    //修改发布的物品信息
    boolean UpdateGoods(Goods goods);
    
    //根据物品编号获取Goods属性
  	Goods selectGoodsById(int goods_id);
    
    //显示自己发布的物品信息
    List<Goods> selectGoodsByName(String username);
    
    //显示自己失效的发布
    List<Goods> selectInvalidGoodsByName(String username);
    
    //显示全部有效物品信息
    List<Goods> selectValidGoods();
    
    //查看物品详情信息-联表
    List<GoodsAndUser> selectGoodsDetails(int goods_id);
    
    //base转码，图片存入本地
    String GenerateImage(String imgStr,String path);
    
    //撤销物品发布
    boolean revokeGoods(int goods_id);
    
    //根据类型查看物品列表
    List<Goods> selectGoodsByType(String type);
    
    //根据来源查看物品列表
    List<Goods> selectGoodsBySource(String source_type);
    
    //根据搜索查看物品列表
    List<Goods> selectGoodsBySearch(String search);
}
