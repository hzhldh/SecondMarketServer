package com.hzh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzh.dao.CollectDao;
import com.hzh.dao.GoodsDao;
import com.hzh.entity.Collect;
import com.hzh.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService{
	@Autowired
    private CollectDao collectDao;
	@Autowired
    private GoodsDao goodsDao;

	//取消收藏
	@Transactional
	public boolean delCollect(int goods_id, String username) {
		if (collectDao.delCollect(goods_id, username)) {
			//物品收藏人数-1
			goodsDao.reduceCollectCount(goods_id);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public boolean addCollect(int goods_id, String username) {
		if (collectDao.addCollect(goods_id, username)) {
			//物品收藏人数+1
			goodsDao.addCollectCount(goods_id);
			return true;
		} else {
            return false;
		}
		
	}

	public List<Collect> selectCollectByName(String username) {
		return collectDao.selectCollectByName(username);
	}

}
