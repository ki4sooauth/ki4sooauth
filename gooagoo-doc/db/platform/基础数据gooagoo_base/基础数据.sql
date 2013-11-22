drop table if exists email_config;

drop table if exists marketing_channel;

drop table if exists prompting_message;

drop table if exists quality_square_goods_type;

drop table if exists shop_interface_name;

drop index shop_tool_name on shop_tool_info;

drop table if exists shop_tool_info;

drop table if exists shop_type;

drop table if exists shopping_list_goods_type;

drop table if exists sys_config;

drop table if exists sys_dictionary;

drop table if exists user_cityarea;

/*==============================================================*/
/* Table: email_config                                          */
/*==============================================================*/
create table email_config
(
   email_id             char(32) not null comment '邮件编码，参考字典表的邮件模板类型',
   content              text not null comment '邮件内容',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (email_id)
);

alter table email_config comment '邮件内容配置';

/*==============================================================*/
/* Table: marketing_channel                                     */
/*==============================================================*/
create table marketing_channel
(
   channel_code         int not null comment '营销渠道编码',
   channel_name         char(32) not null comment '营销渠道名称',
   parent_channel_code  int not null comment '父级编码',
   sort_order           int not null comment '排序号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (channel_code)
);

alter table marketing_channel comment '营销渠道';

/*==============================================================*/
/* Table: prompting_message                                     */
/*==============================================================*/
create table prompting_message
(
   message_id           char(32) not null comment '提示信息编码',
   content              char(255) not null comment '提示信息内容',
   sys                  national char(20) not null comment '所属系统（中文）',
   func                 char(20) not null comment '所属功能（中文）',
   note                 char(50) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (message_id)
);

alter table prompting_message comment '提示信息字典表';

/*==============================================================*/
/* Table: quality_square_goods_type                             */
/*==============================================================*/
create table quality_square_goods_type
(
   goods_type_id        int not null auto_increment comment '商品类型编号，自增长',
   goods_type_name      national char(50) not null comment '商品类型名称',
   parent_goods_type_id int not null comment '上级类型编号，-1表示无上级',
   front_pic            char(255) not null comment '点击前图片',
   back_pic             national char(255) not null comment '点击后图片',
   sort_order           int not null comment '排序号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (goods_type_id)
);

alter table quality_square_goods_type comment '精品广场商品类型字典表';

/*==============================================================*/
/* Table: shop_interface_name                                   */
/*==============================================================*/
create table shop_interface_name
(
   id                   char(32) not null comment '自动编号，UUID',
   name_code            varchar(100) not null comment '名称编码',
   name_value           varchar(1000) not null comment '名称值',
   sys                  varchar(100) not null comment '所属系统',
   module               varchar(100) not null comment '所属模块',
   note                 varchar(1000) comment '备注',
   version              varchar(10) not null comment '版本号',
   version_note         varchar(100) not null comment '版本号说明',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table shop_interface_name comment '商家平台界面名称管理';

/*==============================================================*/
/* Table: shop_tool_info                                        */
/*==============================================================*/
create table shop_tool_info
(
   tool_id              char(32) not null comment '服务工具编号',
   tool_name            char(32) not null comment '服务工具名称',
   tool_url             char(255) comment '工具介绍URL',
   tool_ico_focus       char(255) not null comment '工具图标（选中）',
   tool_ico_unfocus     char(255) not null comment '工具图标（非选中状态）',
   tool_type            char(1) not null comment '服务工具类型，0-现场服务，1-远程服务',
   local_cmd            char(50) comment '手机本地命令',
   ver                  char(10) comment '版本，不同版本对应不同的工具信息类型
            ',
   remark               char(255) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (tool_id)
);

alter table shop_tool_info comment '商家服务工具字典表';

/*==============================================================*/
/* Index: shop_tool_name                                        */
/*==============================================================*/
create index shop_tool_name on shop_tool_info
(
   tool_name
);

/*==============================================================*/
/* Table: shop_type                                             */
/*==============================================================*/
create table shop_type
(
   shop_type_id         int not null comment '商家类型编号',
   shop_type_name       national char(50) not null comment '商家类型名称',
   parent_shop_type_id  int not null comment '上级类型编号，-1表示无上级',
   front_pic            char(255) not null comment '点击前图片',
   back_pic             national char(255) not null comment '点击后图片',
   sort_order           int not null comment '排序号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shop_type_id)
);

alter table shop_type comment '商家类型字典表';

/*==============================================================*/
/* Table: shopping_list_goods_type                              */
/*==============================================================*/
create table shopping_list_goods_type
(
   goods_type_id        int not null auto_increment comment '商品类型编号，自增长',
   goods_type_name      national char(50) not null comment '商品类型名称',
   parent_goods_type_id int not null comment '上级类型编号，-1表示无上级',
   front_pic            char(255) not null comment '点击前图片',
   back_pic             national char(255) not null comment '点击后图片',
   sort_order           int not null comment '排序号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (goods_type_id)
);

alter table shopping_list_goods_type comment '购物清单商品类型字典表';

/*==============================================================*/
/* Table: sys_config                                            */
/*==============================================================*/
create table sys_config
(
   id                   int not null auto_increment comment '自动编号，自增长',
   config_key           varchar(100) not null comment '配置信息key',
   config_value         national varchar(1000) not null comment '配置信息value',
   note                 varchar(1000) comment '备注',
   sys_type             varchar(50) not null comment '所属系统，gus、gms、mis、mobile、passport、upload',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table sys_config comment '系统配置信息';

/*==============================================================*/
/* Table: sys_dictionary                                        */
/*==============================================================*/
create table sys_dictionary
(
   sys_dictionary_id    int not null auto_increment comment '自动编号，自增长',
   dictionary_type      char(20) not null comment '字典类型编码，如sex',
   dictionary_name      char(20) not null comment '字典类型名称，如性别',
   english_name         char(20) not null comment '英文名称，如M',
   chinese_name         char(255) not null comment '中文名称，如男',
   note                 char(255) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (sys_dictionary_id)
);

alter table sys_dictionary comment '通用字典表，包括性别、证件类型、转发器型号、信息来源、行为类型';

/*==============================================================*/
/* Table: user_cityarea                                         */
/*==============================================================*/
create table user_cityarea
(
   id                   int not null auto_increment comment '自动编号，自增长',
   city_id              char(10) not null comment '省市区编码',
   city_name            national char(50) not null comment '省市区名称',
   parent_city_id       char(10) not null comment '上级编码',
   parent_city_name     national char(50) not null comment '上级名称',
   level_code           national char(1) not null comment '省市区级别：P-省，C-市，D-区',
   sort_order           int not null comment '排序',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table user_cityarea comment '省份城市字典表';
