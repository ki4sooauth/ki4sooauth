/*
Navicat MySQL Data Transfer

Source Server         : 200
Source Server Version : 50154
Source Host           : 192.168.3.200:3306
Source Database       : gooagoo_open

Target Server Type    : MYSQL
Target Server Version : 50154
File Encoding         : 65001

Date: 2013-11-29 18:44:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `open_app_info`
-- ----------------------------
DROP TABLE IF EXISTS `open_app_info`;
CREATE TABLE `open_app_info` (
  `app_key` int(11) NOT NULL AUTO_INCREMENT COMMENT '应用KEY',
  `app_name` varchar(30) DEFAULT NULL COMMENT '应用名称',
  `app_type` varchar(30) DEFAULT NULL COMMENT '应用类型',
  `app_label` varchar(30) DEFAULT NULL COMMENT '应用标签',
  `app_secret` char(32) DEFAULT NULL COMMENT '应用密钥',
  `volume` int(11) DEFAULT '5000' COMMENT '证书流量',
  `app_status` char(1) DEFAULT '1' COMMENT '应用状态',
  `user_id` varchar(30) NOT NULL COMMENT '用户ID',
  `create_dt` datetime DEFAULT NULL COMMENT '应用创建时间',
  `update_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '应用修改时间',
  PRIMARY KEY (`app_key`)
) ENGINE=InnoDB AUTO_INCREMENT=10005 DEFAULT CHARSET=utf8 COMMENT='应用基本信息表';

-- ----------------------------
-- Records of open_app_info
-- ----------------------------
INSERT INTO `open_app_info` VALUES ('10001', '测试应用', null, null, '0B420388AEAD37FDFF33356E540561C0', '5000', '1', 'walmart@163.com', '2013-11-26 10:00:06', '2013-11-26 10:00:06');
INSERT INTO `open_app_info` VALUES ('10004', null, null, null, '18A9VAI0CHRC2H0SHURCPR2CNO4LG7C4', '5000', '1', 'walmart@163.com', '2013-11-26 18:29:54', '2013-11-26 18:29:54');
