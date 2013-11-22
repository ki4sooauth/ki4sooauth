drop table if exists favorite_info;

drop table if exists shopping_plan_goods;

drop table if exists user_comment;

drop table if exists user_feedback;

drop index user_syn on user_last_time;

drop index scard_syn on user_last_time;

drop table if exists user_last_time;

drop table if exists user_shopping_plan;

drop table if exists user_store_queue;

/*==============================================================*/
/* Table: favorite_info                                         */
/*==============================================================*/
create table favorite_info
(
   favorite_id          char(32) not null comment '收藏编号，UUID，对于优惠凭证，只有16位，前14位表示优惠凭证音频编号，后2位固定为01，表示刷优惠凭证',
   user_id              char(32) not null comment '用户编号',
   shop_id              char(32) not null comment '商家编号',
   info_title           national char(255) not null comment '收藏标题，为优惠券、商品、活动的名称',
   info_type            national char(1) not null comment '收藏类型，参考通用字典表的favorite_type',
   info_url             char(255) not null comment '收藏地址，为优惠券、商品、活动的地址',
   object_id            char(32) not null comment '收藏的商品、活动的id，如果收藏的是优惠凭证，则是优惠凭证编号',
   source               char(1) not null default '0' comment '信息来源，参考通用字典表的info_source
            ',
   coupon_status        char(1) comment '优惠凭证状态，参考通用字典表的coupon_status',
   use_time             datetime comment '优惠凭证使用时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (favorite_id)
);

alter table favorite_info comment '收藏信息';

/*==============================================================*/
/* Table: shopping_plan_goods                                   */
/*==============================================================*/
create table shopping_plan_goods
(
   shopping_goods_id    char(32) not null comment '购物清单详细编号，UUID',
   shopping_list_id     char(32) not null comment '购物清单编号',
   goods_id             char(32) comment '商品编号',
   goods_name           char(50) not null comment '商品名称',
   goods_type_id        int comment '商品类型编号',
   goods_type_name      char(50) comment '商品类型名称',
   shop_id              char(32) comment '商家编号',
   shop_name            char(150) comment '商家名称',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shopping_goods_id)
);

alter table shopping_plan_goods comment '购物清单商品表';

/*==============================================================*/
/* Table: user_comment                                          */
/*==============================================================*/
create table user_comment
(
   comment_id           char(32) not null comment '评论编号，UUID',
   user_id              char(32) not null comment '评论的用户编号',
   shop_id              char(32) not null comment '评论的商家编号',
   goods_id             char(32) not null comment '评论的商品编号',
   comment_type         char(1) not null comment '评论类型，参考通用字典表的comment_type',
   comment_level        int not null comment '评分',
   content              char(255) not null comment '评论的具体内容',
   source               char(1) not null default '0' comment '信息来源，参考通用字典表的info_source
            ',
   come_ip              char(20) not null comment '记录发表评论人的ip地址',
   is_auditing          char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (comment_id)
);

alter table user_comment comment '用户评论';

/*==============================================================*/
/* Table: user_feedback                                         */
/*==============================================================*/
create table user_feedback
(
   feedback_id          char(32) not null comment '反馈编号，UUID',
   user_id              char(32) not null comment '用户编号',
   gooagoo_id           char(32) not null comment 'gooagooID，平台分配给手机设备的唯一编号',
   ip_address           char(20) comment 'IP地址',
   mac_address          char(20) comment 'MAC地址',
   host_name            char(32) comment '主机名',
   phone                char(20) comment '手机号',
   phone_type           char(32) comment '手机型号',
   version              char(32) comment '程序版本',
   content              text not null comment '反馈内容',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (feedback_id)
);

alter table user_feedback comment '用户反馈，收集用户对gooagooAPP的使用反馈';

/*==============================================================*/
/* Table: user_last_time                                        */
/*==============================================================*/
create table user_last_time
(
   id                   char(32) not null comment '自动编号，UUID',
   user_id              char(32) not null comment '用户id',
   shop_id              char(32) not null comment '商家id',
   shop_name            char(50) not null comment '商家名称',
   shop_type_root       int not null comment '商家类型',
   card_id              char(32) not null comment '会员卡id',
   card_type2           char(1) not null comment '会员卡类型2，0-关注卡，1-电子卡，2-实体卡',
   scardno              char(16) not null comment '会员卡音频编码',
   shopping_time        datetime not null comment '最后一次购物时间',
   stroll_time          datetime not null comment '最后一次到店时间',
   primary key (id)
);

alter table user_last_time comment '用户最后一次足迹以及购物时间';

/*==============================================================*/
/* Index: scard_syn                                             */
/*==============================================================*/
create unique index scard_syn on user_last_time
(
   scardno
);

/*==============================================================*/
/* Index: user_syn                                              */
/*==============================================================*/
create index user_syn on user_last_time
(
   user_id
);

/*==============================================================*/
/* Table: user_shopping_plan                                    */
/*==============================================================*/
create table user_shopping_plan
(
   shopping_list_id     char(32) not null comment '购物清单编号，UUID',
   user_id              char(32) not null comment '用户编号',
   title                char(32) not null comment '购物清单标题',
   pre_shopping_time    datetime not null comment '预计购物时间',
   info_source          char(1) not null default '0' comment '信息来源，参考通用字典表的info_source',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shopping_list_id)
);

alter table user_shopping_plan comment '购物清单主表';

/*==============================================================*/
/* Table: user_store_queue                                      */
/*==============================================================*/
create table user_store_queue
(
   id                   char(32) not null comment '自动编号，UUID',
   user_id              char(32) comment '用户编号',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   queue_no             int not null comment '排队号码',
   nums                 int not null comment '人数，本次排号所对应的人数',
   queue_type           char(32) not null comment '排队类型，对应餐桌的类型',
   is_elimination       char(1) not null comment '是否销号，Y-已销号，N-未销号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table user_store_queue comment '排号记录，当餐桌够用时，不进行排号，餐桌不够用时才进行排号，由店员进行销号。当号码都已经消除，则重新排号。所有类型的餐桌';
