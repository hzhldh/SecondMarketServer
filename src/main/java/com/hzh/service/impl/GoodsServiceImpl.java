package com.hzh.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sun.misc.BASE64Decoder;

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

	//base转码，图片存入本地
	public String GenerateImage(String imgStr, String path) {
		if (imgStr == null) // 图像数据为空  
            return "no_img.jpg";  
        BASE64Decoder decoder = new BASE64Decoder();  
        try {  
            // Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for (int i = 0; i < b.length; ++i) {  
                if (b[i] < 0) {// 调整异常数据  
                    b[i] += 256;  
                }  
            }  
            //根据时间生成唯一图片文件名
    		String fileName = String.format("%1$tY-%1$tm-%1$td-%1$tH%1$tM%1$tS-%1$tL",new Date())+".jpg";
    		//拼接该文件的绝对路径,分隔符用File.separator 代替
    	    String absolutePath=path+File.separator+fileName;
            OutputStream out = new FileOutputStream(absolutePath);  
            out.write(b);  
            out.flush();  
            out.close();  
            return fileName;  
        } catch (Exception e) {  
            return "no_img.jpg";  
        }
	}

}
