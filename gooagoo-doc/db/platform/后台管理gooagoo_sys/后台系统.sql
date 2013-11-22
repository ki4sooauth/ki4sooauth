drop table if exists ads_manage;

drop table if exists cms_content;

drop table if exists interface_base_info;

drop table if exists interface_request_info;

drop table if exists mobile_version;

drop table if exists nominate_activity;

drop table if exists nominate_coupon;

drop table if exists nominate_goods;

drop table if exists nominate_shop;

drop table if exists platform_region;

drop table if exists shop_ad;

drop table if exists shop_bid;

drop table if exists shop_interface_info;

drop table if exists sys_authority;

drop table if exists sys_role;

drop table if exists sys_role_authority;

drop table if exists sys_user_info;

drop table if exists sys_user_role;

drop table if exists template_info;

drop table if exists trade_area;

/*==============================================================*/
/* Table: ads_manage                                            */
/*==============================================================*/
create table ads_manage
(
   bid_id               char(32) not null comment '竞拍编号，UUID',
   ad_code              char(32) not null comment '广告位编码',
   starting_price       double(10,2) not null comment '起拍价',
   increase             double(10,2) not null comment '涨幅',
   state                char(1) not null comment '0-空闲，1-发布，2-已拍，3-已提交资料，4-已审核，5-已收款，6-已卖出',
   winner_shoo_id       char(32) comment '得标商家编号',
   winner_shoo_name     char(50) comment '得标商家名称',
   bid_amount           double(10,2) comment '得标金额',
   id                   char(32) comment '商家竞价自动编号',
   bid_start_time       datetime not null comment '竞价起始时间',
   bid_end_time         datetime not null comment '竞价结束时间',
   effect_start_date    date not null comment '生效起始日期',
   effect_end_date      date not null comment '生效结束日期',
   effect_start_time    time not null comment '生效起始时间',
   effect_end_time      time not null comment '生效结束时间',
   img_url              char(255) comment '图片地址',
   link_url             char(255) comment '链接地址',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (bid_id)
);

alter table ads_manage comment '广告位管理';

/*==============================================================*/
/* Table: cms_content                                           */
/*==============================================================*/
create table cms_content
(
   cms_content_id       char(32) not null comment 'cms内容编号，UUID',
   cms_content_type     char(1) not null comment 'cms内容类型（A-文章，C-栏目）',
   parent_cms_content_id char(32) not null comment '父级cms内容编号',
   channel_type         char(1) not null comment '栏目分类，参考info_source，M-手机，W-网站',
   shop_id              char(32) not null comment '商家编号',
   cms_content_name     char(50) not null comment 'cms内容名称',
   cms_content_img      char(255) comment 'cms内容图标',
   cms_content_des      char(250) comment 'cms内容介绍',
   cms_content_url      varchar(255) comment '访问路径',
   template_id          char(32) comment '模板编号',
   template_data        longtext comment '模板数据，保存的是html代码',
   is_top               char(1) not null comment '是否置顶，Y-置顶，N-不置顶',
   order_no             int not null comment '排序编号',
   publish_status       char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   publish_time         datetime comment '发布时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (cms_content_id)
);

alter table cms_content comment 'cms内容信息';

/*==============================================================*/
/* Table: interface_base_info                                   */
/*==============================================================*/
create table interface_base_info
(
   i_code               char(6) not null comment '接口编码，由3位系统编码、1位功能编码、2位自增长数字组成',
   i_name               char(32) not null comment '接口名称',
   i_type               char(32) not null comment '接口类型，中文描述，如手机接口系统',
   i_function           char(32) not null comment '功能分类，指接口系统中的大分类，如手机接口系统分为5大功能：卡包、收藏、吆喝、购物计划、消费账单',
   i_url                char(255) not null comment '接口地址',
   behave_type          char(2) comment '行为类型，如对应不上，则为空，参考通用字典表的behave_type',
   can_allocate         char(1) not null comment '是否可分配，Y-是，N-否，只有在商家独立部署的时候才能分配',
   data_xml             char(255) not null comment '报文示例（XMl）URL',
   data_json            char(255) not null comment '报文示例（JSON）URL',
   note                 char(255) not null comment '业务逻辑说明URL',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (i_code)
);

alter table interface_base_info comment '接口基础信息表';

/*==============================================================*/
/* Table: interface_request_info                                */
/*==============================================================*/
create table interface_request_info
(
   id                   int not null auto_increment comment '自动编号',
   i_code               char(6) not null comment '接口编码，由3位系统编码、1位功能编码、2位自增长数字组成',
   name_en              char(32) comment '参数英文名称',
   name_cn              char(32) comment '参数中文名称',
   is_required          char(1) comment '是否必填，Y-必填，N-非必填',
   note                 char(255) comment '备注，比如约束条件、枚举值',
   primary key (id)
);

