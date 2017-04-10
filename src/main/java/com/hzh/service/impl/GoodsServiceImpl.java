package com.hzh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzh.dao.GoodsDao;
import com.hzh.entity.Goods;
import com.hzh.entity.GoodsAndUser;
import com.hzh.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
    private GoodsDao goodsDao;
	
	//发布商品信息
	@Transactional
	public boolean AddGoods(Goods goods) {
		return goodsDao.AddGoods(goods);
	}

	//删除发布的物品
	@Transactional
	public boolean DelGoods(int goods_id) {
		return goodsDao.DelGoods(goods_id);
	}

	//修改发布的物品信息
	@Transactional
	public boolean UpdateGoods(Goods goods) {
		return goodsDao.UpdateGoods(goods);
	}

	//显示自己发布的物品信息
	public List<Goods> selectGoodsByName(String username) {
		return goodsDao.selectGoodsByName(username);
	}

	//显示全部有效物品信息
	public List<Goods> selectValidGoods() {
		return goodsDao.selectValidGoods();
	}

	//根据物品编号获取Goods属性
	public Goods selectGoodsById(int goods_id) {
		return goodsDao.selectGoodsById(goods_id);
	}

	//查看物品详情信息-联表
	public List<GoodsAndUser> selectGoodsDetails(int goods_id) {
		return goodsDao.selectGoodsDetails(goods_id);
	}

}
