drop table if exists behave_log;

drop table if exists shop_log;

drop table if exists sys_log;

/*==============================================================*/
/* Table: behave_log                                            */
/*==============================================================*/
create table behave_log
(
   behave_id            char(1) not null comment '行为编号，UUID',
   user_id              char(1) comment '用户编号',
   account              char(1) comment '用户名',
   gooagooID            char(1) comment 'gooagooID，平台分配给手机设备的唯一编号',
   ip_address           char(1) comment 'IP地址',
   mac_address          char(1) comment 'MAC地址',
   host_name            char(1) comment '主机名',
   mobile               char(1) comment '手机号',
   ec_account           char(1) comment '电子商务帐号',
   scardno              char(1) comment '会员卡音频编号（电子卡号）',
   phy_card_no          char(1) comment '物理卡号',
   card_id              char(1) comment '会员等级（会员卡编号）',
   phone_type           char(1) comment '手机型号',
   system_type          char(1) comment '操作系统类型',
   browser_type         char(1) comment '浏览器类型',
   language             char(1) comment '浏览器语言设置',
   screen_resolution    char(1) comment '屏幕分辨率',
   screen_color         char(1) comment '屏幕颜色',
   behave_time          datetime not null comment '行为发生时间',
   source               char(1) not null comment '用户行为来源，参考通用字典表的behave_source',
   operate_result       char(1) not null comment '操作结果，Y-成功，N-失败',
   behave_type          char(1) not null comment '行为类型：用户做了一个什么操作，比如浏览商品、收藏活动、关注商家等',
   position_id          char(1) comment '行为发生地区的区域编号',
   remote_code          char(1) comment '所调用的接口编码',
   object_value         char(1) comment '行为对象编号：用户所做操作的对象，比如商品、活动、商家',
   object_type          char(1) comment '行为对象类型，A-活动，G-商品，C-优惠凭证，其余为空',
   object_name          char(1) comment '行为对象名称',
   shop_id              char(1) comment '行为对象所属商家编号',
   shop_entity_id       char(1) comment '行为对象所属实体店编号',
   object_source        char(1) comment '行为对象来源，记录优惠凭证是从哪个吆喝、通知中浏览和收藏的。',
   category_id          char(1) comment '品类，商品或账单所包含的品类',
   brand_id             char(1) comment '品牌，商品或账单所包含的品牌',
   detail               char(1) comment '详细信息',
   create_time          datetime not null comment '创建时间',
   primary key (behave_id)
);

alter table behave_log comment '用户行为日志，记录一般性的行为';

/*==============================================================*/
/* Table: shop_log                                              */
/*==============================================================*/
create table shop_log
(
   log_id               char(1) not null comment '日志编号，UUID',
   shop_id              char(1) not null comment '商家编号',
   account_id           char(1) comment '子帐号编号，如果来源是管理系统或者店员助理，则为具体的子帐号，如果来源是转发器，则为转发器的mac地址',
   operate_source       char(1) not null comment '操作来源，S-管理系统，T-转发器，A-店员助理',
   remote_code          char(1) comment '所调用的接口编码',
   shop_behave_type     char(1) not null comment '操作类型，对应字典表的shop_behave_type',
   detail               char(1) comment '详细信息（保存在mongodb中）',
   object_code          char(1) comment '操作对象编号',
   operate_result       char(1) not null comment '操作结果，Y-成功，N-失败',
   operate_ip           char(1) not null comment '操作IP（S-管理系统）或mac地址（T-转发器，A-店员助理）',
   create_time          datetime not null comment '创建时间',
   primary key (log_id)
);

alter table shop_log comment '商家日志表，记录商家的行为日志';

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
   sys_log_id           char(1) not null comment '日志编号，唯一，通过UUID产生',
   user_id              char(1) not null comment '管理员帐号',
   remote_code          char(1) comment '所调用的接口编码',
   sys_behave_type      char(1) not null comment '操作类型，对应字典表的sys_behave_type',
   detail               char(1) comment '详细信息（保存在mongodb中）',
   object_code          char(1) comment '操作对象编号',
   operate_result       char(1) not null comment '操作结果，Y-成功，N-失败',
   operate_ip           char(1) not null comment '操作IP',
   create_time          datetime not null comment '创建时间',
   primary key (sys_log_id)
);

alter table sys_log comment '系统管理日志表，记录gooagoo平台的系统管理员的操作行为日志';
