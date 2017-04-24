/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : secondmarket

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-04-24 15:08:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `collect_id` int(12) NOT NULL AUTO_INCREMENT,
  `goods_id` int(12) NOT NULL,
  `username` varchar(32) NOT NULL,
  PRIMARY KEY (`collect_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(12) NOT NULL AUTO_INCREMENT,
  `source_type` varchar(32) NOT NULL COMMENT '来源类型',
  `goods_name` varchar(50) NOT NULL,
  `publisher` varchar(32) NOT NULL COMMENT '发布者',
  `description` varchar(250) DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL,
  `popularity` int(12) DEFAULT '0' COMMENT '人气值，即收藏数',
  `auction_num` int(12) DEFAULT '0' COMMENT '当前参与竞拍人数',
  `goods_img` varchar(250) DEFAULT 'no_img.jpg',
  `original_price` double(12,0) DEFAULT NULL,
  `second_price` double(12,0) DEFAULT NULL,
  `old_degree` varchar(50) DEFAULT '' COMMENT '新旧程度',
  `goods_status` varchar(50) DEFAULT '有效',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('7', '出售', 'iphone 7 Plus', 'hzh', '港版64G', '数码产品', '0', '0', 'new.jpg', '6288', '5000', '9.5成新', '有效');
INSERT INTO `goods` VALUES ('8', '出售', 'iphone 6s', 'hzh', '国行', '数码产品', '0', '0', 'test.jpg', '5288', '4000', '9成新', '有效');
INSERT INTO `goods` VALUES ('9', '出售', 'iphone 6s', 'hzh', '国行', '数码产品', '0', '0', 'test.jpg', '5288', '4000', '9成新', '已失效');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(12) NOT NULL AUTO_INCREMENT,
  `goods_id` int(12) NOT NULL,
  `publisher` varchar(32) DEFAULT NULL COMMENT '商品信息发布者',
  `order_people` varchar(32) DEFAULT NULL COMMENT '下单人',
  `final_price` double(12,0) DEFAULT NULL,
  `order_time` varchar(50) DEFAULT NULL,
  `order_status` varchar(50) DEFAULT '进行中',
  `close_reason` varchar(250) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_car`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_car`;
CREATE TABLE `shopping_car` (
  `shopping_id` int(12) NOT NULL AUTO_INCREMENT,
  `goods_id` int(12) NOT NULL,
  `username` varchar(32) NOT NULL,
  PRIMARY KEY (`shopping_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_car
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `phone` bigint(32) NOT NULL,
  `short_num` int(12) DEFAULT NULL,
  `wechat` varchar(32) DEFAULT NULL,
  `head_img` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('hzh', '123', '13534886987', '734054', '498641239', 'hzh.jpg');
INSERT INTO `user` VALUES ('ldh', '123', '13534886987', null, null, null);
INSERT INTO `user` VALUES ('或者', '123456', '13653043054', null, null, null);
INSERT INTO `user` VALUES ('测试', '123456', '13653043055', null, null, null);
INSERT INTO `user` VALUES ('黄大爷', '123', '13034480210', '734054', '498641239', 'test.png');
