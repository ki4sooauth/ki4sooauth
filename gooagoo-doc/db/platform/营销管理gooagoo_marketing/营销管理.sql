drop table if exists coupon;

drop index coupon_no_unique on coupon_grant_info;

drop table if exists coupon_grant_info;

drop table if exists cryout_info;

drop table if exists marketing_activity;

drop table if exists marketing_event;

drop table if exists marketing_item_link;

drop table if exists marketing_quality_goods;

drop table if exists marketing_user_link;

drop table if exists notice_info;

drop table if exists rule_config;

drop table if exists rule_info;

drop table if exists rule_result;

drop table if exists shop_integral;

drop table if exists shop_integral_convert;

drop table if exists short_message;

/*==============================================================*/
/* Table: coupon                                                */
/*==============================================================*/
create table coupon
(
   coupon_id            char(32) not null comment '优惠凭证编号，UUID',
   coupon_name          char(32) not null comment '优惠凭证名称',
   shop_id              char(32) not null comment '商家编号',
   publish_start_time   datetime not null comment '优惠凭证发行开始日期',
   publish_end_time     datetime not null comment '优惠凭证发行截止日期',
   use_start_time       datetime not null comment '使用生效日期',
   use_end_time         datetime not null comment '使用截止日期',
   coupon_mode          char(1) not null comment '优惠凭证模式，0-平台默认模式，1-开放模式，2-第三方整合模式',
   coupon_type          char(1) not null comment '优惠凭证类型，参考通用字典表的coupon_type',
   coupon_value         double(8,2) not null comment '优惠凭证额度，代金券对应代金金额，折扣券对应折扣率',
   amount               int not null comment '优惠凭证最多发放的数量',
   max_num_owner        int not null comment '同一用户最多拥有的有效优惠凭证数量',
   coupon_url           char(255) not null comment '优惠凭证图片URL',
   coupon_content       text not null comment '优惠凭证内容',
   coupon_channle       char(1) not null comment '优惠凭证发布渠道，参考通用字典表的coupon_channle',
   coupon_source        char(1) comment '优惠凭证来源，参考通用字典表的coupon_source',
   check_json           text comment '使用校验，保存校验json串',
   template_id          char(32) comment '模板编号',
   template_data        longtext comment '模板数据，保存的是html代码',
   publish_status       char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (coupon_id)
);

alter table coupon comment '优惠凭证';

