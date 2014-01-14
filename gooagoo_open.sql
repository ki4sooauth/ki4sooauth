/*
Navicat MySQL Data Transfer

Source Server         : 3.200
Source Server Version : 50154
Source Host           : 192.168.3.200:3306
Source Database       : gooagoo_open

Target Server Type    : MYSQL
Target Server Version : 50154
File Encoding         : 65001

Date: 2014-01-14 18:26:41
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
INSERT INTO `oauth_code` VALUES ('10001', '18E8399946VJ0E1GGMKKF84KQO550G2K', '2013-11-29 13:46:55', '2014-01-14 18:13:25');

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
  `user_id` varchar(50) NOT NULL COMMENT '用户ID',
  `create_dt` datetime DEFAULT NULL COMMENT '应用创建时间',
  `update_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '应用修改时间',
  PRIMARY KEY (`app_key`)
) ENGINE=InnoDB AUTO_INCREMENT=10040 DEFAULT CHARSET=utf8 COMMENT='应用基本信息表';

-- ----------------------------
-- Records of open_app_info
-- ----------------------------
INSERT INTO `open_app_info` VALUES ('10001', '测试应用', '3', '3', '18E846CPUUH32U0SHURCPR2CI75NS96A', '5000', '1', 'walmart@163.com', '2013-11-26 10:00:06', '2013-11-26 10:00:06');
INSERT INTO `open_app_info` VALUES ('10007', '3', '34', '334', '334', '5000', '2', '', '2013-12-10 11:55:23', '2013-12-10 11:55:20');
INSERT INTO `open_app_info` VALUES ('10009', '1', '1', '1', '1', '1', '1', 'sunpengzheng@gooagoo.com', '2013-12-10 17:35:18', '2013-12-10 17:35:12');
INSERT INTO `open_app_info` VALUES ('10013', '4', '4', '47', '18BG8OEDOHV1632G8PEQDK10SS83O3I1', '4', '4', '1@gus.com', '2013-12-11 11:24:36', '2013-12-11 11:24:28');
INSERT INTO `open_app_info` VALUES ('10020', '2', '2', '2', '2', '2', '2', '1@gus.com', '2013-12-11 13:48:25', '2013-12-11 13:48:17');
INSERT INTO `open_app_info` VALUES ('10022', '我的应用', '互联网', '', '18BIKGCLVPIR2J0SHURCPR2CTQ3NOJE4', '5000', '', '1@gus.com', '2013-12-12 13:29:43', '2013-12-12 13:27:22');
INSERT INTO `open_app_info` VALUES ('10023', '我的应用二', '', '', '18BIKJ1TGF3L3F0SHURCPR2CTR3NOJE5', '5000', '', '1@gus.com', '2013-12-12 13:31:10', '2013-12-12 13:28:49');
INSERT INTO `open_app_info` VALUES ('10024', '新华书店应用', null, null, '18C1PB5DB2N8S7004D6ON0616662KA50', '5000', '1', 'xhsd@163.com', '2013-12-18 10:40:59', '2013-12-18 10:40:34');
INSERT INTO `open_app_info` VALUES ('10029', '名称8', '类型4', '标签1', '18E84493U9M1910SHURCPR2CI65NS969', '5000', '1', 'walmart@163.com', '2014-01-14 15:06:26', '2014-01-14 15:06:40');
INSERT INTO `open_app_info` VALUES ('10031', '应用名称', '应用类型', '应用标签', '18E8134D65PC4E000005C1O03P4A09T1', '5000', '2', 'walmart@163.com', '2014-01-14 15:19:54', '2014-01-14 15:20:10');
INSERT INTO `open_app_info` VALUES ('10034', '4', '4', '4', '18E843A38BDBTB0SHURCPR2CI55NS968', '5000', '1', 'walmart@163.com', '2014-01-14 17:02:37', '2014-01-14 17:02:49');
INSERT INTO `open_app_info` VALUES ('10039', '89', '89', '99', '18E80LKB2OCV8S000005C1O03N4A09SV', '5000', '1', 'walmart@163.com', '2014-01-14 17:17:44', '2014-01-14 17:17:56');

-- ----------------------------
-- Table structure for `open_interface_category`
-- ----------------------------
DROP TABLE IF EXISTS `open_interface_category`;
CREATE TABLE `open_interface_category` (
  `category_id` char(32) NOT NULL COMMENT '类别ID',
  `parent_category_id` char(32) NOT NULL COMMENT '父类别ID，-1为没有父类别',
  `category_name` varchar(20) DEFAULT NULL COMMENT '接口类别名称',
  `category_description` varchar(50) DEFAULT NULL COMMENT '接口类别描述',
  `service_name` varchar(50) DEFAULT NULL,
  `is_del` char(1) DEFAULT NULL COMMENT '是否删除',
  `update_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '接口更新时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用程序接口分类表';

-- ----------------------------
-- Records of open_interface_category
-- ----------------------------
INSERT INTO `open_interface_category` VALUES ('18BJ05NPJHCEL12G8PEQD0DU787I03LR', '-1', '商品API', '提供对商品的增删改查。', 'IgoodsService', 'N', '2013-12-12 15:41:56');
INSERT INTO `open_interface_category` VALUES ('18DIL9LLT3EM2U0SHURCPR2CHP26OCUM', '-1', '商家API', '提供相关商家服务接口', 'IShopService', 'N', '2014-01-06 10:12:23');
INSERT INTO `open_interface_category` VALUES ('22456D9D35004999B5FAB0E7EC19DCCD', 'FEA7D3D5668E42509D97408250DDC163', '定位导航API', '提供了定位导航API', 'mobileNavigationService', 'N', '2013-12-05 10:07:30');
INSERT INTO `open_interface_category` VALUES ('255734C3D1814AB08B4E91C2BEC7FABC', 'FEA7D3D5668E42509D97408250DDC163', '基本信息API', '提供了基本信息API', 'mobileBasicService', 'N', '2013-12-05 09:47:41');
INSERT INTO `open_interface_category` VALUES ('2CB8865437784206A52B3B5927A4A265', 'FEA7D3D5668E42509D97408250DDC163', '手机交易支付', '提供了手机交易支付API', 'mobileTransactionService', 'N', '2013-12-05 10:07:30');
INSERT INTO `open_interface_category` VALUES ('36B0797C65EB42A89DDB90D67F770456', 'FEA7D3D5668E42509D97408250DDC163', '购物计划API', '提供了购物计划API', 'mobileShoppingPlansService', 'N', '2013-12-05 10:07:30');
INSERT INTO `open_interface_category` VALUES ('389E66A83F474B769B25D0C64B78195F', 'FEA7D3D5668E42509D97408250DDC163', '吆喝API', '提供了吆喝API', 'mobileCryoutService', 'N', '2013-12-05 09:47:41');
INSERT INTO `open_interface_category` VALUES ('394A7D189E404C35B8CDDE9560447319', 'FEA7D3D5668E42509D97408250DDC163', '购物车API', '购物车API', 'mobileShoppingCartService', 'N', '2013-12-05 10:07:30');
INSERT INTO `open_interface_category` VALUES ('448EAFE7C44C4DDF9D6A06F77CCAEF9C', 'FEA7D3D5668E42509D97408250DDC163', '用户消费日历', '用户消费日历API', 'mobileConsumerService', 'N', '2013-12-05 10:07:30');
INSERT INTO `open_interface_category` VALUES ('52B045F1702141279084BE16297A4ABD', 'FEA7D3D5668E42509D97408250DDC163', '刷卡播放音频', '用户刷卡播放音频API', 'mobileShuakaService', 'N', '2013-12-05 09:47:41');
INSERT INTO `open_interface_category` VALUES ('96A7608958864997BF8920490E8A7654', 'FEA7D3D5668E42509D97408250DDC163', '设置API', '设置API', 'mobileSettingService', 'N', '2013-12-05 09:47:41');
INSERT INTO `open_interface_category` VALUES ('C5D1CDB90D3B44A7B955E6ED4E0424B3', 'FEA7D3D5668E42509D97408250DDC163', '消费账单API', '消费账单API', 'mobileBillService', 'N', '2013-12-05 09:47:41');
INSERT INTO `open_interface_category` VALUES ('DF79AB1EA08F4B4887727D05CC8EECC3', 'FEA7D3D5668E42509D97408250DDC163', '收藏API', '收藏API', 'mobileFavoriteService', 'N', '2013-12-04 10:00:19');
INSERT INTO `open_interface_category` VALUES ('DF79AB1EA08F4B4887727D05CC8EECC7', 'FEA7D3D5668E42509D97408250DDC163', '卡包服务API', '卡包服务API', 'mobileCardService', 'N', '2013-12-02 16:22:36');
INSERT INTO `open_interface_category` VALUES ('F128A040AE584F719D787B738B0AB43C', 'FEA7D3D5668E42509D97408250DDC163', '营销触发API', '营销触发API', 'mobileMarketingService', 'N', '2013-12-05 10:07:30');
INSERT INTO `open_interface_category` VALUES ('F128A040AE584F719D787B738B0QQ43C', 'FEA7D3D5668E42509D97408250DDC163', '手机行为记录', '用户手机行为记录API', 'mobileUserBehaviorService', 'N', '2013-12-06 09:13:22');
INSERT INTO `open_interface_category` VALUES ('FEA7D3D5668E42509D97408250D44444', '-1', '营销API', '营销API', 'MarketingService', 'N', '2013-12-18 00:51:55');
INSERT INTO `open_interface_category` VALUES ('FEA7D3D5668E42509D97408250DDC154', '-1', '店员助理', '提供了用户基本信息查询功能', null, 'N', '2013-12-04 10:06:47');
INSERT INTO `open_interface_category` VALUES ('FEA7D3D5668E42509D97408250DDC163', '-1', '手机API', '手机API能提供了用户基本信息查询功能提供了用户', null, 'N', '2013-12-02 16:20:58');
INSERT INTO `open_interface_category` VALUES ('FEA7D3D5668E42509D97408250DDC198', '-1', 'CRM接口', '用户基本信息查询功能', null, 'N', '2013-12-04 10:14:48');
INSERT INTO `open_interface_category` VALUES ('FEA7D3D5668E42509D97408250DDC323', '-1', '转发器接口', '提供了用户基本信息查询功能提供了用户基本信息查询功能提供了用户基本信息查询功能', null, 'N', '2013-12-04 10:12:49');
INSERT INTO `open_interface_category` VALUES ('FEA7D3D5668E42509D97408250DDeeee', '-1', '会员API', '提供会员的增删改查', 'ImemberService', 'N', '2013-12-18 00:50:14');
INSERT INTO `open_interface_category` VALUES ('FEA7D3D5668E42509D97408250DDqww', '-1', '消费API', '消费API', 'ItradeService', 'N', '2013-12-18 00:57:15');

-- ----------------------------
-- Table structure for `open_interface_info`
-- ----------------------------
DROP TABLE IF EXISTS `open_interface_info`;
CREATE TABLE `open_interface_info` (
  `interface_id` char(32) NOT NULL COMMENT '接口ID',
  `category_id` char(32) DEFAULT NULL COMMENT '类别ID',
  `interface_name` varchar(30) DEFAULT NULL COMMENT '接口名称',
  `interface_desc` varchar(200) DEFAULT NULL COMMENT '接口描述',
  `interface_code` varchar(20) DEFAULT NULL COMMENT '接口代码',
  `is_authorization` char(1) DEFAULT NULL COMMENT '是否需要用户授权：0不需要1需要',
  `return_obj_type` varchar(30) DEFAULT NULL COMMENT '返回对象类型',
  `return_desc` varchar(200) DEFAULT NULL COMMENT '返回类型描述',
  `return_xml_example` varchar(2000) DEFAULT NULL COMMENT '返回XML格式样例',
  `return_json_example` varchar(1800) DEFAULT NULL COMMENT '返回JSON格式样例',
  `is_del` char(1) DEFAULT NULL COMMENT '是否删除',
  `update_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '接口更新时间',
  PRIMARY KEY (`interface_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口基本信息表';

-- ----------------------------
-- Records of open_interface_info
-- ----------------------------
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCsqwwwwwfEEEQD0DUdddddd', 'FEA7D3D5668E42509D97408250DDqww', '用于在MQ中收到新订单消息', null, 'gtea05', '0', 'UploadOrderResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCssssasdfEEEQD0DUdddddd', 'FEA7D3D5668E42509D97408250DDqww', '取消订单', null, 'gtea04', '0', 'CancelOrderResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCssssTqwqEEEQD0DUdddddd', 'FEA7D3D5668E42509D97408250DDqww', '更新订单轨迹', null, 'gtea03', '0', 'UpdOrderTrackResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCssssTTEEEEQD0DUdddddd', 'FEA7D3D5668E42509D97408250DDqww', '下载订单信息', null, 'gtea02', '0', 'DownLoadOrderInfoResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUdddddddd', 'FEA7D3D5668E42509D97408250DDeeee', '分配物理卡号', null, 'gmba04', '0', 'GiveMemberResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUddssdswe', 'FEA7D3D5668E42509D97408250D44444', '华书店新调用接口发送信息', null, 'gmka01', '0', 'SendMarketingMsgResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH6', '96A7608958864997BF8920490E8A7654', '用户登陆', null, 'mobf01', '0', 'Login', null, '<login>\n  <userid>01822FUO9AQTK6Q00C5V3IBJ43P1R5JO</userid>\n  <sessionid>0182CTKI7NC9M1K0038K1OSXUXJ1T6J4</sessionid>\n  <scardno>1000000000000200</scardno>\n</login>', '{\"login\":{\"userid\":\"01822FUO9AQTK6Q00C5V3IBJ43P1R5JO\",\"sessionid\":\"0182CTKI7NC9M1K0038K1OSXUXJ1T6J4\",\"scardno\":1000000000000200}}', 'N', '2013-12-05 11:24:17');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH7', '96A7608958864997BF8920490E8A7654', '用户注册', null, 'mobf03', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-05 11:39:46');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T10', 'DF79AB1EA08F4B4887727D05CC8EECC7', '手机端删除用户接收到的通知', null, 'moba15', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T11', 'DF79AB1EA08F4B4887727D05CC8EECC3', '收藏列表(Gooagoo服务器)', null, 'mobb01', '0', 'FavoriteDetail', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T12', 'DF79AB1EA08F4B4887727D05CC8EECC3', '添加收藏', null, 'mobb02', '0', 'boolean', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T13', 'DF79AB1EA08F4B4887727D05CC8EECC3', '获取优惠劵信息', null, 'mobb03', '0', 'Voucherdetail[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T14', 'DF79AB1EA08F4B4887727D05CC8EECC3', '获取商品详细信息及评论', null, 'mobb04', '0', 'Goodsdetail[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T15', 'DF79AB1EA08F4B4887727D05CC8EECC3', '获取商品所有评论', null, 'mobb05', '0', 'Usercomment[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T16', 'DF79AB1EA08F4B4887727D05CC8EECC3', '收藏广场列表侧边栏', null, 'mobb06', '0', 'Firstmenu[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T17', 'DF79AB1EA08F4B4887727D05CC8EECC3', '收藏广场列表(查询)', null, 'mobb07', '0', 'Favoriteplaza[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T18', 'DF79AB1EA08F4B4887727D05CC8EECC3', '查询商家精品', null, 'mobb08', '0', 'ChoiceListDetail', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T19', 'DF79AB1EA08F4B4887727D05CC8EECC3', '用户关注商家', null, 'mobb09', '0', 'boolean', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T20', 'DF79AB1EA08F4B4887727D05CC8EECC3', '搜索收藏推荐', null, 'mobb10', '0', 'Favoriterecommend[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T21', 'DF79AB1EA08F4B4887727D05CC8EECC3', '手机端删除用户的收藏', null, 'mobb11', '0', 'boolean', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T22', 'DF79AB1EA08F4B4887727D05CC8EECC3', '查询用户可用优惠券数量', null, 'mobb12', '0', 'String', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T23', '389E66A83F474B769B25D0C64B78195F', '商家吆喝(Gooagoo服务器)', null, 'mobc01', '0', 'CryoutListgDetail', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T24', '389E66A83F474B769B25D0C64B78195F', '吆喝广场侧边栏分类', null, 'mobc02', '0', 'Firstmenu[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T25', '389E66A83F474B769B25D0C64B78195F', '吆喝广场商家列表', null, 'mobc03', '0', 'Shoplist[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T26', '389E66A83F474B769B25D0C64B78195F', '吆喝广场商家详情查询', null, 'mobc04', '0', 'Shopdetail', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T27', '389E66A83F474B769B25D0C64B78195F', '吆喝广场下精品推荐', null, 'mobc05', '0', 'Boutiquerecommend[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T28', '389E66A83F474B769B25D0C64B78195F', '查询商家推荐吆喝', null, 'mobc07', '0', 'Recommendcryoutlist[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T29', '36B0797C65EB42A89DDB90D67F770456', '计划列表与服务器同步(单条)', null, 'mobd01', '0', 'UserShoppingPlanSDetail', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T30', '36B0797C65EB42A89DDB90D67F770456', '购物匹配(商品详细信息)', null, 'mobd02', '0', 'Matchgoodslist[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T31', '36B0797C65EB42A89DDB90D67F770456', '活动列表', null, 'mobd04', '0', 'Activitylist[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T32', '36B0797C65EB42A89DDB90D67F770456', '计划列表与服务器同步(批量，步骤1)', null, 'mobd06 ', '0', 'UserShoppingPlanBTADetail', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T33', '36B0797C65EB42A89DDB90D67F770456', '计划列表与服务器同步(批量，步骤2)', null, 'mobd07', '0', 'Usershoppingplanbtb[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T34', '36B0797C65EB42A89DDB90D67F770456', '购物匹配(主动)', null, 'mobd08', '0', 'Position[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T35', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '用户获取账单信息接口(Gooagoo服务器)', null, 'mobe01', '0', 'BillInvoiceDetail', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T36', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '用户根据账单信息申请开发票', null, 'mobe02', '0', 'boolean', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T37', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '获取菜谱', null, 'mobe04', '0', 'Cookbook[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T38', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '手机提交订单(点菜单、快速结账)', null, 'mobe05 ', '0', 'SubmitOrderForm', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T43', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '结帐申请', null, 'mobe06', '0', 'boolean', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T44', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '通过桌号获取点菜单信息', null, 'mobe07', '0', 'Getorderform', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T45', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '通过扫码获取商品信息', null, 'mobe09', '0', 'Goodscontaincomment[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T46', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '用户评论商品', null, 'mobe11', '0', 'boolean', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T54', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '餐桌状态查询', null, 'mobe12', '0', 'Deskstatuslist[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T55', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '用餐排号', null, 'mobe13', '0', 'QueueDetail', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T56', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '品类销售排行', null, 'mobe14', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T57', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '绑定桌号、订单号、用户id', null, 'mobe15', '0', 'boolean', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T58', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '通过\"账单/订单编号\"查询\"账单/订单\"信息', null, 'mobe16', '0', 'Billlisto', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T59', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '刷新排号状态', null, 'mobe17', '0', 'Refreshqueue[]', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T60', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '用户加菜申请', null, 'mobe18', '0', 'boolean', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T61', 'C5D1CDB90D3B44A7B955E6ED4E0424B3', '手机端删除用户的账单', null, 'mobe19', '0', 'boolean', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'DF79AB1EA08F4B4887727D05CC8EECC7', '用户申请实体卡电子化', null, 'moba11', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'DF79AB1EA08F4B4887727D05CC8EECC7', '推荐商家', null, 'moba05 ', '0', 'Recommendshop[]', null, ' <list>\n  <recommendshop>\n    <logo>http://img.gooagoo.com/marketing/2013/11/16/34CD49DDE184B28CBC2B05077F87CF32.jpg</logo>\n    <shopid>01822IAKR5SKU02085QBP2EIISWR0JGT</shopid>\n    <shopname>新华书店</shopname>\n    <membernums>19</membernums>\n    <attentionnums>8</attentionnums>\n    <colortype>#DC3C14</colortype>\n  </recommendshop>\n</list>', '{\"list\":[{\"recommendshop\":{\"logo\":\"http://img.gooagoo.com/marketing/2013/11/16/34CD49DDE184B28CBC2B05077F87CF32.jpg\",\"shopid\":\"01822IAKR5SKU02085QBP2EIISWR0JGT\",\"shopname\":\"新华书店\",\"membernums\":19,\"attentionnums\":8,\"colortype\":\"#DC3C14\"}}]}', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH2', 'DF79AB1EA08F4B4887727D05CC8EECC7', '用户积分查询接口', null, 'moba06 ', '0', 'String', null, '<string>500</string>', '{\"string\":500}', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'DF79AB1EA08F4B4887727D05CC8EECC7', '添加新卡（查询商家列表', null, 'moba08', '0', 'Shoplist[]', null, '<list>\n  <shoplist>\n    <shopid>18AK2Q0R4BLVBN00A1BAQJMCENOB04KM</shopid>\n    <shopname>阿斯顿</shopname>\n    <squarelogo>http://img.gooagoo.com/marketing/2013/11/30/6B7910A8B922635DA579A3F8A500BDEF.png</squarelogo>\n    <oblonglogo>http://img.gooagoo.com/marketing/2013/11/30/931E8BFDC731E350E69E9F24A77BD1FE.png</oblonglogo>\n    <shopfirstchar></shopfirstchar>\n    <shoptypeleaf>咖啡厅</shoptypeleaf>\n    <isdel>N</isdel>\n    <ctimestamp>2013-11-30 19:04:40</ctimestamp>\n  </shoplist>\n</list>', '{\"list\":[{\"shoplist\":{\"shopid\":\"18AK2Q0R4BLVBN00A1BAQJMCENOB04KM\",\"shopname\":\"阿斯顿\",\"squarelogo\":\"http://img.gooagoo.com/marketing/2013/11/30/6B7910A8B922635DA579A3F8A500BDEF.png\",\"oblonglogo\":\"http://img.gooagoo.com/marketing/2013/11/30/931E8BFDC731E350E69E9F24A77BD1FE.png\",\"shopfirstchar\":\"\",\"shoptypeleaf\":\"咖啡厅\",\"isdel\":\"N\",\"ctimestamp\":\"2013-11-30 19:04:40\"}}]}', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'DF79AB1EA08F4B4887727D05CC8EECC7', '查询商家会员卡信息列表', null, 'moba09', '0', 'Shopcardinfo[]', null, '<list>\n  <shopcardinfo>\n    <cardname>test</cardname>\n    <cardheadurl>http://html.gooagoo.com/upload/marketing/2013/08/20/38F9083CA2B200CCB41C29784E3E5488_dh_top.jpg</cardheadurl>\n    <cardbodyurl>http://html.gooagoo.com/upload/marketing/2013/08/20/38F9083CA2B200CCB41C29784E3E5488_dh_bottom.jpg</cardbodyurl>\n    <needjifen>0</needjifen>\n    <description>steste</description>\n    <uselimited>9999</uselimited>\n    <createtime>2013-08-20 10:48:00</createtime>\n  </shopcardinfo>\n  <shopcardinfo>\n    <cardname>测试商家基本卡</cardname>\n    <cardheadurl>http://html.gooagoo.com/upload/marketing/2013/09/18/84ED755D1C88A6C1B56D8AEC2E88A31E_dh_top.jpg</cardheadurl>\n    <cardbodyurl>http://html.gooagoo.com/upload/marketing/2013/09/18/84ED755D1C88A6C1B56D8AEC2E88A31E_dh_bottom.jpg</cardbodyurl>\n    <needjifen>0</needjifen>\n    <description>aaaaaaa</description>\n    <uselimited>90</uselimited>\n    <createtime>2013-09-18 10:50:48</createtime>\n  </shopcardinfo>\n  <shopcardinfo>\n    <cardname>测试高级卡</cardname>\n    <cardheadurl>http://img.gooagoo.com/marketing/2013/09/27/BAD9FDC6B2F37069EB24C2E5D83B2B85_dh_top.jpg</cardheadurl>\n    <cardbodyurl>http://img.gooagoo.com/marketing/2013/09/27/BAD9FDC6B2F37069EB24C2E5D83B2B85_dh_bottom.jpg</cardbodyurl>\n    <needjifen>500</needjifen>\n    <description>测试高级卡500积分可升级</description>\n    <uselimited>100</uselimited>\n    <createtime>2013-09-27 10:52:09</createtime>\n  </shopcardinfo>\n  <shopcardinfo>\n    <cardname>测试商家高级银卡</cardname>\n    <cardheadurl>http://img.gooagoo.com/marketing/2013/10/30/71B6F1B6D4F82D440B151A3EF3FEE573_dh_top.jpg</cardheadurl>\n    <cardbodyurl>http://img.gooagoo.com/marketing/2013/10/30/71B6F1B6D4F82D440B151A3EF3FEE573_dh_bottom.jpg</cardbodyurl>\n    <needjifen>999</needjifen>\n    <description>积分达到999时，可申请升级为此卡</description>\n    <uselimited>92</uselimited>\n    <createtime>2013-10-30 14:53:45</createtime>\n  </shopcardinfo>\n</list>', '\n{\"list\":[{\"shopcardinfo\":[{\"cardname\":\"test\",\"cardheadurl\":\"http://html.gooagoo.com/upload/marketing/2013/08/20/38F9083CA2B200CCB41C29784E3E5488_dh_top.jpg\",\"cardbodyurl\":\"http://html.gooagoo.com/upload/marketing/2013/08/20/38F9083CA2B200CCB41C29784E3E5488_dh_bottom.jpg\",\"needjifen\":0,\"description\":\"steste\",\"uselimited\":9999,\"createtime\":\"2013-08-20 10:48:00\"},{\"cardname\":\"测试商家基本卡\",\"cardheadurl\":\"http://html.gooagoo.com/upload/marketing/2013/09/18/84ED755D1C88A6C1B56D8AEC2E88A31E_dh_top.jpg\",\"cardbodyurl\":\"http://html.gooagoo.com/upload/marketing/2013/09/18/84ED755D1C88A6C1B56D8AEC2E88A31E_dh_bottom.jpg\",\"needjifen\":0,\"description\":\"aaaaaaa\",\"uselimited\":90,\"createtime\":\"2013-09-18 10:50:48\"},{\"cardname\":\"测试高级卡\",\"cardheadurl\":\"http://img.gooagoo.com/marketing/2013/09/27/BAD9FDC6B2F37069EB24C2E5D83B2B85_dh_top.jpg\",\"cardbodyurl\":\"http://img.gooagoo.com/marketing/2013/09/27/BAD9FDC6B2F37069EB24C2E5D83B2B85_dh_bottom.jpg\",\"needjifen\":500,\"description\":\"测试高级卡500积分可升级\",\"uselimited\":100,\"createtime\":\"2013-09-27 10:52:09\"},{\"cardname\":\"测试商家高级银卡\",\"cardheadurl\":\"http://img.gooagoo.com/marketing/2013/10/30/71B6F1B6D4F82D440B151A3EF3FEE573_dh_top.jpg\",\"cardbodyurl\":\"http://img.gooagoo.com/marketing/2013/10/30/71B6F1B6D4F82D440B151A3EF3FEE573_dh_bottom.jpg\",\"needjifen\":999,\"description\":\"积分达到999时，可申请升级为此卡\",\"uselimited\":92,\"createtime\":\"2013-10-30 14:53:45\"}]}]}', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'DF79AB1EA08F4B4887727D05CC8EECC7', '用户申请电子会员卡', null, 'moba10', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'DF79AB1EA08F4B4887727D05CC8EECC7', '用户得到通知', null, 'moba04', '0', 'MembernoticesDetail', null, '<membernoticesdetail>\n  <membernoticeList>\n    <membernotice>\n      <isread>N</isread>\n      <noticeinfoid>18AERR78PIMNF500A1BAQJME96C209G7</noticeinfoid>\n      <pageid>2013-11-28 16:06:0718AERSN2N4F87G00A1BAQJMC6LEMAMKI</pageid>\n      <noticeuserid>18AERSN2N4F87G00A1BAQJMC6LEMAMKI</noticeuserid>\n      <shopid>01822R97QK2FRDT085QBV2EIISWR0JGT</shopid>\n      <logo>http://html.gooagoo.com/upload/marketing/2013/08/23/73CE2EBA873045E25EFC408B474AADC3.jpg</logo>\n      <title>测试通知</title>\n      <noticetextmobile>测试通知</noticetextmobile>\n      <ctimestamp>2013-11-28 16:05:59</ctimestamp>\n      <isdel>N</isdel>\n    </membernotice>\n  </membernoticeList>\n  <isdeleted>\n    <noticeidstr></noticeidstr>\n    <flag>Y</flag>\n    <ctimestamp>2013-11-28 16:05:59</ctimestamp>\n  </isdeleted>\n</membernoticesdetail>', '{\"membernoticesdetail\":{\"membernoticeList\":[{\"membernotice\":{\"isread\":\"N\",\"noticeinfoid\":\"18AERR78PIMNF500A1BAQJME96C209G7\",\"pageid\":\"2013-11-28 16:06:0718AERSN2N4F87G00A1BAQJMC6LEMAMKI\",\"noticeuserid\":\"18AERSN2N4F87G00A1BAQJMC6LEMAMKI\",\"shopid\":\"01822R97QK2FRDT085QBV2EIISWR0JGT\",\"logo\":\"http://html.gooagoo.com/upload/marketing/2013/08/23/73CE2EBA873045E25EFC408B474AADC3.jpg\",\"title\":\"测试通知\",\"noticetextmobile\":\"测试通知\",\"ctimestamp\":\"2013-11-28 16:05:59\",\"isdel\":\"N\"}}],\"isdeleted\":{\"noticeidstr\":\"\",\"flag\":\"Y\",\"ctimestamp\":\"2013-11-28 16:05:59\"}}}', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'DF79AB1EA08F4B4887727D05CC8EECC7', '用户是否同意发卡', null, 'moba12', '0', 'Usermembercard', null, '<usermembercard>\n  <scardno>2200010000001100</scardno>\n  <scardnotdcurl>http://code.gooagoo.com/two?c=2200010000001100&amp;s=20</scardnotdcurl>\n  <scardnourl>http://audio.gooagoo.com/audio/info?para=2200010000001100</scardnourl>\n  <phycardno>2200010000001100</phycardno>\n  <cardid>185JSOVAQTK4A500A1BAQJMEBF5EOEKT</cardid>\n  <userid>18438ST1UIN7UP00A1BAQJMCILSK8JPT</userid>\n  <shopid>185EVK63KPRTKH00A1BAQJMCA2H349CC</shopid>\n  <useableintegralnumber></useableintegralnumber>\n  <expiredate>2041-04-26 11:34:17</expiredate>\n  <isdel>N</isdel>\n  <createtime>2013-12-10 11:34:10</createtime>\n  <ctimestamp>2013-12-10 11:34:10</ctimestamp>\n  <needshare></needshare>\n  <sharetimes></sharetimes>\n  <shareuserid></shareuserid>\n  <sharedemail></sharedemail>\n  <sharednickname></sharednickname>\n  <shareexpiredate></shareexpiredate>\n</usermembercard>', '{\"usermembercard\":{\"scardno\":2200010000000300,\"scardnotdcurl\":\"http://code.gooagoo.com/two?c=2200010000000300&s=20\",\"scardnourl\":\"http://audio.gooagoo.com/audio/info?para=2200010000000300\",\"phycardno\":2200010000000300,\"cardid\":\"185JSOVAQTK4A500A1BAQJMEBF5EOEKT\",\"userid\":\"01822RBQ22JSDMA085QBV8EIISWR0JGT\",\"shopid\":\"185EVK63KPRTKH00A1BAQJMCA2H349CC\",\"useableintegralnumber\":0,\"expiredate\":\"2041-04-26 13:25:00\",\"isdel\":\"N\",\"createtime\":\"2013-10-25 16:59:53\",\"ctimestamp\":\"2013-12-10 13:24:53\",\"needshare\":\"\",\"sharetimes\":\"\",\"shareuserid\":\"\",\"sharedemail\":\"\",\"sharednickname\":\"\",\"shareexpiredate\":\"\"}}', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'DF79AB1EA08F4B4887727D05CC8EECC7', '查询会员信息', null, 'moba13', '0', 'Memberbaseinfo', null, '<memberbaseinfo>\n  <name>123</name>\n  <sex>F</sex>\n  <birthday>1992-11-29</birthday>\n  <idtype>00</idtype>\n  <idno>140428199211296826</idno>\n  <mobile>13811111111</mobile>\n  <telephone></telephone>\n  <email></email>\n  <postcode></postcode>\n  <address>555</address>\n  <memberspecialinfo>\n    <memberspecialinfo>\n      <typecode>weight</typecode>\n      <typename>体重</typename>\n      <enumvalue>[&quot;50-60&quot;,&quot;60-70&quot;,&quot;70-80&quot;,&quot;80-90&quot;,&quot;90-100&quot;,&quot;100-110&quot;,&quot;110-120&quot;,&quot;120-130&quot;]</enumvalue>\n      <featurevalue></featurevalue>\n    </memberspecialinfo>\n    <memberspecialinfo>\n      <typecode>height</typecode>\n      <typename>身高</typename>\n      <enumvalue>[&quot;150以下&quot;,&quot;150-160&quot;,&quot;160-170&quot;,&quot;170-180&quot;,&quot;180-190&quot;]</enumvalue>\n      <featurevalue></featurevalue>\n    </memberspecialinfo>\n    <memberspecialinfo>\n      <typecode>color</typecode>\n      <typename>皮肤颜色</typename>\n      <enumvalue>[&quot;黄色&quot;,&quot;黑色&quot;,&quot;米色&quot;,&quot;白色&quot;]</enumvalue>\n      <featurevalue></featurevalue>\n    </memberspecialinfo>\n    <memberspecialinfo>\n      <typecode>1</typecode>\n      <typename>职业</typename>\n      <enumvalue>[&quot;教师&quot;,&quot;商人&quot;,&quot;自由职业者&quot;,&quot;工人&quot;,&quot;农民&quot;]</enumvalue>\n      <featurevalue></featurevalue>\n    </memberspecialinfo>\n    <memberspecialinfo>\n      <typecode>2</typecode>\n      <typename>爱好</typename>\n      <enumvalue>[&quot;体育&quot;,&quot;音乐&quot;,&quot;其他&quot;]</enumvalue>\n      <featurevalue></featurevalue>\n    </memberspecialinfo>\n  </memberspecialinfo>\n</memberbaseinfo>', '{\"memberbaseinfo\":{\"name\":123,\"sex\":\"F\",\"birthday\":\"1992-11-29\",\"idtype\":\"00\",\"idno\":140428199211296826,\"mobile\":13811111111,\"telephone\":\"\",\"email\":\"\",\"postcode\":\"\",\"address\":555,\"memberspecialinfo\":[{\"memberspecialinfo\":[{\"typecode\":\"weight\",\"typename\":\"体重\",\"enumvalue\":\"[\"50-60\",\"60-70\",\"70-80\",\"80-90\",\"90-100\",\"100-110\",\"110-120\",\"120-130\"]\",\"featurevalue\":\"\"},{\"typecode\":\"height\",\"typename\":\"身高\",\"enumvalue\":\"[\"150以下\",\"150-160\",\"160-170\",\"170-180\",\"180-190\"]\",\"featurevalue\":\"\"},{\"typecode\":\"color\",\"typename\":\"皮肤颜色\",\"enumvalue\":\"[\"黄色\",\"黑色\",\"米色\",\"白色\"]\",\"featurevalue\":\"\"},{\"typecode\":1,\"typename\":\"职业\",\"enumvalue\":\"[\"教师\",\"商人\",\"自由职业者\",\"工人\",\"农民\"]\",\"featurevalue\":\"\"},{\"typecode\":2,\"typename\":\"爱好\",\"enumvalue\":\"[\"体育\",\"音乐\",\"其他\"]\",\"featurevalue\":\"\"}]}]}}', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'DF79AB1EA08F4B4887727D05CC8EECC7', '修改会员信息', null, 'moba14', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAeeeeee', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '添加商品', null, 'goda01', '0', 'AddGoodsInfoResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAffffff', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '修改商品信息', null, 'goda02', '0', 'UpdGoodsInfoResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAgggggg', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '修改库存状态', null, 'goda03', '0', 'UpdGoodsStockInfoResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUItertrr', 'FEA7D3D5668E42509D97408250DDeeee', '修改会员信息', null, 'gmba02', '0', 'UpdMemberResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUItesdsd', 'FEA7D3D5668E42509D97408250DDeeee', '查询会员信息', null, 'gmba03', '0', 'QueryMemberResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8PEQD0DUItyyyyyy', 'FEA7D3D5668E42509D97408250DDeeee', '添加会员信息', null, 'gmba01', '0', 'AddMemberResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', '255734C3D1814AB08B4E91C2BEC7FABC', '基本信息', null, 'mobg01', '0', 'BaseInfo', null, '<baseinfo>\n  <shopinfosynctimestampArray/>\n  <synctimestampArray>\n    <goodsctimestamp></goodsctimestamp>\n    <shoptypectimestamp></shoptypectimestamp>\n  </synctimestampArray>\n  <shopinfoArray/>\n  <imobilelistgArray/>\n  <shopentityinfoArray/>\n  <shopentitylinkArray/>\n  <shoplidinfoArray/>\n  <shopgpsinfoArray/>\n  <shopwifiinfoArray/>\n  <shopinvoiceinfoArray>\n    <shopinvoiceinfo>\n      <shopid></shopid>\n      <shopentityid></shopentityid>\n      <invoicetypep/>\n      <invoicetypec/>\n      <ctimestamp></ctimestamp>\n    </shopinvoiceinfo>\n  </shopinvoiceinfoArray>\n  <shopsvginfoArray/>\n  <shoptoolArray/>\n  <membercardArray/>\n  <goodsArray/>\n  <shoptypeArray/>\n</baseinfo>', '{\n    \"baseinfo\": {\n        \"shopinfosynctimestampArray\": [\n            \"\"\n        ],\n        \"synctimestampArray\": {\n            \"goodsctimestamp\": \"\",\n            \"shoptypectimestamp\": \"\"\n        },\n        \"shopinfoArray\": [\n            \"\"\n        ],\n        \"imobilelistgArray\": [\n            \"\"\n        ],\n        \"shopentityinfoArray\": [\n            \"\"\n        ],\n        \"shopentitylinkArray\": [\n            \"\"\n        ],\n        \"shoplidinfoArray\": [\n            \"\"\n        ],\n        \"shopgpsinfoArray\": [\n            \"\"\n        ],\n        \"shopwifiinfoArray\": [\n            \"\"\n        ],\n        \"shopinvoiceinfoArray\": [\n            {\n                \"shopinvoiceinfo\": {\n                    \"shopid\": \"\",\n                    \"shopentityid\": \"\",\n                    \"invoicetypep\": [\n                        \"\"\n                    ],\n                    \"invoicetypec\": [\n                        \"\"\n                    ],\n                    \"ctimestamp\": \"\"\n                }\n            }\n        ],\n        \"shopsvginfoArray\": [\n            \"\"\n        ],\n        \"shoptoolArray\": [\n            \"\"\n        ],\n        \"membercardArray\": [\n            \"\"\n        ],\n        \"goodsArray\": [\n            \"\"\n        ],\n        \"shoptypeArray\": [\n            \"\"\n        ]\n    }\n}', 'N', '2013-12-09 16:23:02');
INSERT INTO `open_interface_info` VALUES ('18B0CF6NCV4GB7TTEEEEQD0DUdddddd', 'FEA7D3D5668E42509D97408250DDqww', '查询订单信息', null, 'gtea01', '0', 'QueryOneOrderInfoResponse', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0OPI861PEA62G8PEQD0DUL95LKNHS', '22456D9D35004999B5FAB0E7EC19DCCD', ' 地图下载', null, 'mobi07', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 14:58:54');
INSERT INTO `open_interface_info` VALUES ('18B0OPI861VFGR2G8PEQD0DULA5LKNHT', '22456D9D35004999B5FAB0E7EC19DCCD', '收集lid信息', null, 'mobi06', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 14:59:02');
INSERT INTO `open_interface_info` VALUES ('18B0OPI8620GNM2G8PEQD0DULB5LKNHU', '22456D9D35004999B5FAB0E7EC19DCCD', '地图内商家列表', null, 'mobi05', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 14:59:11');
INSERT INTO `open_interface_info` VALUES ('18B0OPI86236PT2G8PEQD0DULC5LKNHV', '22456D9D35004999B5FAB0E7EC19DCCD', '导航（起点{x,y}，实体店编号或商品编号）', null, 'mobi04', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 14:59:21');
INSERT INTO `open_interface_info` VALUES ('18B0OPI87249PS2G8PEQD0DULD5LKNI0', '22456D9D35004999B5FAB0E7EC19DCCD', '导航（起点{x,y}，终点{x,y}）', null, 'mobi03 ', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 14:59:31');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92G6PEQD0UULE5M4NI1', 'F128A040AE584F719D787B738B0AB43C', '查看菜谱', null, 'mobh02', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:24:43');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI2', 'F128A040AE584F719D787B738B0AB43C', '查看菜单', null, 'mobh03', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:24:43');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI3', 'F128A040AE584F719D787B738B0AB43C', '查看已点菜品', null, 'mobh04', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:24:43');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI4', 'F128A040AE584F719D787B738B0AB43C', '申请结账', null, 'mobh05', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:24:43');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI5', 'F128A040AE584F719D787B738B0AB43C', '扫描商品', null, 'mobh06', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:24:43');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI6', 'F128A040AE584F719D787B738B0AB43C', '查看购物车', null, 'mobh07', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:24:43');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI7', 'F128A040AE584F719D787B738B0AB43C', '进入购物匹配', null, 'mobh08', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:24:43');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI8', 'F128A040AE584F719D787B738B0AB43C', '查看账单', null, 'mobh10', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:24:43');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI9', 'F128A040AE584F719D787B738B0AB43C', '申请开发票', null, 'mobh11', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:24:43');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI1', '394A7D189E404C35B8CDDE9560447319', '添加商品到购物车', null, 'mobn01', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI2', '394A7D189E404C35B8CDDE9560447319', '编辑购物车中商品信息', null, 'mobn02', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI3', '394A7D189E404C35B8CDDE9560447319', '删除购物车中的商品信息', null, 'mobn03', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI4', '394A7D189E404C35B8CDDE9560447319', '查询购物车中的商品信息', null, 'mobn04', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI5', '394A7D189E404C35B8CDDE9560447319', '查询用户购过商品次数排行', null, 'mobn05', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI6', '394A7D189E404C35B8CDDE9560447319', '再次购买', null, 'mobn06', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI7', '2CB8865437784206A52B3B5927A4A265', '手机订单支付接口', null, 'mobm01', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI8', '2CB8865437784206A52B3B5927A4A265', '手机订单交易状态查询接口', null, 'mobm02', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', '96A7608958864997BF8920490E8A7654', '用户口令更改', null, 'mobf04', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-06 10:19:22');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '添加商品信息', null, 'addGoods', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-12 16:09:37');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '修改商品信息', null, 'editGoods', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-12 16:14:45');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQWQD0U5M4NI477', '96A7608958864997BF8920490E8A7654', '用户注册(手机号-获取短信验证码)', null, 'mobf09', '0', 'boolean', null, ' <boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-06 10:24:49');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI48', '96A7608958864997BF8920490E8A7654', '用户注册(手机号-输入短信验证码)', null, 'mobf10', '0', 'boolean', null, ' <boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-06 10:24:49');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', '96A7608958864997BF8920490E8A7654', '获取APP最新版本', null, 'mobf11', '0', 'Versionlist', null, '<versionlist>\n  <appcode>com.gooagoo</appcode>\n  <mobiletype>1</mobiletype>\n  <versioncode>4</versioncode>\n  <versionname>版本时间2013年11月12日11:04:53</versionname>\n  <platform>android</platform>\n  <note>修改商品详情页、优惠券详情页为网页显示&#xd;\n修改商品详情页、优惠券详情页为网页显示</note>\n  <downloadurl>http://img.gooagoo.com/client/2013/11/13/2206D38AB95E44C3A97B270F7A0D3397.apk</downloadurl>\n  <createtime>2013-11-13 10:25:15</createtime>\n</versionlist>', '{\"versionlist\":{\"appcode\":\"com.gooagoo\",\"mobiletype\":1,\"versioncode\":4,\"versionname\":\"版本时间2013年11月12日11:04:53\",\"platform\":\"android\",\"note\":\"修改商品详情页、优惠券详情页为网页显示\r\n修改商品详情页、优惠券详情页为网页显示\",\"downloadurl\":\"http://img.gooagoo.com/client/2013/11/13/2206D38AB95E44C3A97B270F7A0D3397.apk\",\"createtime\":\"2013-11-13 10:25:15\"}}\n', 'N', '2013-12-06 10:25:19');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', '96A7608958864997BF8920490E8A7654', '意见反馈', null, 'mobf07', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-06 10:24:49');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI46', '96A7608958864997BF8920490E8A7654', '获取gooagooid', null, 'mobf08', '0', 'String', null, '<string>18BDMVUE9FCQF400A1BAQJMCBJ7OEEI1</string>', '{\"string\":\"18BDN2GL3DDEUM00A1BAQJMCBL7OEEI3\"}', 'N', '2013-12-06 10:24:49');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', '96A7608958864997BF8920490E8A7654', '用户获取基本信息', null, 'mobf06', '0', 'Userinfo', null, '<userinfo> \n  <nickname>ddddd</nickname>  \n  <realname>sdfdfsd</realname>  \n  <sex>M</sex>  \n  <birthday>1990-06-26</birthday>  \n  <idtype>03</idtype>  \n  <idno>080508210</idno>  \n  <phone>12345678912</phone>  \n  <postcode>247220</postcode>  \n  <address>北京</address>  \n  <isallowfriend>N</isallowfriend> \n</userinfo>', '{\"userinfo\":{\"nickname\":\"ddddd\",\"realname\":\"sdfdfsd\",\"sex\":\"M\",\"birthday\":\"1990-06-26\",\"idtype\":\"03\",\"idno\":\"080508210\",\"phone\":\"12345678912\",\"postcode\":247220,\"address\":\"北京\",\"isallowfriend\":\"N\"}}\n', 'N', '2013-12-06 10:24:07');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', '96A7608958864997BF8920490E8A7654', '用户更改基本信息', null, 'mobf05', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-06 10:22:51');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI10', '52B045F1702141279084BE16297A4ABD', '是否允许用户播放优惠劵音频', null, 'mobl01', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI11', '52B045F1702141279084BE16297A4ABD', '是否允许用户播放订单音频', null, 'mobl02', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI12', '52B045F1702141279084BE16297A4ABD', '是否允许用户播放提货凭证音频', null, 'mobl03', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI13', '52B045F1702141279084BE16297A4ABD', '是否允许用户播放取发票音频', null, 'mobl04', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI14', '52B045F1702141279084BE16297A4ABD', '是否允许用户播放会员卡音频', null, 'mobl05', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI15', '448EAFE7C44C4DDF9D6A06F77CCAEF9C', '按日期查询用户消费信息记录', null, 'mobk01', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI16', '448EAFE7C44C4DDF9D6A06F77CCAEF9C', '按月份查询用户消费信息记录', null, 'mobk02', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI17', '448EAFE7C44C4DDF9D6A06F77CCAEF9C', '已购买过的商品', null, 'mobk03', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI18', 'F128A040AE584F719D787B738B0QQ43C', '记录用户使用手机行为', null, 'mobj01', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI19', 'F128A040AE584F719D787B738B0QQ43C', '记录用户使用服务工具行为', null, 'mobj02', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 17:57:27');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI20', '22456D9D35004999B5FAB0E7EC19DCCD', '查询当前商场内商家或商品位置信息', null, 'mobi02', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 13:53:48');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI21', 'F128A040AE584F719D787B738B0AB43C', '滑动刷卡', null, 'mobh01 ', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 13:49:43');
INSERT INTO `open_interface_info` VALUES ('18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI22', '22456D9D35004999B5FAB0E7EC19DCCD', '当前地图全部活动查询', null, 'mobi01', '0', 'object', null, 'object', 'object', 'N', '2013-12-05 13:55:40');
INSERT INTO `open_interface_info` VALUES ('18BIT48FKML20C2G8PEQD0DUQG20OTR9', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '删除商品信息', null, 'delGoods', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-12 16:02:06');
INSERT INTO `open_interface_info` VALUES ('18BIT48FKMRRRM2G8PEQD0DUQH20OTRA', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '审核商品', null, 'checkGoods', '0', 'boolean', '', '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-12 16:16:20');
INSERT INTO `open_interface_info` VALUES ('18BIT48FKMT2DU2G8PEQD0DUQI20OTRB', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '发布商品', null, 'publishGoods', '0', 'boolean', '', '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-12 16:20:44');
INSERT INTO `open_interface_info` VALUES ('18BIT48FKMU3KP2G8PEQD0DUQJ20OTRC', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '重新发布单个商品', null, 'republishGoods', '0', 'boolean', '', '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-12 16:20:44');
INSERT INTO `open_interface_info` VALUES ('18BIT48FKMVB9B2G8PEQD0DUQK20OTRD', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '重新发布实体店所有商品', null, 'republishAllGoods', '0', 'boolean', '', '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-12 16:20:44');
INSERT INTO `open_interface_info` VALUES ('18BJ0E8GOA09SC2G8PEQD0DU797I03LS', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '22222', null, '222', '2', '2', null, '2', '2', 'N', '2013-12-12 16:57:59');
INSERT INTO `open_interface_info` VALUES ('18DF038LTQRGA90SHURCPR2CHK44GCUH', '18DIL9LLT3EM2U0SHURCPR2CHP26OCUM', '位置信息接口', null, 'gsha01', '0', 'ShopPositionResponse', null, null, null, 'N', '2014-01-04 23:52:50');
INSERT INTO `open_interface_info` VALUES ('18DIPGVSAU3MPT0SHURCPR2CTV1NCT5Q', '18BJ05NPJHCEL12G8PEQD0DU787I03LR', '添加商品品类接口', null, 'goda04', '0', 'AddGoodscategoryinfoResponse', null, null, null, 'N', '2014-01-06 11:26:41');
INSERT INTO `open_interface_info` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'DF79AB1EA08F4B4887727D05CC8EECC7', '查询用户会员卡列表', null, 'moba01', '0', 'UserMemberCardDetail', null, '<usermembercarddetail>\n<usermembercardList>\n    <usermembercard>\n      <scardno>1000000000000300</scardno>\n      <scardnotdcurl>http://code.gooagoo.com/two?c=1000000000000300&amp;s=20</scardnotdcurl>\n      <scardnourl>http://audio.gooagoo.com/audio/info?para=1000000000000300</scardnourl>\n      <phycardno>1000000000000300</phycardno>\n      <cardid>0182A7OVJF1FL3Q0I3TDLPEIISWR2GDJ</cardid>\n      <userid>01822RBQ22JSDMA085QBV8EIISWR0JGT</userid>\n      <shopid>01822IE57DH111M085QBPFEIISWR0JGT</shopid>\n      <useableintegralnumber>301</useableintegralnumber>\n      <expiredate>2041-04-25 14:04:15</expiredate>\n      <createtime>2013-08-22 09:49:15</createtime>\n      <ctimestamp>2013-12-09 14:04:12</ctimestamp>\n      <needshare></needshare>\n      <sharetimes></sharetimes>\n      <shareuserid></shareuserid>\n      <sharedemail></sharedemail>\n      <sharednickname></sharednickname>\n      <shareexpiredate></shareexpiredate>\n    </usermembercard>\n  </usermembercardList>\n  <noreadnoticeinfoList>\n    <noreadnoticeinfo>\n      <shopid>01822IE57DH111M085QBPFEIISWR0JGT</shopid>\n      <noreadnoticenums>8</noreadnoticenums>\n    </noreadnoticeinfo>\n    <noreadnoticeinfo>\n      <shopid>01822MAPVKNP054085QBQVEIISWR0JGT</shopid>\n      <noreadnoticenums>8</noreadnoticenums>\n    </noreadnoticeinfo>\n    <noreadnoticeinfo>\n      <shopid>01822R97QK2FRDT085QBV2EIISWR0JGT</shopid>\n      <noreadnoticenums>13</noreadnoticenums>\n    </noreadnoticeinfo>\n    <noreadnoticeinfo>\n      <shopid>185EVK63KPRTKH00A1BAQJMCA2H349CC</shopid>\n      <noreadnoticenums>4</noreadnoticenums>\n    </noreadnoticeinfo>\n  </noreadnoticeinfoList>\n  <isdeleted>\n    <scardnostr>1002000000000300,2100020000000300,2100020000000311,2200010000000300</scardnostr>\n    <count>2</count>\n  </isdeleted>\n</usermembercarddetail>', '{\"usermembercarddetail\":{\"usermembercardList\":[{\"usermembercard\":{\"scardno\":1000000000000300,\"scardnotdcurl\":\"http://code.gooagoo.com/two?c=1000000000000300&s=20\",\"scardnourl\":\"http://audio.gooagoo.com/audio/info?para=1000000000000300\",\"phycardno\":1000000000000300,\"cardid\":\"0182A7OVJF1FL3Q0I3TDLPEIISWR2GDJ\",\"userid\":\"01822RBQ22JSDMA085QBV8EIISWR0JGT\",\"shopid\":\"01822IE57DH111M085QBPFEIISWR0JGT\",\"useableintegralnumber\":301,\"expiredate\":\"2041-04-25 14:04:15\",\"createtime\":\"2013-08-22 09:49:15\",\"ctimestamp\":\"2013-12-09 14:04:12\",\"needshare\":\"\",\"sharetimes\":\"\",\"shareuserid\":\"\",\"sharedemail\":\"\",\"sharednickname\":\"\",\"shareexpiredate\":\"\"}}],\"noreadnoticeinfoList\":[{\"noreadnoticeinfo\":[{\"shopid\":\"01822IE57DH111M085QBPFEIISWR0JGT\",\"noreadnoticenums\":8},{\"shopid\":\"01822MAPVKNP054085QBQVEIISWR0JGT\",\"noreadnoticenums\":8},{\"shopid\":\"01822R97QK2FRDT085QBV2EIISWR0JGT\",\"noreadnoticenums\":13},{\"shopid\":\"185EVK63KPRTKH00A1BAQJMCA2H349CC\",\"noreadnoticenums\":4}]}],\"isdeleted\":{\"scardnostr\":\"1002000000000300,2100020000000300,2100020000000311,2200010000000300\",\"count\":2}}}', 'N', '2013-12-04 14:09:56');
INSERT INTO `open_interface_info` VALUES ('DF79AB1EA08F4B4887727D05CC8EEC93', 'DF79AB1EA08F4B4887727D05CC8EECC7', '手机端删除会员卡', null, 'moba02', '0', 'boolean', null, '<boolean>true</boolean>', '{\"boolean\":true}', 'N', '2013-12-04 14:49:58');
INSERT INTO `open_interface_info` VALUES ('F58A76CB1F2C4FA8A6342933C9477614', '394A7D189E404C35B8CDDE9560447319', '添加商品到购物车', null, 'mobn01', '0', 'String', null, 'object', 'object', 'N', '2013-12-05 10:19:34');

-- ----------------------------
-- Table structure for `open_interface_log`
-- ----------------------------
DROP TABLE IF EXISTS `open_interface_log`;
CREATE TABLE `open_interface_log` (
  `log_id` char(32) NOT NULL COMMENT '日志ID',
  `interface_code` varchar(20) NOT NULL COMMENT '接口代码',
  `access_type` char(1) DEFAULT NULL COMMENT '访问类型：0 APP_KEY调用，1 Token调用',
  `access_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '访问时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口调用日志表';

-- ----------------------------
-- Records of open_interface_log
-- ----------------------------

-- ----------------------------
-- Table structure for `open_interface_parms`
-- ----------------------------
DROP TABLE IF EXISTS `open_interface_parms`;
CREATE TABLE `open_interface_parms` (
  `interface_id` char(32) NOT NULL COMMENT '接口ID',
  `parameter_name` varchar(30) NOT NULL COMMENT '参数名',
  `parameter_type` char(30) DEFAULT NULL COMMENT '参数类型',
  `parameter_des` varchar(200) DEFAULT NULL COMMENT '参数描述',
  `example` varchar(400) DEFAULT NULL COMMENT '示例值',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必须，0可以为空，1不能为空',
  `update_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`interface_id`,`parameter_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口入参表';

-- ----------------------------
-- Records of open_interface_parms
-- ----------------------------
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH6', 'account', 'String', '用户登录账户', '邮箱或手机号', '1', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH6', 'entityposition', 'String', '实体店编号，用户当前所在实体店编号', '', '0', '2013-12-09 13:29:13');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH6', 'iphonetoken', 'String', 'Iphone的token值', '', '0', '2013-12-09 13:29:13');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH6', 'lid', 'String', 'lid', '', '0', '2013-12-09 13:29:13');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH6', 'mac', 'String', '手机mac地址', '', '0', '2013-12-09 13:23:27');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH6', 'mver', 'String', '手机程序版本', '', '0', '2013-12-09 13:29:13');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH6', 'password', 'String', '密码', null, '1', '2013-12-09 11:38:34');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH7', 'email', 'String', '用户邮箱', '', '1', '2013-12-09 13:48:51');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH7', 'entityposition', 'String', '实体店编号，用户当前所在实体店编号', '', '0', '2013-12-09 13:48:51');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH7', 'lid', 'String', 'lid', '', '0', '2013-12-09 13:48:51');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH7', 'mac', 'String', '手机mac地址', '', '0', '2013-12-09 13:48:51');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH7', 'mver', 'String', '手机程序版本', '', '0', '2013-12-09 13:48:51');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH7', 'password', 'String', 'password', '', '1', '2013-12-09 13:48:51');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T10', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T10', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T10', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T10', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T10', 'noticeuserid', 'String', '通知和用户关联表的UUID', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T10', 'sessionid', 'String', 'sessionid值', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T10', 'userid', 'String', '用户id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'idno', 'String', '店铺id', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'mobile', 'String', '店铺id', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'phyno', 'String', '实体卡号', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'sessionid', 'String', 'sessionid值', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'shopid', 'String', '店铺id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'userid', 'String', '用户id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'pageindex', 'String', '页码', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'pagesize', 'String', '每页显示信息条数', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'sessionid', 'String', 'sessionid值', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'userid', 'String', '用户id', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH2', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH2', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH2', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH2', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH2', 'sessionid', 'String', 'sessionid值', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH2', 'shopid', 'String', '店铺id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH2', 'userid', 'String', '用户id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'keyword', 'String', '关键字', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'pagesize', 'String', '每页显示信息条数', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'pagetype', 'String', '翻页类型', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'sessionid', 'String', 'sessionid值', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'shopid', 'String', '店铺id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'shoptype', 'String', '商家类别', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'userid', 'String', '用户id', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'sessionid', 'String', 'sessionid值', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'shopid', 'String', '店铺id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'userid', 'String', '用户id', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'address', 'String', '店铺id', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'birthday', 'String', '店铺id', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'idno', 'String', '店铺id', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'mobile', 'String', '店铺id', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'postcode', 'String', '店铺id', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'realname', 'String', '店铺id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'sessionid', 'String', 'sessionid值', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'sex', 'String', '店铺id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'shopid', 'String', '店铺id', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'userid', 'String', '用户id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'ctimestamp', 'String', '时间戳', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'pageid', 'String', '分页编号', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'pagesize', 'String', '每页显示信息条数', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'pagetype', 'String', '翻页类型', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'sessionid', 'String', 'sessionid值', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'shopentityid', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'shopid', 'String', '商家编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'userid', 'String', '用户id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'cardid', 'String', '卡号', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'cardtype', 'String', '卡类型', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'isagree', 'String', '是否同意', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'sessionid', 'String', 'sessionid值', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'shopid', 'String', '店铺id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'userid', 'String', '用户id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'sessionid', 'String', 'sessionid值', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'shopid', 'String', '店铺id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'userid', 'String', '用户id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'address', 'String', '地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'birthday', 'String', '生日', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'email', 'String', '电子邮箱', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'idno', 'String', '证件号码', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'idtype', 'String', '证件类型', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'memberspecialinfo', 'String', '特征值', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'mobile', 'String', '手机号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'name', 'String', '姓名', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'postcode', 'String', '邮编', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'sessionid', 'String', 'sessionid值', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'sex', 'String', '性别', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'shopid', 'String', '店铺id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'telephone', 'String', '联系电话', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'userid', 'String', '用户id', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'containcode', 'String', '同步范围(对应返回报文中“containcode”，多个时以逗号分隔)', '例如“A,B,C”;为空时查询所有,A-商家基本信息B-购物计划商品分类 信息C-商家类型信息', '1', '2013-12-12 09:13:04');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'entityposition', 'String', '实体店编号(用户当前所在实体店编号)', '', '0', '2013-12-09 16:27:37');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'lid', 'String', 'lid', '', '0', '2013-12-09 16:27:37');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'mac', 'String', '手机mac地址', '', '0', '2013-12-09 16:27:37');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'mver', 'String', '手机程序版本', '', '0', '2013-12-09 16:27:37');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'sessionid', 'String', 'sessionid值(手机登录后的sessionid值)', '', '0', '2013-12-09 16:27:37');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'syninfo', 'String', '同步信息', 'json串，格式： { \"shopinfo\": [ { \"shopid\": \"183F09S65984M12K0IJBFOR5OI6FCVML\", \"ctimestamp\": \"2012-01-01 01:01:01\" } ], \"shoppinglistgoodstype\": [ { \"ctimestamp\": \"2012-01-01 01:01:01\" } ], \"shoptype\": [ { \"ctimestamp\": \"2012-01-01 01:01:01\" } ] }', '0', '2013-12-09 16:34:50');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'type', 'String', '同步方式(1-根据syninfo获得同步信息，2-根据entityposition获得同步信息)', '', '1', '2013-12-09 16:27:37');
INSERT INTO `open_interface_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'userid', 'String', '用户id(用户编号，唯一，通过UUID产生)', '', '0', '2013-12-09 16:27:37');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', 'entityposition', 'String', '实体店编号(用户当前所在实体店编号)', '', '0', '2013-12-09 15:14:41');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', 'lid', 'String', 'lid', '', '0', '2013-12-09 15:14:41');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', 'mac', 'String', '手机mac地址', '', '0', '2013-12-09 15:14:41');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', 'mver', 'String', '手机程序版本', '', '0', '2013-12-09 15:14:41');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', 'newpassword', 'String', '新密码', '', '1', '2013-12-09 15:14:41');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', 'password', 'String', '原密码', '', '1', '2013-12-09 15:14:41');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', 'sessionid', 'String', 'sessionid值', '', '1', '2013-12-09 15:14:41');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', 'userid', 'String', '用户id', '', '1', '2013-12-09 15:14:41');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'address', 'String', '产地', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'auditNote', 'String', '审核备注', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'crossGoods', 'String', '交叉销售商品，json串', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'crowd', 'String', '人群', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'feature', 'String', '功能', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'goodsBrand', 'String', '品牌编号', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'goodsCategoryLeaf', 'String', '品类编号（叶节点）', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'goodsCategoryRoot', 'String', '品类编号（根节点）', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'goodsContent', 'String', '商品推荐描述', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'goodsfeature', 'String', '商品特征值字符串', 'goodsfeature\n=[{\"goodsName\":\"商品名称\",\"featureCode\":\"特征编码，如color\",\"featureName\":\"特征名称，如颜色\",\"featureValue\":\"特征数值，如蓝色\"},{\"goodsName\":\"商品名称\",\"featureCode\":\"特征编码，如color\",\"featureName\":\"特征名称，如颜色\",\"featureValue\":\"特征数值，如蓝色\"}]', '1', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'goodsImg', 'String', '商品图片URL，json串', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'goodsName', 'String', '商品名称', '', '1', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'goodsSerial', 'String', '商品序列号（商品的唯一识别编码）', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'goodsSolution', 'String', '商品解决方案描述', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'itemSerial', 'String', '自定义序列号（商品细分的唯一识别编码）', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'lifeIdea', 'String', '环保型，健康型，实惠型，品质型', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'positionId', 'String', '位置编号，描述商品在实体店中所处的位置', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'price', 'String', '商品价格', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'relationGoods', 'String', '关联销售商品，json串', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'replaceGoods', 'String', '可替换商品，json串', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'shopEntityId', 'String', '实体店编号', '', '1', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'shopId', 'String', '商家编号', '', '1', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'templateData', 'String', '模板数据，保存的是html代码', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'templateId', 'String', '模板编号', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'useMessage', 'String', '使用方法', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'useType', 'String', '自用型，送礼型', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'vendor', 'String', '供应商', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'address', 'String', '产地', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'auditNote', 'String', '审核备注', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'crossGoods', 'String', '交叉销售商品，json串', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'crowd', 'String', '人群', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'feature', 'String', '功能', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'goodsBrand', 'String', '品牌编号', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'goodsCategoryLeaf', 'String', '品类编号（叶节点）', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'goodsCategoryRoot', 'String', '品类编号（根节点）', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'goodsContent', 'String', '商品推荐描述', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'goodsfeature', 'String', '商品特征值字符串', 'goodsfeature\n=[{\"goodsName\":\"商品名称\",\"featureCode\":\"特征编码，如color\",\"featureName\":\"特征名称，如颜色\",\"featureValue\":\"特征数值，如蓝色\"},{\"goodsName\":\"商品名称\",\"featureCode\":\"特征编码，如color\",\"featureName\":\"特征名称，如颜色\",\"featureValue\":\"特征数值，如蓝色\"}]', '1', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'goodsImg', 'String', '商品图片URL，json串', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'goodsName', 'String', '商品名称', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'goodsSerial', 'String', '商品序列号（商品的唯一识别编码）', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'goodsSolution', 'String', '商品解决方案描述', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'itemSerial', 'String', '自定义序列号（商品细分的唯一识别编码）', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'lifeIdea', 'String', '环保型，健康型，实惠型，品质型', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'positionId', 'String', '位置编号，描述商品在实体店中所处的位置', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'price', 'String', '商品价格', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'relationGoods', 'String', '关联销售商品，json串', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'replaceGoods', 'String', '可替换商品，json串', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'shopEntityId', 'String', '实体店编号', '', '1', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'shopId', 'String', '商家编号', '', '1', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'templateData', 'String', '模板数据，保存的是html代码', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'templateId', 'String', '模板编号', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'useMessage', 'String', '使用方法', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'useType', 'String', '自用型，送礼型', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'vendor', 'String', '供应商', '', '0', '2013-12-12 09:21:44');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0U5M4NI477', 'entityposition', 'String', '实体店编号(用户当前所在实体店编号)', '', '0', '2013-12-09 15:54:28');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0U5M4NI477', 'lid', 'String', 'lid', '', '0', '2013-12-09 15:54:28');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0U5M4NI477', 'mac', 'String', '手机mac地址', '', '0', '2013-12-09 15:54:28');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0U5M4NI477', 'mver', 'String', '手机程序版本', '', '0', '2013-12-09 15:54:28');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0U5M4NI477', 'phone', 'String', '手机号码', '', '1', '2013-12-09 15:54:28');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI48', 'entityposition', 'String', '实体店编号(用户当前所在实体店编号)', '', '0', '2013-12-09 15:57:24');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI48', 'lid', 'String', 'lid', '', '0', '2013-12-09 15:57:24');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI48', 'mac', 'String', '手机mac地址', '', '0', '2013-12-09 15:57:24');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI48', 'mver', 'String', '手机程序版本', '', '0', '2013-12-09 15:57:24');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI48', 'password', 'String', '密码', '', '1', '2013-12-09 15:57:24');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI48', 'phone', 'String', '手机号码', '', '1', '2013-12-09 15:57:24');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI48', 'verifycode', 'String', '验证码', '', '1', '2013-12-09 15:57:24');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', 'appcode', 'String', 'APP识别码', '', '1', '2013-12-09 16:00:52');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', 'mobiletype', 'String', '系统类型(1-Android 2-IOS)', '', '1', '2013-12-09 16:00:52');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', 'versioncode', 'String', '程序版本', '', '1', '2013-12-09 16:00:52');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', 'content', 'String', '反馈内容', '', '1', '2013-12-09 15:47:33');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', 'entityposition', 'String', '实体店编号(用户当前所在实体店编号)', '', '0', '2013-12-09 15:47:33');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', 'lid', 'String', 'lid', '', '0', '2013-12-09 15:47:33');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', 'mac', 'String', '手机mac地址', '', '0', '2013-12-09 15:47:33');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', 'mtype', 'String', '当前手机型号', '', '0', '2013-12-09 15:47:33');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', 'mver', 'String', '手机程序版本', '', '0', '2013-12-09 15:47:33');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', 'sessionid', 'String', 'sessionid值(手机登录后的sessionid值)', '', '1', '2013-12-09 15:47:33');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', 'userid', 'String', '用户id(用户编号，唯一，通过UUID产生)', '', '1', '2013-12-09 15:47:33');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI46', 'mac', 'String', '手机mac地址', '', '1', '2013-12-09 15:51:49');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI46', 'mid', 'String', 'mid', '', '0', '2013-12-09 15:51:49');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI46', 'mtype', 'String', '系统类型', '', '0', '2013-12-09 15:51:49');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI46', 'mver', 'String', '手机程序版本', '', '0', '2013-12-09 15:51:49');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'entityposition', 'String', '实体店编号(用户当前所在实体店编号)', '', '0', '2013-12-09 15:44:28');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'lid', 'String', 'lid', '', '0', '2013-12-09 15:44:28');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'mac', 'String', '手机mac地址', '', '0', '2013-12-09 15:44:28');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'mver', 'String', '手机程序版本', '', '0', '2013-12-09 15:44:28');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'sessionid', 'String', 'sessionid值(手机登录后的sessionid值)', '', '1', '2013-12-09 15:44:28');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'userid', 'String', '用户id(用户编号，唯一，通过UUID产生)', '', '1', '2013-12-09 15:44:28');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'address', 'String', '地址', '', '0', '2013-12-09 15:41:11');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'birthday', 'String', '生日', '', '0', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'entityposition', 'String', '实体店编号(用户当前所在实体店编号)', '', '0', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'idno', 'String', '证件号码', '', '0', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'idtype', 'String', '证件类型(00-身份证、01-护照、02-军官证、03-其他)', '', '0', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'isallowfriend', 'String', '是否允许别人加自己为好友(Y-允许，N-不允许)', '', '0', '2013-12-09 15:41:11');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'lid', 'String', 'lid', '', '0', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'mac', 'String', '手机mac地址', '', '0', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'mver', 'String', '手机程序版本', '', '0', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'nickname', 'String', '姓名', '', '0', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'phone', 'String', '手机号', '', '0', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'postcode', 'String', '邮编', '', '0', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'sessionid', 'String', 'sessionid值(手机登录后的sessionid值)', '', '1', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'sex', 'String', '性别(性别：M-男，F-女，P-其他)', '', '0', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'userid', 'String', '用户id(用户编号，唯一，通过UUID产生)', '', '1', '2013-12-09 15:41:10');
INSERT INTO `open_interface_parms` VALUES ('18BIT48FKML20C2G8PEQD0DUQG20OTR9', 'goodsId', 'String', '商品编号', null, '1', '2013-12-12 16:09:20');
INSERT INTO `open_interface_parms` VALUES ('18BIT48FKMRRRM2G8PEQD0DUQH20OTRA', 'goodsId', 'String', '商品编号', '', '1', '2013-12-12 16:39:26');
INSERT INTO `open_interface_parms` VALUES ('18BIT48FKMRRRM2G8PEQD0DUQH20OTRA', 'note', 'String', '审核备注', '', '1', '2013-12-12 16:39:26');
INSERT INTO `open_interface_parms` VALUES ('18BIT48FKMRRRM2G8PEQD0DUQH20OTRA', 'status', 'String', '审核状态(Y-通过，N-不通过)', '', '1', '2013-12-12 16:39:26');
INSERT INTO `open_interface_parms` VALUES ('18BIT48FKMT2DU2G8PEQD0DUQI20OTRB', 'goodsId', 'String', '商品编号', '', '1', '2013-12-12 16:39:26');
INSERT INTO `open_interface_parms` VALUES ('18BIT48FKMU3KP2G8PEQD0DUQJ20OTRC', 'goodsId', 'String', '商品编号', '', '1', '2013-12-12 16:39:26');
INSERT INTO `open_interface_parms` VALUES ('18BIT48FKMVB9B2G8PEQD0DUQK20OTRD', 'shopEntityId', 'String', '实体店编号', '', '1', '2013-12-12 16:39:26');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'ctimestamp', 'String', '最大时间戳', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'entityposition', 'String', '实体店编号', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'pagesize', 'String', '每页显示信息条数', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'sessionid', 'String', 'sessionid值', null, '1', '2013-12-09 15:09:53');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'userid', 'String', '用户编号', null, '1', '2013-12-09 11:31:37');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EEC93', 'entityposition', 'String', '实体店编号', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EEC93', 'lid', 'String', 'lid', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EEC93', 'mac', 'String', '手机mac地址', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EEC93', 'mver', 'String', '手机程序版本', '', '0', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EEC93', 'scardno', 'String', '会员卡音频卡号', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EEC93', 'sessionid', 'String', 'sessionid值', '', '1', '2013-12-04 17:45:06');
INSERT INTO `open_interface_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EEC93', 'userid', 'String', '用户id', '', '0', '2013-12-04 17:45:06');

-- ----------------------------
-- Table structure for `open_interface_return_parms`
-- ----------------------------
DROP TABLE IF EXISTS `open_interface_return_parms`;
CREATE TABLE `open_interface_return_parms` (
  `interface_id` char(32) NOT NULL COMMENT '接口ID',
  `parameter_name` varchar(30) NOT NULL COMMENT '参数名',
  `parent_parameter_name` varchar(30) DEFAULT NULL COMMENT '父参数名，没有父填-1',
  `parameter_type` char(30) DEFAULT NULL COMMENT '参数类型',
  `parameter_des` varchar(200) DEFAULT NULL COMMENT '参数描述',
  `example` varchar(300) DEFAULT NULL COMMENT '示例值',
  `update_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`interface_id`,`parameter_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口返回对象属性表';

-- ----------------------------
-- Records of open_interface_return_parms
-- ----------------------------
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIA5I8TH7', 'result ', null, 'boolean', '成功返回true，失败返回fales', '', '2013-12-10 13:37:50');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T10', 'result', null, 'boolean', '成功返回true,失败返回false', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', 'result', null, 'boolean', '成功返回true,失败返回false', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'attentionnums	', null, 'String', '关注数量', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'colortype', null, 'String', '背景颜色（RGB）', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'logo', null, 'String', '商家logo', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'membernums', null, 'String', '会员数量', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'shopid', null, 'String', '商家编号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', 'shopname', null, 'String', '商家名称', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH2', 'userIntegral', null, 'String', '用户积分，默认为0', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'ctimestamp', null, 'String', '最后一次修改时间', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'isdel', null, 'String', '是否删除，Y-已删除，N-未删除', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'oblonglogo', null, 'String', '商家长方形logo', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'shopfirstchar	', null, 'String', '商家名首字母', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'shopid', null, 'String', '商家id', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'shopname', null, 'String', '商家名称', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'shoptypeleaf', null, 'String', '商家类别', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', 'squarelogo', null, 'String', '商家正方形logo', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'cardbodyurl', null, 'String', '卡身图片', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'cardheadurl', null, 'String', '卡头图片', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'cardname', null, 'String', '卡名', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'createtime', null, 'String', '创建时间 ', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'description	', null, 'String', '会员权限说明', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'needjifen', null, 'String', '升级所需积分', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', 'uselimited', null, 'String', '使用期限', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', 'result', null, 'boolean', '成功返回true,失败返回false', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'ctimestamp', null, 'String', '记录平台返回通知信息中 最大的时间戳', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'flag', null, 'String', '返回通知的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'img', null, 'String', '小图片', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'isdel', null, 'String', '是否删除', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'isread', null, 'String', '是否已读', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'logo', null, 'String', '店铺logo', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'noticeidstr', null, 'String', '字符串，已删除通知的编号，多个用逗号分隔开', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'noticeinfoid', null, 'String', '通知编号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'noticetextmobile', null, 'String', '通知详情', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'noticeuserid', null, 'String', '通知和用户关联表的UUID', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'pageid', null, 'String', '分页编号:通知推送时间（YYYY-MM-DD HH:MM:SS） +通知编号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'shopid', null, 'String', '店铺id', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', 'title', null, 'String', '通知名称', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'cardid	', null, 'String', '会员卡编号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'createtime', null, 'String', '创建时间', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'ctimestamp', null, 'String', '最后一次修改时间 ', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'expiredate', null, 'String', '过期时间', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'isdel', null, 'String', '是否删除，Y-已删除，N-未删除', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'needshare', null, 'String', '是否允许分享,Y-允许分享，N-不允许分享', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'phycardno', null, 'String', '物理卡号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'scardno', null, 'boolean', '会员卡音频编号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'scardnotdcurl', null, 'String', '会员卡音频编号二维码地址', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'scardnourl', null, 'String', '会员卡音频编号音频地址', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'sharedemail', null, 'String', '分享者用户名', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'sharednickname', null, 'String', '分享者昵称', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'shareexpiredate', null, 'String', '分享结束时间', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'sharetimes', null, 'String', '分享次数', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'shareuserid', null, 'String', '分享者id', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'shopid', null, 'String', '商家编号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'useableintegralnumber', null, 'String', '用户在此商家积分', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', 'userid', null, 'String', '用户编号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'address', null, 'String', '通讯地址', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'birthday', null, 'String', '出生日期 ', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'email', null, 'String', '电子邮箱', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'enumvalue', null, 'String', '枚举值，保存的是json串，例如[\"黄色\",\"蓝色\",\"白色\"]', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'featurevalue', null, 'String', '特征数值（用户当前的数值），如蓝色', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'idno	', null, 'String', '证件号码', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'idtype', null, 'String', '证件类型，00-身份证，01-护照，02-军官证，03-其他', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'mobile', null, 'String', '手机号码', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'name', null, 'boolean', '姓名', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'postcode', null, 'String', '邮政编码', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'sex', null, 'String', '性别，M-男，F-女', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'telephone', null, 'String', '联系电话', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'typecode', null, 'String', '类型编号，例如color，同一商家唯一，由商家录入', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', 'typename', null, 'String', '类型名称，例如颜色，同一商家唯一，由商家录入', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', 'result', null, 'boolean', '成功返回true,失败返回false', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'goodsArray', null, 'Goods[]', ' 购物计划商品分类 ', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'imobilelistgArray', null, 'Imobilelistg[]', '接口地址列表  ', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'membercardArray', null, 'Membercard[]', '会员卡基本信息', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'shopentityinfoArray', null, 'Shopentityinfo[]', ' 实体店基本信息', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'shopentitylinkArray', null, 'Shopentitylink[]', '实体店联系方式 ', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'shopgpsinfoArray', null, 'Shopgpsinfo[]', '实体店gps信息  ', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'shopinfoArray', null, 'Shopinfo[]', '商家信息 ', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'shopinfosynctimestampArray', null, 'Shopinfosynctimestamp[]', '商家基本信息同步时间戳信息', '', '2013-12-10 11:12:49');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'shopinvoiceinfoArray', null, 'Shopinvoiceinfo[]', '实体店开发票项目', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'shoplidinfoArray', null, 'Shoplidinfo[]', '实体店主lid ', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'shopsvginfoArray', null, 'Shopsvginfo[]', '实体店svg图信息', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'shoptoolArray', null, 'Shoptoollist[]', '服务工具信息 ', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'shoptypeArray', null, 'Shoptype[]', ' 商家类型字典', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'shopwifiinfoArray', null, 'Shopwifiinfo[]', ' 实体店wifi信息 ', '', '2013-12-10 10:57:36');
INSERT INTO `open_interface_return_parms` VALUES ('18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', 'synctimestampArray', null, 'Synctimestamp', '同步时间戳信息', '', '2013-12-10 11:12:49');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', 'result ', null, 'boolean', '成功返回true，失败返回fales', '', '2013-12-10 13:37:50');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', 'result ', null, 'boolean', '成功返回true，失败返回fales', '', '2013-12-10 13:37:50');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', 'result ', null, 'boolean', '成功返回true，失败返回fales', '', '2013-12-10 13:37:50');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0U5M4NI477', 'result ', null, 'boolean', '成功返回true，失败返回fales', '', '2013-12-10 13:37:50');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI48', 'result ', null, 'boolean', '成功返回true，失败返回fales', '', '2013-12-10 13:37:50');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', 'appcode', null, 'String', 'APP识别码', '', '2013-12-09 18:40:03');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', 'createtime', null, 'Date', '创建时间', '', '2013-12-09 18:40:03');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', 'downloadurl', null, 'String', 'Apk下载地址', '', '2013-12-09 18:40:03');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', 'mobiletype', null, 'String', '移动设备类型,1-Android ,2-IOS', '', '2013-12-09 18:40:03');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', 'note', null, 'String', '备注', '', '2013-12-09 18:40:03');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', 'platform', null, 'String', '所属平台', '', '2013-12-09 18:40:03');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', 'versioncode', null, 'String', '版本号', '', '2013-12-09 18:40:03');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', 'versionname', null, 'String', '版本名称', '', '2013-12-09 18:40:03');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', 'result ', null, 'boolean', '成功返回true，失败返回fales', '', '2013-12-10 13:37:50');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UU5M4NI46', 'gooagooid', null, 'String', 'gooagooid', '', '2013-12-09 18:32:27');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'address', null, 'String', '地址  ', '', '2013-12-09 17:46:41');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'birthday', null, 'String', '生日', '', '2013-12-09 17:46:41');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'idno', null, 'String', '证件号码', '', '2013-12-09 17:46:41');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'idtype', null, 'String', '证件类型', '', '2013-12-09 17:46:41');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'isallowfriend', null, 'String', '是否允许别人加自己为好友，Y-否允，N-不否允', '', '2013-12-09 17:46:41');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'nickname', null, 'String', '昵称', '', '2013-12-09 17:40:13');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'phone', null, 'String', '手机号', '', '2013-12-09 17:46:41');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'postcode', null, 'String', '邮编  ', '', '2013-12-09 17:46:41');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'realname', null, 'String', '姓名', '', '2013-12-09 17:46:41');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ6U92GQWQD0UULM4NI44', 'sex', null, 'String', '性别', '', '2013-12-09 17:46:41');
INSERT INTO `open_interface_return_parms` VALUES ('18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', 'result ', null, 'boolean', '成功返回true，失败返回fales', '', '2013-12-10 13:37:50');
INSERT INTO `open_interface_return_parms` VALUES ('18BIT48FKML20C2G8PEQD0DUQG20OTR9', 'result ', null, 'boolean', '成功返回true,失败返回false', null, '2013-12-12 16:10:16');
INSERT INTO `open_interface_return_parms` VALUES ('18BIT48FKMRRRM2G8PEQD0DUQH20OTRA', 'result ', null, 'boolean', '成功返回true,失败返回false', '', '2013-12-12 16:42:42');
INSERT INTO `open_interface_return_parms` VALUES ('18BIT48FKMT2DU2G8PEQD0DUQI20OTRB', 'result ', null, 'boolean', '成功返回true,失败返回false', '', '2013-12-12 16:42:42');
INSERT INTO `open_interface_return_parms` VALUES ('18BIT48FKMU3KP2G8PEQD0DUQJ20OTRC', 'result ', null, 'boolean', '成功返回true,失败返回false', '', '2013-12-12 16:42:42');
INSERT INTO `open_interface_return_parms` VALUES ('18BIT48FKMVB9B2G8PEQD0DUQK20OTRD', 'result ', null, 'boolean', '成功返回true,失败返回false', '', '2013-12-12 16:42:42');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'cardid', null, 'String', '会员卡编号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'count', null, 'String', '用户会员卡总数（用户所拥有的所有商家的会员卡总和）', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'createtime', null, 'String', '创建时间', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'ctimestamp', null, 'String', '最后一次修改时间', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'expiredate', null, 'String', '过期时间', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'needshare', null, 'String', '是否允许分享,Y-允许分享，N-不允许分享', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'noreadnoticenums', null, 'String', '未读通知条数', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'phycardno', null, 'String', '物理卡号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'scardno', null, 'String', '会员卡音频编号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'scardnostr', null, 'String', '已删除的会员卡字符串，多条用“逗号”分隔', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'scardnotdcurl', null, 'String', '会员卡音频编号二维码地址', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'scardnourl', null, 'String', '会员卡音频编号音频地址', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'sharedemail', null, 'String', '分享者用户名', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'sharednickname', null, 'String', '分享者昵称', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'shareexpiredate', null, 'String', '分享结束时间', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'sharetimes', null, 'String', '分享次数', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'shareuserid', null, 'String', '分享者id', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'shopid', null, 'String', '商家编号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'useableintegralnumber', null, 'String', '用户在此商家积分', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EE896', 'userid', null, 'String', '用户编号', '', '2013-12-09 13:29:13');
INSERT INTO `open_interface_return_parms` VALUES ('DF79AB1EA08F4B4887727D05CC8EEC93', 'result', null, 'boolean', '成功返回true,失败返回false', '', '2013-12-09 13:29:13');

-- ----------------------------
-- Table structure for `open_interface_right`
-- ----------------------------
DROP TABLE IF EXISTS `open_interface_right`;
CREATE TABLE `open_interface_right` (
  `object_id` varchar(32) NOT NULL COMMENT '分别表示应用、角色或者Token拥有该接口的访问权限',
  `interface_id` char(32) NOT NULL COMMENT '接口ID',
  `volume` int(11) DEFAULT '0' COMMENT '接口最大日访问量,0不限制',
  `right_type` char(1) DEFAULT NULL COMMENT '权限类型：1应用2角色3Token',
  `expire_time` datetime DEFAULT NULL COMMENT 'Token访问类型过期时间，如果为空永不过期',
  `update_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`interface_id`,`object_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口权限表';

-- ----------------------------
-- Records of open_interface_right
-- ----------------------------
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCsqwwwwwfEEEQD0DUdddddd', '0', '2', null, '2013-12-19 12:36:04');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCssssasdfEEEQD0DUdddddd', '0', '2', null, '2013-12-19 12:35:43');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCssssTqwqEEEQD0DUdddddd', '0', '2', null, '2013-12-19 12:35:29');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCssssTTEEEEQD0DUdddddd', '0', '2', null, '2013-12-19 12:35:13');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUdddddddd', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUddssdswe', '0', '2', null, '2013-12-19 12:33:20');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIA5I8TH6', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIA5I8TH6', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIA5I8TH7', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIA5I8TH7', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T10', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T10', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T11', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T11', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T12', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T12', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T13', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T13', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T14', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T14', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T15', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T15', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T16', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T16', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T17', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T17', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T18', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T18', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T19', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T19', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T20', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T20', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T21', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T21', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T22', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T22', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T23', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T23', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T24', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T24', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T25', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T25', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T26', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T26', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T27', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T27', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T28', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T28', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T29', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T29', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T30', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T30', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T31', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T31', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T32', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T32', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T33', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T33', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T34', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T34', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T35', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T35', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T36', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T36', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T37', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T37', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T38', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T38', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T43', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T43', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T44', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T44', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T45', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T45', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T46', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T46', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T54', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T54', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T55', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T55', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T56', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T56', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T57', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T57', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T58', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T58', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T59', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T59', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T60', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T60', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T61', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T61', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8T66', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH1', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH2', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH2', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH3', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH4', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH5', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH6', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH7', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH8', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAaI8TH9', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAeeeeee', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAffffff', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUIAgggggg', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUItertrr', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUItesdsd', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8PEQD0DUItyyyyyy', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB72G8QWED0DUIA5I8TH6', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0CF6NCV4GB7TTEEEEQD0DUdddddd', '0', '2', null, '2013-12-19 12:34:19');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0OPI861PEA62G8PEQD0DUL95LKNHS', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0OPI861PEA62G8PEQD0DUL95LKNHS', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0OPI861VFGR2G8PEQD0DULA5LKNHT', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0OPI861VFGR2G8PEQD0DULA5LKNHT', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0OPI8620GNM2G8PEQD0DULB5LKNHU', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0OPI8620GNM2G8PEQD0DULB5LKNHU', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0OPI86236PT2G8PEQD0DULC5LKNHV', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0OPI86236PT2G8PEQD0DULC5LKNHV', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0OPI87249PS2G8PEQD0DULD5LKNI0', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0OPI87249PS2G8PEQD0DULD5LKNI0', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92G6PEQD0UULE5M4NI1', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92G6PEQD0UULE5M4NI1', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI2', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI2', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI3', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI3', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI4', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI4', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI5', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI5', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI6', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI6', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI7', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI7', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI8', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI8', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI9', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92G8PEQD0UULE5M4NI9', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI1', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI1', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI2', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI2', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI3', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI3', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI4', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI4', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI5', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI5', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI6', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI6', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI7', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI7', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI8', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4NI8', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQ7EQD0UULE5M4W43', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQ7EQD0UULE5YYYYY', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQ7EQD0UUWEWEWW', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQWQD0U5M4NI477', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQWQD0U5M4NI477', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQWQD0UE5M4NI48', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQWQD0UE5M4NI48', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQWQD0UE5M4NI49', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQWQD0UU5M4NI45', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQWQD0UU5M4NI46', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQWQD0UU5M4NI46', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ6U92GQWQD0UULM4NI44', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ6U92GQWQD0UULM4NI44', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7AMQ92GQWQD0OOLW5M4NI43', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI10', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI10', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI11', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI11', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI12', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI12', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI13', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI13', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI14', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI14', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI15', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI15', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI16', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI16', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI17', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI17', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI18', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI18', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI19', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI19', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI20', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI20', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI21', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI21', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI22', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18B0VUJ7MQ6U92GQ7EQD0UULE5M4NI22', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18BIT48FKML20C2G8PEQD0DUQG20OTR9', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18BIT48FKMRRRM2G8PEQD0DUQH20OTRA', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18BIT48FKMT2DU2G8PEQD0DUQI20OTRB', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18BIT48FKMU3KP2G8PEQD0DUQJ20OTRC', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18BIT48FKMVB9B2G8PEQD0DUQK20OTRD', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18BJ0E8GOA09SC2G8PEQD0DU797I03LS', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18DF038LTQRGA90SHURCPR2CHK44GCUH', '0', '2', null, '2014-01-04 23:55:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '18DIPGVSAU3MPT0SHURCPR2CTV1NCT5Q', '0', '2', null, '2014-01-04 23:55:19');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', 'DF79AB1EA08F4B4887727D05CC8EE896', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', 'DF79AB1EA08F4B4887727D05CC8EE896', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', 'DF79AB1EA08F4B4887727D05CC8EEC93', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', 'DF79AB1EA08F4B4887727D05CC8EEC93', '0', '2', null, '2013-12-18 10:51:03');
INSERT INTO `open_interface_right` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', 'F58A76CB1F2C4FA8A6342933C9477614', '0', '2', null, '2013-12-11 16:33:19');
INSERT INTO `open_interface_right` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', 'F58A76CB1F2C4FA8A6342933C9477614', '0', '2', null, '2013-12-18 10:51:03');

-- ----------------------------
-- Table structure for `open_interface_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `open_interface_role_rel`;
CREATE TABLE `open_interface_role_rel` (
  `app_key` int(11) NOT NULL COMMENT '应用ID',
  `role_id` char(32) NOT NULL COMMENT '角色ID',
  `update_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`app_key`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用角色关系表';

-- ----------------------------
-- Records of open_interface_role_rel
-- ----------------------------
INSERT INTO `open_interface_role_rel` VALUES ('10009', '18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '2013-12-11 16:25:09');
INSERT INTO `open_interface_role_rel` VALUES ('10022', 'default_role_id', '2013-12-12 13:27:22');
INSERT INTO `open_interface_role_rel` VALUES ('10023', 'default_role_id', '2013-12-12 13:28:49');
INSERT INTO `open_interface_role_rel` VALUES ('10024', '18C1PB5DC3ADCO004D6ON0616762KA51', '2013-12-18 17:47:55');
INSERT INTO `open_interface_role_rel` VALUES ('10025', 'default_role_id', '2014-01-09 18:08:13');
INSERT INTO `open_interface_role_rel` VALUES ('10026', 'default_role_id', '2014-01-14 14:23:46');
INSERT INTO `open_interface_role_rel` VALUES ('10027', 'default_role_id', '2014-01-14 14:58:20');
INSERT INTO `open_interface_role_rel` VALUES ('10028', 'default_role_id', '2014-01-14 15:00:45');
INSERT INTO `open_interface_role_rel` VALUES ('10029', 'default_role_id', '2014-01-14 15:06:40');
INSERT INTO `open_interface_role_rel` VALUES ('10030', 'default_role_id', '2014-01-14 15:16:52');
INSERT INTO `open_interface_role_rel` VALUES ('10031', 'default_role_id', '2014-01-14 15:20:10');
INSERT INTO `open_interface_role_rel` VALUES ('10032', 'default_role_id', '2014-01-14 15:35:30');
INSERT INTO `open_interface_role_rel` VALUES ('10033', 'default_role_id', '2014-01-14 17:02:49');
INSERT INTO `open_interface_role_rel` VALUES ('10034', 'default_role_id', '2014-01-14 17:02:49');
INSERT INTO `open_interface_role_rel` VALUES ('10035', 'default_role_id', '2014-01-14 17:02:56');
INSERT INTO `open_interface_role_rel` VALUES ('10036', 'default_role_id', '2014-01-14 17:04:21');
INSERT INTO `open_interface_role_rel` VALUES ('10037', 'default_role_id', '2014-01-14 17:08:10');
INSERT INTO `open_interface_role_rel` VALUES ('10038', 'default_role_id', '2014-01-14 17:16:06');
INSERT INTO `open_interface_role_rel` VALUES ('10039', 'default_role_id', '2014-01-14 17:17:56');

-- ----------------------------
-- Table structure for `open_role`
-- ----------------------------
DROP TABLE IF EXISTS `open_role`;
CREATE TABLE `open_role` (
  `role_id` char(32) NOT NULL COMMENT '角色ID',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `role_des` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `update_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of open_role
-- ----------------------------
INSERT INTO `open_role` VALUES ('18BGC7A6L1SI7G0SHURCPR2CHI5G8CUF', '系统默认权限角色', '创建APP时分配给APP的角色', '2013-12-11 16:24:24');
INSERT INTO `open_role` VALUES ('18C1PB5DC3ADCO004D6ON0616762KA51', '新华书店', '新华书店接口权限专用角色', '2013-12-18 10:37:34');
INSERT INTO `open_role` VALUES ('default_role_id', '系统初始化角色', '系统初始化默认角色，用于给应用分配默认权限', '2013-12-12 13:27:22');

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
INSERT INTO `open_user_token_rel` VALUES ('18E7E3GO9CP34K1GGMKKF84KMF2DGPLQ', null, '11', '2014-01-16 11:53:16', '2014-01-14 11:53:12');
INSERT INTO `open_user_token_rel` VALUES ('18E7EG5CCDCRD71GGMKKF84K4H4ECAJG', null, '11', '2014-01-16 12:00:11', '2014-01-14 12:00:06');
INSERT INTO `open_user_token_rel` VALUES ('18E80CJGV8FATQ1GGMKKF84K7B4HCBDG', null, '11', '2014-01-16 17:12:48', '2014-01-14 17:12:43');
INSERT INTO `open_user_token_rel` VALUES ('18E80KFARMQNFR1GGMKKF84K562T884C', null, '11', '2014-01-16 17:17:06', '2014-01-14 17:17:00');
