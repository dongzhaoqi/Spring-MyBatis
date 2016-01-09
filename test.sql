/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2016-01-10 00:14:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(40) CHARACTER SET utf8 NOT NULL COMMENT '用户名',
  `password` varchar(40) CHARACTER SET utf8 NOT NULL COMMENT '密码',
  `email` varchar(40) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮件',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` char(2) CHARACTER SET utf8 NOT NULL COMMENT '性别',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
