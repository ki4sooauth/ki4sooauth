/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013-11-11 17:03:25                          */
/*==============================================================*/


drop table if exists open_app_info;

drop table if exists open_interface_info;

drop table if exists open_interface_log;

drop table if exists open_interface_right;

drop table if exists open_interface_role_rel;

drop table if exists open_role;

drop table if exists open_user_token_rel;

/*==============================================================*/
/* Table: open_app_info                                         */
/*==============================================================*/
create table open_app_info
(
   app_key              int not null auto_increment comment '应用KEY',
   app_name             varchar(30) comment '应用名称',
   app_type             varchar(30) comment '应用类型',
   app_label            varchar(30) comment '应用标签',
   app_secret           char(32) comment '应用密钥',
   volume               int comment '证书流量',
   app_status           char(1) comment '应用状态',
   user_id              varchar(30) not null comment '用户ID',
   create_dt            datetime comment '应用创建时间',
   update_dt            datetime comment '应用修改时间',
   primary key (app_key)
);

alter table open_app_info comment '应用基本信息表';

/*==============================================================*/
/* Table: open_interface_info                                   */
/*==============================================================*/
create table open_interface_info
(
   interface_id         char(32) not null comment '接口ID',
   interface_name       varchar(30) comment '接口名称',
   interface_service    varchar(20) comment '接口对应的服务名称',
   interface_code       varchar(20) comment '接口代码',
   is_authorize         char(1) comment '是否需要用户授权：0不需要1需要',
   is_del               char(1) comment '是否删除',
   update_dt            datetime comment '接口更新时间',
   primary key (interface_id)
);

alter table open_interface_info comment '接口基本信息表';

/*==============================================================*/
/* Table: open_interface_log                                    */
/*==============================================================*/
create table open_interface_log
(
   log_id               char(32) not null comment '日志ID',
   interface_code       varchar(20) not null comment '接口代码',
   access_type          char(1) comment '访问类型：0 APP_KEY调用，1 Token调用',
   access_dt            datetime comment '访问时间',
   primary key (log_id)
);

alter table open_interface_log comment '接口调用日志表';

/*==============================================================*/
/* Table: open_interface_right                                  */
/*==============================================================*/
create table open_interface_right
(
   object_id            varchar(32) not null comment '分别表示应用、角色或者Token拥有该接口的访问权限',
   interface_id         char(32) not null comment '接口ID',
   volume               int comment '接口最大日访问量',
   right_type           char(1) comment '权限类型：1应用2角色3Token',
   expire_time          datetime default NULL comment 'Token访问类型过期时间，如果为空永不过期',
   update_dt            datetime comment '更新时间',
   primary key (interface_id, object_id)
);

alter table open_interface_right comment '接口权限表';

/*==============================================================*/
/* Table: open_interface_role_rel                               */
/*==============================================================*/
create table open_interface_role_rel
(
   app_key              int not null comment '应用ID',
   role_id              char(32) not null comment '角色ID',
   update_dt            datetime comment '更新时间',
   primary key (app_key, role_id)
);

alter table open_interface_role_rel comment '应用角色关系表';

/*==============================================================*/
/* Table: open_role                                             */
/*==============================================================*/
create table open_role
(
   role_id              char(32) not null comment '角色ID',
   role_name            varchar(20) comment '角色名称',
   role_des             varchar(50) comment '角色描述',
   update_dt            datetime comment '更新时间',
   primary key (role_id)
);

alter table open_role comment '角色表';

/*==============================================================*/
/* Table: open_user_token_rel                                   */
/*==============================================================*/
create table open_user_token_rel
(
   token_id             char(32) not null comment '访问ID',
   user_id              varchar(30) comment '用户ID',
   app_key              int comment '应用ID',
   expire_time          datetime default NULL comment '过期时间',
   update_dt            datetime comment '更新时间',
   primary key (token_id)
);

alter table open_user_token_rel comment '用户和授权关系表';

