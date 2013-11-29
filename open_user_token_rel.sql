/*
Navicat MySQL Data Transfer

Source Server         : 200
Source Server Version : 50154
Source Host           : 192.168.3.200:3306
Source Database       : gooagoo_open

Target Server Type    : MYSQL
Target Server Version : 50154
File Encoding         : 65001

Date: 2013-11-29 18:45:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `open_user_token_rel`
-- ----------------------------
DROP TABLE IF EXISTS `open_user_token_rel`;
CREATE TABLE `open_user_token_rel` (
  `token_id` char(32) NOT NULL COMMENT '访问ID',
  `user_id` varchar(30) DEFAULT NULL COMMENT '用户ID',
  `app_key` int(11) DEFAULT NULL COMMENT '应用ID',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和授权关系表';

-- ----------------------------
-- Records of open_user_token_rel
-- ----------------------------
INSERT INTO `open_user_token_rel` VALUES ('00017R5U9MNOJODJP0005CBJ11W37006', 'walmart@163.com', '10001', '2013-12-26 10:00:06', '2013-11-29 14:37:06');
