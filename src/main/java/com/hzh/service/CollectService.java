package com.hzh.service;

import java.util.List;



import org.apache.ibatis.annotations.Param;

import com.hzh.entity.Collect;

public interface CollectService {
	//取消物品收藏
	boolean delCollect(int goods_id,String username);
	
	//增加物品收藏
	boolean addCollect(int goods_id,String username);
	
	//显示自己收藏的物品列表
	List<Collect> selectCollectByName(String username);
	
	//查询是否已经收藏过
	int selectReapeatCollect(int goods_id,String username);
}
