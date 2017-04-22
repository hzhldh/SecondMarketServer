package com.hzh.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;







import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Decoder;  
import sun.misc.BASE64Encoder;  










import com.hzh.entity.Goods;
import com.hzh.entity.GoodsAndUser;
import com.hzh.service.GoodsService;


@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	//发布物品信息
	/*@ResponseBody 
    @RequestMapping(value="/addGoods",produces = {"text/javascript;charset=UTF-8"})  
	public String AddGoods(String source_type, String goods_name, String publisher,String description, String type, String goods_img, double original_price, double second_price, String old_degree) {
        Goods goods=new Goods(source_type, goods_name, publisher, description, type, goods_img, original_price, second_price, old_degree);
        if (goodsService.AddGoods(goods)) {
        	return "物品发布成功";
		} else {
			return "物品发布失败";
		}
	}*/
	@ResponseBody 
    @RequestMapping(value="/addGoods",produces = {"text/javascript;charset=UTF-8"})  
	public String AddGoods(@ModelAttribute Goods goods) {
	   System.out.println(goods.toString());
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
	
	//测试上传图片，并存入本地
	@ResponseBody 
	@RequestMapping("/uploadImg")
	public String upload(String imgData,HttpServletRequest request){	
		//获取服务器存储图片的目录
		String path=request.getServletContext().getRealPath("/WEB-INF/classes/img/goodsImg");
		System.out.println(GenerateImage(imgData,path));
		return "0";
	}
	
	// base64字符串转化成图片,成功返回文件名 字符串
    public static String GenerateImage(String imgStr,String path) { // 对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) // 图像数据为空  
            return "1";  
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
            return "1";  
        }  
    }
	
}
