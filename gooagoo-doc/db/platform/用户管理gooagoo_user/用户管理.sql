drop table if exists consignee_info;

drop table if exists product_serial_number;

drop table if exists receipt_info;

drop table if exists sys_security_question;

drop table if exists user_account_bind;

drop table if exists user_emailactive_code;

drop index user_account on user_info;

drop index user_num on user_info;

drop index user_email on user_info;

drop index user_mobile on user_info;

drop table if exists user_info;

drop table if exists user_mobile_code;

drop table if exists user_mobile_info;

drop table if exists user_profile;

drop table if exists user_security_card;

drop table if exists user_security_question;

/*==============================================================*/
/* Table: consignee_info                                        */
/*==============================================================*/
create table consignee_info
(
   consignee_id         char(32) not null comment '收货人信息编号，UUID',
   user_id              char(32) not null comment '用户编号',
   consignee_name       char(32) not null comment '收货人姓名',
   province             char(10) not null comment '省',
   city                 char(10) not null comment '市',
   area                 char(10) not null comment '区县',
   address              char(255) not null comment '详细地址',
   phone                char(11) comment '手机号码',
   telephone            char(20) comment '联系电话',
   post_code            char(6) not null comment '邮政编码',
   is_default           char(1) not null comment '是否默认选项，Y-是，N-否',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (consignee_id)
);

alter table consignee_info comment '收货人信息';

/*==============================================================*/
/* Table: product_serial_number                                 */
/*==============================================================*/
create table product_serial_number
(
   gooagoo_id           char(32) not null comment '产品序列号，UUID',
   mac_address          char(20) not null comment '手机mac地址',
   m_id                 char(50) comment '手机硬件id',
   m_ver                char(10) comment '手机程序版本',
   m_type               char(50) comment '手机系统类型',
   create_time          datetime not null comment '创建时间',
   primary key (gooagoo_id)
);

alter table product_serial_number comment '产品序列号信息';

/*==============================================================*/
/* Table: receipt_info                                          */
/*==============================================================*/
create table receipt_info
(
   receipt_id           char(32) not null comment '自动编号，UUID',
   user_id              char(32) not null comment '用户编号',
   company_name         char(50) comment '公司名称',
   is_default           char(1) not null comment '是否默认选项，Y-是，N-否',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (receipt_id)
);

alter table receipt_info comment '发票信息管理';

/*==============================================================*/
/* Table: sys_security_question                                 */
/*==============================================================*/
create table sys_security_question
(
   sys_id               char(32) not null comment '问题编号，UUID',
   content              char(255) not null comment '问题内容',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (sys_id)
);

alter table sys_security_question comment '系统密保问题表';

