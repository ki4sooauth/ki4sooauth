drop table if exists card_up_info;

drop table if exists convert_apply;

drop table if exists integral_detail_info;

drop table if exists integral_info;

drop table if exists member_apply;

drop index phyno_index on member_base_info;

drop index member on member_base_info;

drop table if exists member_base_info;

drop index card_type2_index on member_card;

drop table if exists member_card;

drop index type_code_index on member_feature;

drop table if exists member_feature;

drop index member on member_feature_info;

drop table if exists member_feature_info;

drop table if exists member_of_card;

/*==============================================================*/
/* Table: card_up_info                                          */
/*==============================================================*/
create table card_up_info
(
   id                   char(32) not null comment '自动编号,UUID',
   user_id              char(32) not null comment '用户编号',
   shop_id              char(32) not null comment '商家ID',
   card_id              char(32) not null comment '当前会员卡编码',
   up_card_id           char(32) not null comment '积分升级可获得的会员卡编码',
   need_integral        int not null comment '会员卡升级所需积分',
   phy_no               char(32) not null comment '物理卡号',
   phy_name             char(32) not null comment '物理卡名称',
   name                 char(32) comment '姓名',
   sex                  char(1) comment '性别，参考通用字典表的sex',
   birthday             date comment '出生日期',
   id_type              char(2) comment '证件类型，参考通用字典表的idtype',
   id_no                char(30) comment '证件号码',
   mobile               char(20) comment '手机号码',
   telephone            char(20) comment '联系电话',
   email                char(50) comment '电子邮箱',
   postcode             char(10) comment '邮政编码',
   status               char(1) not null comment '审核状态，参考通用字典表的application_status',
   audit_note           char(100) comment '审核备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table card_up_info comment '满足积分升级的会员卡信息';

/*==============================================================*/
/* Table: convert_apply                                         */
/*==============================================================*/
create table convert_apply
(
   application_id       char(32) not null comment '申请编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   user_id              char(32) not null comment '用户编号',
   apply_time           datetime not null comment '申请日期',
   phy_no               char(32) not null comment '物理卡号',
   id_no                char(20) comment '身份证号码',
   mobile               char(11) comment '手机号码',
   status               char(1) not null comment '申请状态，参考通用字典表的application_status',
   audit_note           char(100) comment '审核备注',
   source               char(1) not null comment '信息来源，参考通用字典表的source',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (application_id)
);

alter table convert_apply comment '物理卡转换申请';

/*==============================================================*/
/* Table: integral_detail_info                                  */
/*==============================================================*/
create table integral_detail_info
(
   integral_id          char(32) not null comment '积分明细编号，UUID',
   user_id              char(32) not null comment '用户编号',
   shop_id              char(32) not null comment '商家编号',
   integral_number      int not null comment '积分数量',
   integral_source      char(1) not null comment '积分来源，参考通用字典表的integral_source',
   integral_create_time datetime not null comment '积分产生时间',
   note                 char(50) not null comment '备注，描述特批人员及特批原因；如果是行为产生的，则记录行为编号',
   is_freez             char(1) not null comment '是否冻结，N-未冻结，Y-已冻结',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (integral_id)
);

alter table integral_detail_info comment '积分明细表';

/*==============================================================*/
/* Table: integral_info                                         */
/*==============================================================*/
create table integral_info
(
   integral_id          char(32) not null comment '积分编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   user_id              char(32) not null comment '用户编号',
   history_total_integral int not null comment '历史总积分，用于会员卡的升级',
   useable_integral_number int not null comment '可用积分，用于兑换商品或优惠凭证',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (integral_id)
);

alter table integral_info comment '积分汇总表，通过对积分详细表的数据分析得出';

/*==============================================================*/
/* Table: member_apply                                          */
/*==============================================================*/
create table member_apply
(
   application_id       char(32) not null comment '申请编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   user_id              char(32) not null comment '用户编号',
   apply_time           datetime not null comment '申请日期',
   name                 char(32) not null comment '姓名',
   sex                  char(1) comment '性别，参考通用字典表的sex',
   birthday             date comment '出生日期',
   id_type              char(2) comment '证件类型，参考通用字典表的idtype',
   id_no                char(30) comment '证件号码',
   mobile               char(20) comment '手机号码',
   telephone            char(20) comment '联系电话',
   email                char(50) comment '电子邮箱',
   postcode             char(10) comment '邮政编码',
   address              varchar(250) comment '通讯地址',
   status               char(1) not null comment '申请状态，参考通用字典表的application_status',
   audit_note           char(100) comment '审核备注',
   source               char(1) not null comment '信息来源，参考通用字典表的source',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (application_id)
);

alter table member_apply comment '会员卡申请';

/*==============================================================*/
/* Table: member_base_info                                      */
/*==============================================================*/
create table member_base_info
(
   id                   char(32) not null comment '自动编号，UUID',
   shop_id              char(32) not null comment '商家ID',
   phy_no               char(32) not null comment '物理卡号',
   phy_name             char(32) not null comment '物理卡名称',
   name                 char(32) comment '姓名',
   sex                  char(1) comment '性别，参考通用字典表的sex',
   birthday             date comment '出生日期',
   id_type              char(2) comment '证件类型，参考通用字典表的idtype',
   id_no                char(30) comment '证件号码',
   mobile               char(20) comment '手机号码',
   telephone            char(20) comment '联系电话',
   email                char(50) comment '电子邮箱',
   postcode             char(10) comment '邮政编码',
   address              varchar(250) comment '通讯地址',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table member_base_info comment '会员基本信息';

/*==============================================================*/
/* Index: member                                                */
/*==============================================================*/
create unique index member on member_base_info
(
   shop_id,
   phy_no
);

/*==============================================================*/
/* Index: phyno_index                                           */
/*==============================================================*/
create index phyno_index on member_base_info
(
   phy_no
);

/*==============================================================*/
/* Table: member_card                                           */
/*==============================================================*/
create table member_card
(
   card_id              char(32) not null comment '会员卡编号',
   card_name            char(32) not null comment '会员卡名称',
   shop_id              char(32) not null comment '商家编号',
   card_type            char(2) not null comment '会员卡类型，00表示关注卡，10-F0表示电子卡号和实体卡号相同，F1-FF表示电子卡号和实体卡号不同',
   card_type2           char(1) not null comment '会员卡类型2，0-关注卡，1-电子卡，2-实体卡',
   card_lvl             char(1) not null comment '会员卡级别，0-关注卡，1-基础卡，2-高级卡。关注卡到店自动发放，基础卡需要会员申请，高级卡从基础卡自动升级而来。特批功能可把用户的卡设置成任意类型的卡。',
   need_approval        char(1) not null comment '是否需要审批，Y-需要审批，N-不需要审批。关注卡不需要审批，基础卡和高级卡可设定此属性。如果基础卡设定为Y（需要审批），则用户申请之后需要等待商家审批通过，否则直接发放给用户。如果高级卡设定为Y（需要审批），用户积分满足此卡条件之后，需要等待商家审批通过，否则直接自动升级发放给用户。',
   need_jifen           int not null comment '升级所需积分',
   card_url             varchar(255) not null comment '会员卡图片URL',
   description          varchar(200) not null comment '会员权限说明',
   useLimited           int not null comment '使用期限，以天为单位，关注卡默认为9999',
   publish_status       char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (card_id)
);

alter table member_card comment '会员卡基本表';

/*==============================================================*/
/* Index: card_type2_index                                      */
/*==============================================================*/
create index card_type2_index on member_card
(
   card_type2
);

/*==============================================================*/
/* Table: member_feature                                        */
/*==============================================================*/
create table member_feature
(
   id                   char(32) not null comment '自动编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   type_code            char(32) not null comment '类型编号，例如color，同一商家唯一，由商家录入',
   type_name            char(32) not null comment '类型名称，例如颜色，同一商家唯一，由商家录入',
   enum_value           varchar(1000) not null comment '枚举值，保存的是json串，例如["黄色","蓝色","白色"]',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table member_feature comment '会员特征字典表';

/*==============================================================*/
/* Index: type_code_index                                       */
/*==============================================================*/
create index type_code_index on member_feature
(
   type_code
);

/*==============================================================*/
/* Table: member_feature_info                                   */
/*==============================================================*/
create table member_feature_info
(
   id                   char(32) not null comment '自动编号',
   shop_id              char(32) not null comment '商家ID',
   phy_no               char(32) not null comment '物理卡号',
   user_id              char(32) comment '用户编号',
   scard_no             char(32) comment '电子卡号',
   feature_code         varchar(32) not null comment '特征编码，如color',
   feature_value        varchar(32) not null comment '特征数值，如蓝色',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table member_feature_info comment '会员特征信息';

/*==============================================================*/
/* Index: member                                                */
/*==============================================================*/
create unique index member on member_feature_info
(
   shop_id,
   phy_no,
   feature_code
);

/*==============================================================*/
/* Table: member_of_card                                        */
/*==============================================================*/
create table member_of_card
(
   scardno              char(16) not null comment '会员卡音频编号电子卡号，卡号规则：6位LID（代表实体店）+8位唯一标识（userinfo表的usernum字段）+会员卡类型（00关注卡，10～F0电子卡，F1～FF实体卡）',
   phy_card_no          char(32) not null comment '物理卡号，分两种情况：1、商家在使用gooagoo系统之前已经有会员，此时物理卡号和电子卡号是不一样的，电子卡号由gooagoo系统生成，而物理卡号沿用商家原有的卡号，以建立一一对应的关系；2、商家在使用gooagoo系统之前没有会员，此时物理卡号和电子卡号是一样的，都由gooagoo系统生成。',
   card_id              char(32) not null comment '会员卡编号',
   user_id              char(32) not null comment '用户编号',
   shop_id              char(32) not null comment '商家编号',
   card_type2           char(1) not null comment '会员卡类型2，0-关注卡，1-电子卡，2-实体卡',
   expireDate           datetime not null comment '过期时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (scardno)
);

alter table member_of_card comment '会员卡与用户关联表';

alter table member_feature_info add constraint FK_Reference_2 foreign key (phy_no)
      references member_base_info (phy_no) on delete restrict on update cascade;

alter table member_feature_info add constraint FK_Reference_3 foreign key (feature_code)
      references member_feature (type_code) on delete restrict on update restrict;

alter table member_of_card add constraint FK_Reference_4 foreign key (card_id)
      references member_card (card_id) on delete restrict on update restrict;

alter table member_of_card add constraint FK_Reference_5 foreign key (card_type2)
      references member_card (card_type2) on delete restrict on update restrict;
