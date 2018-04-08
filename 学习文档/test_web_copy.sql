/*
 Navicat Premium Data Transfer

 Source Server         : mysql_connection
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : test_web

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 08/04/2018 18:58:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '商品名字',
  `price` float NOT NULL,
  `detail` varchar(512) DEFAULT NULL COMMENT '商品描述',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
BEGIN;
INSERT INTO `items` VALUES (1, '外星人笔记本', 12000, '外星人新一代笔记本15寸', '2018-04-08 16:27:19');
INSERT INTO `items` VALUES (2, 'macbook pro 2017 15寸', 18000, '苹果笔记本15寸', '2018-04-08 16:28:05');
COMMIT;

-- ----------------------------
-- Table structure for oderdetail
-- ----------------------------
DROP TABLE IF EXISTS `oderdetail`;
CREATE TABLE `oderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_id` int(11) NOT NULL COMMENT '订单id',
  `items_id` int(11) NOT NULL COMMENT '商品id',
  `items_num` int(11) DEFAULT NULL COMMENT '商品购买数量',
  PRIMARY KEY (`id`),
  KEY `orders_id` (`orders_id`),
  KEY `items_id` (`items_id`),
  CONSTRAINT `oderdetail_ibfk_1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `oderdetail_ibfk_2` FOREIGN KEY (`items_id`) REFERENCES `items` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oderdetail
-- ----------------------------
BEGIN;
INSERT INTO `oderdetail` VALUES (1, 1, 1, 3);
INSERT INTO `oderdetail` VALUES (2, 2, 2, 5);
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `number` varchar(32) NOT NULL COMMENT '订单号',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES (1, 1, 'orders_00000', '2018-04-08 16:23:03', '这是笔记本');
INSERT INTO `orders` VALUES (2, 1, 'orders_11111', '2018-04-08 16:23:56', '苹果笔记本');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '张三', '1991-09-12', '男', '中国北京');
INSERT INTO `user` VALUES (2, '李四', '1995-01-23', '男', '中国成都');
INSERT INTO `user` VALUES (3, '王五', '1998-11-09', '男', '中国上海');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