alter table interface_request_info comment '接口请求参数信息表';

/*==============================================================*/
/* Table: mobile_version                                        */
/*==============================================================*/
create table mobile_version
(
   id                   char(32) not null comment '自动编号，UUID',
   app_code             varchar(255) not null comment 'APP识别码',
   mobile_type          varchar(1) not null comment '移动设备类型，参考mobile_type',
   version              varchar(255) not null comment '版本号',
   version_name         varchar(255) comment '版本名称',
   link                 varchar(255) not null comment '链接地址，应该是后台上传的apk包的访问地址',
   platform             varchar(255) not null comment '所属平台',
   note                 varchar(255) comment '备注',
   is_del               varchar(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   primary key (id)
);

alter table mobile_version comment '移动设备版本管理表';

/*==============================================================*/
/* Table: nominate_activity                                     */
/*==============================================================*/
create table nominate_activity
(
   id                   char(32) not null comment '自动编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   activity_id          char(32) not null comment '活动编号，UUID',
   start_time           datetime not null comment '起始时间',
   end_time             datetime not null comment '结束时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table nominate_activity comment '推荐活动。gooagoo平台向客户推荐活动，在我的收藏中展示推荐的活动信息。';

/*==============================================================*/
/* Table: nominate_coupon                                       */
/*==============================================================*/
create table nominate_coupon
(
   id                   char(32) not null comment '自动编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   coupon_id            char(32) not null comment '优惠凭证编号，UUID',
   start_time           datetime not null comment '起始时间',
   end_time             datetime not null comment '结束时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table nominate_coupon comment '推荐优惠凭证。gooagoo平台向客户推荐优惠凭证，在我的收藏中展示推荐的优惠凭证信息。';

/*==============================================================*/
/* Table: nominate_goods                                        */
/*==============================================================*/
create table nominate_goods
(
   id                   char(32) not null comment '自动编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   goods_id             char(32) not null comment '商品编号，UUID',
   start_time           datetime not null comment '起始时间',
   end_time             datetime not null comment '结束时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table nominate_goods comment '推荐商品。gooagoo平台向客户推荐商品，在我的收藏中展示推荐的商品信息。';

/*==============================================================*/
/* Table: nominate_shop                                         */
/*==============================================================*/
create table nominate_shop
(
   id                   char(32) not null comment '自动编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   color                char(10) not null comment '推荐背景色值',
   start_time           datetime not null comment '起始时间',
   end_time             datetime not null comment '结束时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table nominate_shop comment '推荐商家。gooagoo平台帮助商家发展会员，在卡包的热点区域展示商家的信息。';

/*==============================================================*/
/* Table: platform_region                                       */
/*==============================================================*/
create table platform_region
(
   platform_id          char(32) not null comment '小平台编号，UUID',
   platform_name        varchar(100) not null comment '小平台名称',
   description          varchar(100) comment '描述',
   note                 varchar(100) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (platform_id)
);

alter table platform_region comment '区域性小平台';

/*==============================================================*/
/* Table: shop_ad                                               */
/*==============================================================*/
create table shop_ad
(
   ad_code              char(32) not null comment '广告位编码',
   ad_type              char(32) not null comment '广告位类型，参考通用字典表的ad_type',
   ad_name              char(50) not null comment '广告位名称',
   ad_description       char(250) comment '广告位描述',
   img_url              char(255) comment '默认图片地址',
   link_url             char(255) comment '默认链接地址',
   ad_url               char(255) comment '广告位介绍url，图片链接地址',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (ad_code)
);

alter table shop_ad comment '广告位信息';

/*==============================================================*/
/* Table: shop_bid                                              */
/*==============================================================*/
create table shop_bid
(
   id                   char(32) not null comment '商家竞价自动编号，UUID',
   bid_id               char(32) not null comment '竞拍编号',
   ad_code              char(32) not null comment '广告位编码',
   shop_id              char(32) not null comment '商家编号',
   shop_name            char(50) not null comment '商家名称',
   bid_amount           double(10,2) not null comment '竞拍金额',
   operator             char(50) not null comment '操作者',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table shop_bid comment '商家竞拍信息表';

/*==============================================================*/
/* Table: shop_interface_info                                   */
/*==============================================================*/
create table shop_interface_info
(
   id                   char(32) not null comment '自动编号，UUID',
   shop_id              char(32) not null comment '商家编码',
   i_code               char(6) not null comment '接口编码',
   i_url                varchar(255) not null comment '接口地址',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table shop_interface_info comment '商家接口地址分配';

/*==============================================================*/
/* Table: sys_authority                                         */
/*==============================================================*/
create table sys_authority
(
   authority_id         char(10) not null comment '权限ID',
   authority_name       char(32) not null comment '权限名称',
   parent_authority_id  char(10) not null comment '父权限ID',
   link                 char(255) comment '链接',
   order_no             int not null comment '排序编号',
   note                 char(255) comment '备注，对于创建和编辑，链接中保存的是展示页面的链接，备注中保存的是功能的链接',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (authority_id)
);

alter table sys_authority comment '权限表，由数据库管理员维护，只有在新增功能时才有可能变动';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   role_id              char(32) not null comment '角色编号，唯一，通过UUID产生',
   role_name            char(32) not null comment '角色名称',
   note                 char(100) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (role_id)
);

alter table sys_role comment '角色表';

/*==============================================================*/
/* Table: sys_role_authority                                    */
/*==============================================================*/
create table sys_role_authority
(
   sys_role_authority_id char(32) not null comment '自动编号，唯一，通过UUID产生',
   role_id              char(32) not null comment '角色ID',
   authority_id         char(10) not null comment '权限ID',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (sys_role_authority_id)
);

alter table sys_role_authority comment '角色-权限关联';

/*==============================================================*/
/* Table: sys_user_info                                         */
/*==============================================================*/
create table sys_user_info
(
   user_id              char(50) not null comment '用户电子邮箱，由数字、字母、下划线、@组成',
   password             char(32) not null comment '密码，MD5加密',
   status               char(1) not null comment '状态0-停用 1-启用',
   name                 char(50) not null comment '姓名',
   sex                  char(1) not null comment '性别，参考通用字典表的sex',
   birthday             date not null comment '出生日期',
   id_type              char(2) not null comment '证件类型',
   id_no                char(50) not null comment '证件号码',
   department           char(32) comment '所属部门',
   is_admin             char(1) not null default 'N' comment '是否为管理员 Y-是 N-否',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (user_id)
);

alter table sys_user_info comment '后台管理系统用户信息表';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   sys_user_role_id     char(32) not null comment '自动编号，唯一，通过UUID产生',
   user_id              char(50) not null comment '用户ID',
   role_id              char(32) not null comment '角色ID',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (sys_user_role_id)
);

alter table sys_user_role comment '用户-角色关联';

/*==============================================================*/
/* Table: template_info                                         */
/*==============================================================*/
create table template_info
(
   template_id          char(32) not null comment '模板编号，UUID',
   template_type        char(1) not null comment '模板类型，参考info_source，W-网站，M-手机',
   channel_code         char(1) not null comment '营销渠道编码，E-邮件、Q-购好奇、M-手机服务，G-商品，A-营销活动，C-优惠凭证，S-内容模板',
   template_name        char(32) not null comment '模板名称',
   template_img         char(255) not null comment '预览图片',
   template_cont        longtext not null comment '模板内容',
   template_description char(255) comment '模板描述',
   authorization        char(1) not null comment '授权方式，R-仅限于使用，W-可修改',
   user_type            char(1) not null comment '账户类型，M-后台用户，S-商家用户，P-个人用户',
   user_id              char(32) not null comment '所属用户账号',
   price                double(10,2) not null comment '费用，模板单次使用费用或授权修改费用',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (template_id)
);

alter table template_info comment '后台用户维护的模板基础信息';

/*==============================================================*/
/* Table: trade_area                                            */
/*==============================================================*/
create table trade_area
(
   trade_area_id        char(32) not null comment '商圈编号，UUID',
   platform_id          char(32) not null comment '小平台编号，表明商圈属于该小平台下',
   trade_area_name      varchar(100) not null comment '商圈名称',
   description          varchar(100) comment '描述',
   note                 varchar(100) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (trade_area_id)
);

alter table trade_area comment '商圈';

alter table ads_manage add constraint FK_Reference_3 foreign key (ad_code)
      references shop_ad (ad_code) on delete restrict on update restrict;

alter table ads_manage add constraint FK_Reference_6 foreign key (id)
      references shop_bid (id) on delete restrict on update restrict;

alter table interface_request_info add constraint FK_Reference_2 foreign key (i_code)
      references interface_base_info (i_code) on delete restrict on update restrict;

alter table shop_bid add constraint FK_Reference_4 foreign key (bid_id)
      references ads_manage (bid_id) on delete restrict on update restrict;

alter table shop_bid add constraint FK_Reference_5 foreign key (ad_code)
      references shop_ad (ad_code) on delete restrict on update restrict;

alter table shop_interface_info add constraint FK_Reference_1 foreign key (i_code)
      references interface_base_info (i_code) on delete restrict on update restrict;

alter table trade_area add constraint FK_Reference_7 foreign key (platform_id)
      references platform_region (platform_id) on delete restrict on update restrict;
