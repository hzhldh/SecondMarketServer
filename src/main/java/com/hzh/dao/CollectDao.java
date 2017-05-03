package com.hzh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzh.entity.Collect;

public interface CollectDao {
	//取消物品收藏
	boolean delCollect(@Param("goods_id")int goods_id,@Param("username")String username);
	
	//增加物品收藏
	boolean addCollect(@Param("goods_id")int goods_id,@Param("username")String username);
	
	//查询是否已经收藏过
	int selectReapeatCollect(@Param("goods_id")int goods_id,@Param("username")String username);
	
	//显示自己收藏的物品列表
	List<Collect> selectCollectByName(@Param("username")String username);
}