/*==============================================================*/
/* Table: user_account_bind                                     */
/*==============================================================*/
create table user_account_bind
(
   id                   char(32) not null comment '自动编号，唯一，通过UUID产生',
   user_id              char(32) not null comment '用户编号',
   third_account_type   varchar(10) not null comment '第三方帐号类型（区分是微博还是QQ等）',
   third_account        varchar(255) not null comment '第三方帐号',
   authorize_id         varchar(255) comment '授权编号',
   authorize_expire_time datetime comment '授权过期时间',
   note                 varchar(500) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table user_account_bind comment '描述购阿购平台用户帐号与第三方平台用户帐号的绑定关系。一个购阿购平台用户帐号可以绑定多个第三方平台用户帐号。';

/*==============================================================*/
/* Table: user_emailactive_code                                 */
/*==============================================================*/
create table user_emailactive_code
(
   id                   char(32) not null comment '编号，唯一，通过UUID产生',
   user_id              char(32) not null comment '用户编号',
   exp_date             datetime not null comment '激活码过期时间，为创建时间的两天之内',
   is_active            char(1) not null comment '是否激活：Y-已激活，N-未激活',
   active_date          datetime comment '激活时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table user_emailactive_code comment '个人用户邮箱激活码';

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   user_id              char(32) not null comment '用户编号，唯一，通过UUID产生',
   account              char(50) comment '用户名，唯一，不包含特殊字符',
   mobile               char(11) comment '手机号码，唯一，11位数字',
   email                char(50) comment '电子邮箱，唯一，字母、数字、下划线、@组成',
   password             char(32) not null comment '登录口令，md5加密',
   user_type            char(1) not null comment '用户来源：M-手机端，W-PC端',
   user_status          char(1) not null comment '用户状态：L-锁定，U-正常',
   user_num             char(8) not null comment '默认卡号，用户无卡刷卡，唯一',
   is_active_email      char(1) not null comment '是否激活：Y-已激活，N-未激活，手机端注册时默认为已激活',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (user_id)
);

alter table user_info comment '个人用户表';

/*==============================================================*/
/* Index: user_mobile                                           */
/*==============================================================*/
create unique index user_mobile on user_info
(
   mobile
);

/*==============================================================*/
/* Index: user_email                                            */
/*==============================================================*/
create unique index user_email on user_info
(
   email
);

/*==============================================================*/
/* Index: user_num                                              */
/*==============================================================*/
create unique index user_num on user_info
(
   user_num
);

/*==============================================================*/
/* Index: user_account                                          */
/*==============================================================*/
create unique index user_account on user_info
(
   account
);

/*==============================================================*/
/* Table: user_mobile_code                                      */
/*==============================================================*/
create table user_mobile_code
(
   id                   char(32) not null comment '编号，唯一，通过UUID产生',
   mobile               char(32) not null comment '手机号码',
   captcha_code         char(32) not null comment '验证码',
   exp_date             datetime not null comment '过期时间，为创建时间的5分钟之内',
   is_used              char(1) not null comment '是否使用：Y-已使用，N-未使用',
   use_date             datetime comment '使用时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table user_mobile_code comment '手机验证码';

/*==============================================================*/
/* Table: user_mobile_info                                      */
/*==============================================================*/
create table user_mobile_info
(
   user_id              char(32) not null comment '用户编号',
   mac_address          char(20) comment '手机mac地址',
   m_id                 char(50) comment '手机硬件id',
   m_ver                char(10) comment '手机程序版本',
   m_type               char(50) comment '手机系统类型',
   sessionid            char(50) comment '手机登录后的SessionId值',
   iphone_token         char(100) comment 'Iphone的token值',
   iphone_token_time    datetime comment '得到tokentime的时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (user_id)
);

alter table user_mobile_info comment '用户移动终端信息';

/*==============================================================*/
/* Table: user_profile                                          */
/*==============================================================*/
create table user_profile
(
   user_id              char(32) not null comment '用户编号，关联user_info表的用户编号',
   real_name            char(50) comment '真实姓名',
   sex                  char(1) default 'M' comment '性别：M-男，F-女，P-其他',
   birthday             date comment '出生日期',
   id_type              char(2) comment '证件类型',
   id_no                char(30) comment '证件号码',
   telephone            char(20) comment '联系电话',
   post_code            char(10) comment '邮政编码',
   province             char(10) comment '省',
   city                 char(10) comment '市',
   area                 char(10) comment '区县',
   address              char(255) comment '详细地址',
   reg_ip               char(20) comment '用户注册的ip',
   is_allow_friend      char(1) not null comment '是否允许别人加自己为好友',
   head_pic             char(255) not null comment '用户头像图片URL，默认为系统头像',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (user_id)
);

alter table user_profile comment '用户辅助信息';

/*==============================================================*/
/* Table: user_security_card                                    */
/*==============================================================*/
create table user_security_card
(
   id                   char(32) not null comment '密保卡编号，UUID',
   user_id              char(32) not null comment '用户编号',
   serial_num           char(32) not null comment '密保卡序列号',
   coord_data           varchar(1000) not null comment '密保卡坐标数据，JSON串格式',
   is_bind              char(1) not null comment '是否已绑定，Y-已绑定，N-未绑定',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table user_security_card comment '用户密保卡表';

/*==============================================================*/
/* Table: user_security_question                                */
/*==============================================================*/
create table user_security_question
(
   id                   char(32) not null comment '问题编号，UUID',
   user_id              char(32) not null comment '用户编号',
   type                 char(1) not null comment '问题类型，1-系统内置问题，2-用户自定义问题',
   sys_id               char(32) comment '系统问题编号',
   content              char(255) not null comment '问题内容',
   answer               char(255) not null comment '问题答案',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table user_security_question comment '用户密保问题表';

alter table consignee_info add constraint FK_Reference_4 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table receipt_info add constraint FK_Reference_3 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table user_emailactive_code add constraint FK_Reference_2 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table user_mobile_info add constraint FK_Reference_5 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table user_profile add constraint FK_Reference_1 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table user_security_card add constraint FK_Reference_8 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table user_security_question add constraint FK_Reference_6 foreign key (sys_id)
      references sys_security_question (sys_id) on delete restrict on update restrict;

alter table user_security_question add constraint FK_Reference_7 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;
