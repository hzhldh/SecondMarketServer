package com.hzh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzh.entity.Goods;
import com.hzh.entity.GoodsAndUser;


public interface GoodsDao {
	//发布物品信息
    boolean AddGoods(Goods goods);
    
    //删除发布的物品
    boolean DelGoods(int goods_id);
    
    //修改发布的物品信息(物品名称，描述，类型，图片，原价，二手价，新旧程度)
    boolean UpdateGoods(Goods goods);
    
    //根据物品编号获取goods属性
  	Goods selectGoodsById(int goods_id);
    
    //显示自己发布的物品信息-有效
    List<Goods> selectGoodsByName(String username);
    
    //显示自己失效的发布
    List<Goods> selectInvalidGoodsByName(String username);
    
    //显示全部有效物品信息
    List<Goods> selectValidGoods();
    
    //查看物品详情信息-联表
    List<GoodsAndUser> selectGoodsDetails(int goods_id);
    
    //撤销物品发布
    boolean revokeGoods(int goods_id);
    
    //物品收藏数+1
    boolean addCollectCount(int goods_id);
    //物品收藏数-1
    boolean reduceCollectCount(int goods_id);
    //竞拍人数+1
    boolean addAuctionCount(int goods_id);
    //竞拍人数-1
    boolean reduceAuctionCount(int goods_id);
    
    //根据类型查看物品列表
    List<Goods> selectGoodsByType(String type);
    
    //根据来源查看物品列表
    List<Goods> selectGoodsBySource(String source_type);
    
    //根据搜索查看物品列表
    List<Goods> selectGoodsBySearch(@Param("search")String search);
}