/*==============================================================*/
/* Table: coupon_grant_info                                     */
/*==============================================================*/
create table coupon_grant_info
(
   id                   char(32) not null comment '自动编号，UUID',
   coupon_id            char(32) not null comment '优惠凭证编号',
   coupon_no            char(32) not null comment '号段号码',
   coupon_audio_id      char(16) comment '优惠凭证音频编号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table coupon_grant_info comment '优惠凭证发放号段对应表';

/*==============================================================*/
/* Index: coupon_no_unique                                      */
/*==============================================================*/
create unique index coupon_no_unique on coupon_grant_info
(
   coupon_id,
   coupon_no
);

/*==============================================================*/
/* Table: cryout_info                                           */
/*==============================================================*/
create table cryout_info
(
   cryout_info_id       char(32) not null comment '吆喝编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   activity_id          char(32) comment '活动编号',
   cryout_title         char(32) comment '吆喝标题',
   cryout_type          char(1) not null comment '吆喝类型，参考通用字典表的cryout_type',
   marketing_link_type  char(1) comment '营销内容关联类型，参考通用字典表的marketing_link_type',
   marketing_link_id    char(32) comment '营销内容关联编号，如关联的是商品，此字段保存的是商品的编号，其他类型依次类推',
   cryout_text_mobile   varchar(1000) not null comment '具体内容（手机）',
   cryout_text_web      varchar(1000) not null comment '具体内容（网站）',
   img                  varchar(255) comment '关联图片，仅限一张',
   publish_status       char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   rule_id              char(32) comment '发布规则编号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (cryout_info_id)
);

alter table cryout_info comment '吆喝信息表';

/*==============================================================*/
/* Table: marketing_activity                                    */
/*==============================================================*/
create table marketing_activity
(
   activity_id          char(32) not null comment '活动编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   activity_name        char(32) not null comment '活动名称',
   title                char(32) not null comment '活动主题',
   start_time           datetime not null comment '活动开始时间',
   end_time             datetime not null comment '活动结束时间',
   img_url              char(255) not null comment '活动图片URL',
   content              text not null comment '活动内容',
   purpose              char(255) not null comment '活动目的',
   description          char(255) not null comment '活动描述',
   template_id          char(32) comment '模板编号',
   template_data        longtext comment '模板数据，保存的是html代码',
   publish_status       char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (activity_id)
);

alter table marketing_activity comment '营销活动表';

/*==============================================================*/
/* Table: marketing_event                                       */
/*==============================================================*/
create table marketing_event
(
   event_id             char(32) not null comment '事件编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   activity_id          char(32) comment '活动编号',
   event_name           char(32) not null comment '事件名称',
   event_target         varchar(255) not null comment '目的',
   channel_root         char(32) not null comment '模板渠道编码（根节点）',
   channel_leaf         char(32) not null comment '模板渠道编码（叶节点）',
   template_id          char(32) not null comment '模板编号',
   template_data        longtext not null comment '模板数据，保存的是json串',
   publish_status       char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   rule_id              char(32) comment '发布规则编号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (event_id)
);

alter table marketing_event comment '营销事件';

/*==============================================================*/
/* Table: marketing_item_link                                   */
/*==============================================================*/
create table marketing_item_link
(
   id                   char(32) not null comment '自动编号，UUID',
   marketing_type       char(32) not null comment '营销类型，参考通用字典表的rule_type',
   marketing_id         char(32) not null comment '营销内容编号，吆喝编号、通知编号等',
   shop_id              char(32) not null comment '商家编号',
   activity_id          char(32) comment '所属活动编号',
   marketing_link_type  char(1) not null comment '营销内容关联类型，参考通用字典表的marketing_link_type',
   marketing_link_id    char(32) not null comment '营销内容关联编号，如关联的是商品，此字段保存的是商品的编号，其他类型依次类推',
   sort                 int not null comment '排列顺序',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table marketing_item_link comment '营销内容与商品、活动、优惠凭证关联表';

/*==============================================================*/
/* Table: marketing_quality_goods                               */
/*==============================================================*/
create table marketing_quality_goods
(
   id                   char(32) not null comment '自动编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   quality_type_root    int not null comment '精品类型（根节点）',
   quality_type_leaf    int not null comment '精品类型（叶节点）',
   goods_id             char(32) not null comment '商品编号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table marketing_quality_goods comment '精品推荐';

/*==============================================================*/
/* Table: marketing_user_link                                   */
/*==============================================================*/
create table marketing_user_link
(
   id                   char(32) not null comment '自动编号，UUID',
   marketing_type       char(32) not null comment '营销类型，参考通用字典表的rule_type',
   marketing_id         char(32) not null comment '营销内容编号，吆喝编号、通知编号等',
   shop_id              char(32) not null comment '商家编号',
   account_type         char(1) not null comment '用户帐号类型（userid、phyno、mac）',
   account              char(50) not null comment '用户帐号',
   activity_id          char(32) comment '所属活动编号',
   is_pushed            char(1) not null comment '是否已推送，Y-已推送，N-未推送',
   push_time            datetime comment '推送时间',
   is_read              char(1) not null comment '是否已读，Y-已读，N-未读',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table marketing_user_link comment '营销内容与用户关联表';

/*==============================================================*/
/* Table: notice_info                                           */
/*==============================================================*/
create table notice_info
(
   notice_info_id       char(32) not null comment '通知编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   activity_id          char(32) comment '活动编号',
   notice_title         char(32) not null comment '通知标题',
   marketing_link_type  char(1) comment '营销内容关联类型，参考通用字典表的marketing_link_type',
   marketing_link_id    char(32) comment '营销内容关联编号，如关联的是商品，此字段保存的是商品的编号，其他类型依次类推',
   notice_text_mobile   varchar(1000) not null comment '具体内容（手机）',
   notice_text_web      varchar(1000) not null comment '具体内容（网站）',
   img                  varchar(255) comment '关联图片，仅限一张',
   publish_status       char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   rule_id              char(32) comment '发布规则编号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (notice_info_id)
);

alter table notice_info comment '商家通知信息表';

/*==============================================================*/
/* Table: rule_config                                           */
/*==============================================================*/
create table rule_config
(
   id                   char(32) not null comment '规则配置编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   behave_type          char(1) not null comment '行为类型，参考通用字典表的behave_type',
   is_show_date_scope   char(1) not null comment '是否显示日期段：Y-是，N-否',
   is_show_week_scope   char(1) not null comment '是否显示星期段：Y-是，N-否',
   is_show_time_scope   char(1) not null comment '是否显示时间段：Y-是，N-否',
   is_show_vip_grade    char(1) not null comment '是否显示会员等级：Y-是，N-否',
   is_show_action_source char(1) not null comment '是否显示行为来源：Y-是，N-否',
   is_show_time         char(1) not null comment '是否显示当天次数：Y-是，N-否',
   is_show_total_time   char(1) not null comment '是否显示累计次数：Y-是，N-否',
   is_show_marketing_goods_category char(1) not null comment '是否显示品类：Y-是，N-否',
   is_show_marketing_goods_brand char(1) not null comment '是否显示品牌：Y-是，N-否',
   is_show_marketing_goods char(1) not null comment '是否显示商品：Y-是，N-否',
   is_show_marketing_action char(1) not null comment '是否显示活动：Y-是，N-否',
   is_show_marketing_coupon char(1) not null comment '是否显示优惠凭证：Y-是，N-否',
   is_show_marketing_event char(1) not null comment '是否显示营销内容：Y-是，N-否',
   is_show_server_tools char(1) not null comment '是否显示服务工具：Y-是，N-否',
   is_show_position     char(1) not null comment '是否显示区域：Y-是，N-否',
   is_show_duration     char(1) not null comment '是否显示时长：Y-是，N-否',
   is_show_consume_money char(1) not null comment '是否显示消费金额：Y-是，N-否',
   is_show_vb           char(1) not null comment '是否显示CMS栏目：Y-是，N-否',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table rule_config comment '规则配置表';

/*==============================================================*/
/* Table: rule_info                                             */
/*==============================================================*/
create table rule_info
(
   rule_id              char(32) not null comment '规则编号，UUID',
   rule_name            char(32) comment '规则名称',
   shop_id              char(32) not null comment '商家编号',
   activity_id          char(32) comment '活动编号',
   rule_type            char(1) not null comment '规则类型，参考通用字典表的rule_type',
   rule_active_type     char(1) not null comment '规则生效类型，参考通用字典表的rule_active_type',
   object_id            char(32) not null comment '规则对象编号，指事件、吆喝、通知等发布内容的编号',
   is_active_forever    char(1) not null comment '是否永久生效，Y-是，N-否',
   start_time           datetime not null comment '规则生效时间',
   end_time             datetime not null comment '规则失效时间',
   crowd_type           char(1) not null comment '发布人群类型，0-历史人群，1-即时人群，2-两者全有',
   is_publish_immediately char(1) not null comment '是否立即发布，Y-是，N-否',
   expect_publish_time  datetime comment '预期发布时间',
   actual_publish_time  datetime comment '实际发布时间',
   rule_content         text comment '规则内容，保存的是规则的json串',
   publish_status       char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (rule_id)
);

alter table rule_info comment '规则表，为事件、吆喝、通知、邮件、短信、积分、优惠、发卡制定发布规则。此表为发布规则的索引信息，发布规则的详细信息参考n';

/*==============================================================*/
/* Table: rule_result                                           */
/*==============================================================*/
create table rule_result
(
   rule_result_id       char(32) not null comment '规则结果编号，UUID',
   activity_id          char(32) comment '活动编号',
   add_consume_money    double(10,2) comment '追加金额：规则结果',
   rule_result_type     varchar(500) comment '规则结果类型：参见表sys_dictionary',
   rule_result_value    varchar(500) comment '规则结果：积分/金额/商品ID',
   rule_desc            varchar(500) comment '规则描述，用文字描述规则内容，便于给用户展示',
   publish_status       char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   rule_id              char(32) not null comment '发布规则编号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (rule_result_id)
);

alter table rule_result comment '规结果则表（包括积分规则结果，营销规则结果）';

/*==============================================================*/
/* Table: shop_integral                                         */
/*==============================================================*/
create table shop_integral
(
   shop_integral_id     char(32) not null comment '积分营销编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   integral_trade_type  char(1) not null comment '积分兑换类型，参考通用字典表的integral_trade_type',
   integral_trade_id    char(32) not null comment '积分兑换对象编号，为商品的编号或者优惠凭证的编号',
   trade_integral_value int not null comment '兑换积分值',
   trade_start_time     datetime not null comment '允许兑换开始时间',
   trade_end_time       datetime not null comment '允许兑换结束时间',
   convert_nums         int comment '兑换次数',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shop_integral_id)
);

alter table shop_integral comment '积分商城';

/*==============================================================*/
/* Table: shop_integral_convert                                 */
/*==============================================================*/
create table shop_integral_convert
(
   shop_integral_convert_id char(32) not null comment '积分兑换信息编号，UUID',
   shop_integral_id     char(32) not null comment '积分营销编号',
   user_id              char(32) not null comment '用户编号',
   shop_id              char(32) not null comment '商家编号',
   integral_trade_type  char(1) not null comment '积分兑换类型，参考通用字典表的integral_trade_type',
   integral_trade_id    char(32) not null comment '积分兑换对象编号，为商品的编号或者优惠凭证的编号',
   trade_integral_value int not null comment '兑换积分值',
   info_source          char(1) not null comment '信息来源，参考通用字典表的info_source',
   convert_time         datetime not null comment '兑换时间',
   consignee_id         char(32) comment '收货人信息编号，关联收货人信息的主键',
   delivery_status      char(1) comment '取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shop_integral_convert_id)
);

alter table shop_integral_convert comment '积分兑换信息';

/*==============================================================*/
/* Table: short_message                                         */
/*==============================================================*/
create table short_message
(
   message_id           char(32) not null comment '短信编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   activity_id          char(32) comment '活动编号',
   message_title        char(32) not null comment '短信标题，用于审核和发布，不发送给用户',
   content              varchar(300) not null comment '短信内容',
   publish_status       char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   rule_id              char(32) comment '发布规则编号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (message_id)
);

alter table short_message comment '短信内容表';

alter table cryout_info add constraint FK_Reference_3 foreign key (rule_id)
      references rule_info (rule_id) on delete restrict on update restrict;

alter table cryout_info add constraint FK_Reference_7 foreign key (activity_id)
      references marketing_activity (activity_id) on delete restrict on update restrict;

alter table marketing_event add constraint FK_Reference_5 foreign key (rule_id)
      references rule_info (rule_id) on delete restrict on update restrict;

alter table marketing_event add constraint FK_Reference_9 foreign key (activity_id)
      references marketing_activity (activity_id) on delete restrict on update restrict;

alter table notice_info add constraint FK_Reference_4 foreign key (rule_id)
      references rule_info (rule_id) on delete restrict on update restrict;

alter table notice_info add constraint FK_Reference_8 foreign key (activity_id)
      references marketing_activity (activity_id) on delete restrict on update restrict;

alter table shop_integral_convert add constraint FK_Reference_1 foreign key (shop_integral_id)
      references shop_integral (shop_integral_id) on delete restrict on update restrict;

alter table short_message add constraint FK_Reference_2 foreign key (rule_id)
      references rule_info (rule_id) on delete restrict on update restrict;

alter table short_message add constraint FK_Reference_6 foreign key (activity_id)
      references marketing_activity (activity_id) on delete restrict on update restrict;
