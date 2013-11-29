/*
Navicat MySQL Data Transfer

Source Server         : 200
Source Server Version : 50154
Source Host           : 192.168.3.200:3306
Source Database       : gooagoo_open

Target Server Type    : MYSQL
Target Server Version : 50154
File Encoding         : 65001

Date: 2013-11-29 18:45:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `oauth_code`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `app_key` int(11) NOT NULL COMMENT '应用ID',
  `code` char(32) NOT NULL COMMENT 'code',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`app_key`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='授权code';

-- ----------------------------
-- Records of oauth_code
-- ----------------------------
INSERT INTO `oauth_code` VALUES ('10001', '01822RV5PA3D4KE07GRNH8EIISWR2K8D', '2013-11-29 13:46:55', '2013-12-16 14:11:19');
