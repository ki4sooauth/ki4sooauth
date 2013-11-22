drop table if exists area_para;

drop index device_assistant_mac on device_assistant;

drop table if exists device_assistant;

drop index device_transponder_mac on device_transponder;

drop table if exists device_transponder;

drop index device_wifisensor_mac on device_wifisensor;

drop table if exists device_wifisensor;

drop table if exists generatrix_info;

drop table if exists section_line_info;

drop table if exists service_tool_sort;

drop table if exists shop_authority;

drop table if exists shop_emailactive_code;

drop table if exists shop_entity_info;

drop table if exists shop_entity_link;

drop table if exists shop_gps_info;

drop table if exists shop_info;

drop table if exists shop_invoice_info;

drop table if exists shop_lid_detail;

drop table if exists shop_lid_info;

drop index position_name on shop_position;

drop table if exists shop_position;

drop table if exists shop_role;

drop table if exists shop_role2;

drop table if exists shop_role_authority;

drop table if exists shop_role_authority2;

drop table if exists shop_table_info;

drop table if exists shop_table_type_manage;

drop table if exists shop_tool_list;

drop table if exists shop_user_info;

drop table if exists shop_user_role;

drop table if exists shop_user_role2;

drop index shop_wifiinfo_mac on shop_wifiinfo;

drop table if exists shop_wifiinfo;

/*==============================================================*/
/* Table: area_para                                             */
/*==============================================================*/
create table area_para
(
   map_id               char(32) not null comment '地图编号',
   map_name             char(50) not null comment '地图名称',
   shop_id              char(32) not null comment '商家编号',
   position_id          char(32) not null comment '位置编号，描述该地图对应哪个区域',
   shop_entity_id       char(32) not null comment '实体店编号',
   url_html             char(255) not null comment '地图URL（html）（压缩文件）（给用户展示）',
   url_svg              char(255) not null comment '地图URL（svg）（用于修改）',
   grid_info            char(255) comment '网格信息URL（压缩文件）（用于定位）',
   is_park              char(1) not null comment '是否可停车，Y-可停车，N-不能停车',
   map_real_width       int not null comment '地图真实宽度，单位：毫米',
   map_real_height      int not null comment '地图真实高度，单位：毫米',
   ratio_location       double not null comment '定位坐标系比例，每单位表示的真实距离，单位：毫米',
   ratio_grid           double not null comment '网格坐标系比例，每单位表示的真实距离，单位：毫米',
   ratio_svg            double not null comment 'SVG坐标系比例，每单位表示的真实距离，单位：毫米',
   note                 varchar(500) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (map_id)
);

alter table area_para comment '区域地图参数';

/*==============================================================*/
/* Table: device_assistant                                      */
/*==============================================================*/
create table device_assistant
(
   device_assistant_id  char(32) not null comment '店员助理设备编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   device_mac           char(20) not null comment 'MAC地址',
   device_type          char(20) not null comment '店员助理设备型号，参考通用字典表的a_device_type。分为0-普通型，1-精简型',
   device_sn            char(50) not null comment '设备序列号',
   install_date         datetime not null comment '安装日期',
   status               char(1) not null comment '设备状态，参考通用字典表的device_status。分为0-在用，1-停用，2-损坏',
   note                 char(50) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (device_assistant_id)
);

alter table device_assistant comment '商家店员助理设备表';

/*==============================================================*/
/* Index: device_assistant_mac                                  */
/*==============================================================*/
create unique index device_assistant_mac on device_assistant
(
   device_mac
);

/*==============================================================*/
/* Table: device_transponder                                    */
/*==============================================================*/
create table device_transponder
(
   device_transponder_id char(32) not null comment '转发器设备编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   device_mac           char(20) not null comment 'MAC地址',
   device_type          char(20) not null comment '转发器设备型号，参考通用字典表的s_device_status',
   device_sn            char(50) not null comment '设备序列号',
   install_date         datetime not null comment '安装日期',
   status               char(1) not null comment '设备状态，参考通用字典表的device_status。分为0-在用，1-停用，2-损坏',
   note                 char(50) comment '备注',
   system_type          char(1) not null comment '对应的操作系统，0-dos，1-windows，2-linux',
   bill_parse           char(2) not null comment '对应的解析格式，参考字典表',
   st_service           char(255) not null comment '对应的功能，参考字典表',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (device_transponder_id)
);

alter table device_transponder comment '商家转发器设备表';

/*==============================================================*/
/* Index: device_transponder_mac                                */
/*==============================================================*/
create unique index device_transponder_mac on device_transponder
(
   device_mac
);

/*==============================================================*/
/* Table: device_wifisensor                                     */
/*==============================================================*/
create table device_wifisensor
(
   device_wifisensor_id char(32) not null comment 'wifi设备编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   device_mac           char(20) not null comment 'MAC地址',
   device_type          char(20) not null comment 'wifisensor设备型号，参考通用字典表的w_device_status',
   device_sn            char(50) not null comment '设备序列号',
   install_date         datetime not null comment '安装日期',
   status               char(1) not null comment '设备状态，参考通用字典表的device_status。分为0-在用，1-停用，2-损坏',
   position_id          char(32) comment '位置编号，描述在实体店中所处的位置',
   position_name        char(32) comment '位置名称，描述在实体店中所处的位置',
   note                 char(50) comment '备注',
   px                   double(10,2) comment 'x轴坐标（位置引擎中的坐标）',
   py                   double(10,2) comment 'y轴坐标（位置引擎中的坐标）',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (device_wifisensor_id)
);

alter table device_wifisensor comment '商家wifisensor设备表';

/*==============================================================*/
/* Index: device_wifisensor_mac                                 */
/*==============================================================*/
create unique index device_wifisensor_mac on device_wifisensor
(
   device_mac
);

/*==============================================================*/
/* Table: generatrix_info                                       */
/*==============================================================*/
create table generatrix_info
(
   generatrix_id        char(32) not null comment '动线编号',
   map_id               char(32) not null comment '所属地图编号',
   generatrix_type      char(1) not null comment '动线类型',
   svg_tag_id           char(100) not null comment 'svg图上的标签id值',
   svg_tag_code         varchar(2000) not null comment 'svg图上的标签代码',
   create_time          datetime not null comment '创建时间',
   primary key (generatrix_id)
);

alter table generatrix_info comment '动线信息';

/*==============================================================*/
/* Table: section_line_info                                     */
/*==============================================================*/
create table section_line_info
(
   line_id              char(32) not null comment '路线编号',
   map_id               char(32) not null comment '所属地图编号',
   svg_tag_code         varchar(2000) not null comment 'svg图上的标签代码',
   weight               int not null comment '权重',
   length               double(10,2) not null comment '路线的长度',
   first_point_x        double(10,2) not null comment '路线第一个点的x坐标',
   first_point_y        double(10,2) not null comment '路线第一个点的y坐标',
   second_point_x       double(10,2) not null comment '路线第二个点的x坐标',
   second_point_y       double(10,2) not null comment '路线第二个点的y坐标',
   create_time          datetime not null comment '创建时间',
   primary key (line_id)
);

alter table section_line_info comment '分段线路信息--导航时需要';

/*==============================================================*/
/* Table: service_tool_sort                                     */
/*==============================================================*/
create table service_tool_sort
(
   id                   char(32) not null comment '自动编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   tool_id              char(32) not null comment '服务工具编号',
   tool_type            char(32) not null comment '分类，0-服务工具，1-栏目',
   order_no             int not null comment '排序编号',
   create_time          datetime not null comment '创建时间',
   primary key (id)
);

alter table service_tool_sort comment '服务工具排序';

/*==============================================================*/
/* Table: shop_authority                                        */
/*==============================================================*/
create table shop_authority
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

alter table shop_authority comment '权限表，由数据库管理员维护，只有在新增功能时才有可能变动';

/*==============================================================*/
/* Table: shop_emailactive_code                                 */
/*==============================================================*/
create table shop_emailactive_code
(
   id                   char(32) not null comment '编号，唯一，通过UUID产生',
   shop_id              char(32) not null comment '商家编号',
   exp_date             datetime not null comment '激活码过期时间，为创建时间的两天之内',
   is_active            char(1) not null comment '是否激活：Y-已激活，N-未激活',
   active_date          datetime comment '激活时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table shop_emailactive_code comment '邮箱激活码，仅在找回密码时使用';

/*==============================================================*/
/* Table: shop_entity_info                                      */
/*==============================================================*/
create table shop_entity_info
(
   shop_entity_id       char(32) not null comment '实体店编号',
   shop_entity_name     char(50) not null comment '实体店名称',
   is_general           char(1) not null comment '是否为总店，每个商家只允许有一家总店，Y-是，N-否',
   shop_id              char(32) not null comment '商家编号',
   trade_area_id        char(32) comment '所属商圈',
   registered_number    varchar(100) comment '工商注册号，即营业执照的注册号',
   classification_code  varchar(100) comment '行业类别代码，即国民经济行业分类代码',
   organization_code    varchar(100) comment '组织机构代码',
   enterprise_name      varchar(100) comment '企业全称',
   registered_city      varchar(10) comment '注册城市，关联user_cityarea',
   corporate            varchar(50) comment '法人代表',
   registered_capital   varchar(50) comment '注册资本',
   busniss_aloted_start_time datetime comment '营业期限开始时间',
   busniss_aloted_end_time datetime comment '营业期限终止时间',
   business_license     varchar(255) comment '营业执照URL',
   invoice_expire       int comment '拿到小票后开发票的截止天数',
   open_time            varchar(50) comment '营业开门时间',
   close_time           varchar(50) comment '营业关门时间',
   shop_road_guide      text comment '交通指南',
   introduction         text comment '店铺介绍',
   promptinfo           text comment '消费提示',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shop_entity_id)
);

alter table shop_entity_info comment '实体店基本信息';

/*==============================================================*/
/* Table: shop_entity_link                                      */
/*==============================================================*/
create table shop_entity_link
(
   shop_entity_id       char(32) not null comment '实体店编号',
   shop_id              char(32) not null comment '商家编号',
   mobile               char(11) comment '手机号码',
   phone                char(20) comment '联系电话',
   post_code            char(10) comment '邮政编码',
   province             char(10) comment '省',
   city                 char(10) comment '市',
   area                 char(10) comment '区县',
   address              char(255) comment '详细地址',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shop_entity_id)
);

alter table shop_entity_link comment '实体店联系方式';

/*==============================================================*/
/* Table: shop_gps_info                                         */
/*==============================================================*/
create table shop_gps_info
(
   shop_entity_id       char(32) not null comment '实体店编号',
   shop_id              char(32) not null comment '商家编号',
   shop_gps_baidux      char(20) comment 'GPS百度的X坐标',
   shop_gps_baiduy      char(20) comment 'GPS百度的Y坐标',
   shop_gps_googlex     char(20) comment 'GPS Google的X坐标',
   shop_gps_googley     char(20) comment 'GPS Google的Y坐标',
   note                 char(50) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shop_entity_id)
);

alter table shop_gps_info comment '实体店GPS信息表';

/*==============================================================*/
/* Table: shop_info                                             */
/*==============================================================*/
create table shop_info
(
   shop_id              char(32) not null comment '商家编号，唯一，通过UUID产生',
   email                char(50) not null comment '电子邮箱，唯一，字母、数字、下划线、@组成',
   nick_name            char(50) not null comment '昵称，默认为电子邮箱@之前的部分',
   shop_status          char(1) not null comment '商家状态，参考通用字典表的shop_status    L-锁定，P-待营业，U-正常营业，默认为锁定，审批通过之后为待营业，商家确认之后为正常营业。锁定和待营业期间商家可以使用部分功能，正常营业之后需要删除所有的测试信息（商家可选是否删除），只有商家帐号才能点击"正常营业"',
   is_chain             char(1) not null comment '是否连锁，Y-连锁，N-非连锁',
   service_style        char(1) not null comment '部署模式，参考通用字典表的service_style',
   shop_name            char(50) not null comment '商家名称',
   shop_type_root       int not null comment '商家类型（根节点）',
   shop_type_leaf       int not null comment '商家类型（叶节点）',
   logo1                char(255) not null comment '商家logo1，正方形',
   logo2                char(255) not null comment '商家logo2，长方形',
   logo3                char(255) not null comment '商家logo3，备用',
   scope                char(255) comment '营业范围',
   note                 char(255) comment '审核备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shop_id)
);

alter table shop_info comment '商家信息';

/*==============================================================*/
/* Table: shop_invoice_info                                     */
/*==============================================================*/
create table shop_invoice_info
(
   shop_entity_id       char(32) not null comment '实体店编号',
   name1                varchar(1000) comment '个人发票项目名称，多个，json串保存',
   name2                varchar(1000) comment '公司发票项目名称，多个，json串保存',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shop_entity_id)
);

alter table shop_invoice_info comment '实体店开发票项目';

/*==============================================================*/
/* Table: shop_lid_detail                                       */
/*==============================================================*/
create table shop_lid_detail
(
   lid                  char(8) not null comment 'LID',
   lid_base             char(6) not null comment 'LID基本信息',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   position_id          char(32) comment '位置编号，描述LID在实体店中所处的位置',
   position_name        char(32) comment '位置名称，描述LID在实体店中所处的位置',
   status               char(1) not null comment '是否使用：Y-正在使用，N-未使用，S-停用，D-损坏',
   px                   double(10,2) comment 'x轴坐标（位置引擎中的坐标）',
   py                   double(10,2) comment 'y轴坐标（位置引擎中的坐标）',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (lid)
);

alter table shop_lid_detail comment '商家LID详细分配信息';

/*==============================================================*/
/* Table: shop_lid_info                                         */
/*==============================================================*/
create table shop_lid_info
(
   lid_base             char(6) not null comment 'LID基本信息，完整LID的前6位表示商家或实体店，此处只保存完整LID的前6位',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号，每个实体店至少独享一个LID',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (lid_base)
);

alter table shop_lid_info comment '商家LID基本信息';

/*==============================================================*/
/* Table: shop_position                                         */
/*==============================================================*/
create table shop_position
(
   position_id          char(32) not null comment '位置编号，唯一，通过UUID产生',
   position_name        char(32) not null comment '位置名称',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   parentPosition_id    char(32) not null comment '父位置编号',
   description          char(255) comment '位置描述',
   lessee_shop_id       char(32) comment '承租商家编号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (position_id)
);

alter table shop_position comment '位置管理表';

/*==============================================================*/
/* Index: position_name                                         */
/*==============================================================*/
create index position_name on shop_position
(
   position_name
);

/*==============================================================*/
/* Table: shop_role                                             */
/*==============================================================*/
create table shop_role
(
   role_id              char(32) not null comment '角色编号，唯一，通过UUID产生',
   role_name            char(32) not null comment '角色名称',
   shop_id              char(32) not null comment '商家编号',
   note                 char(100) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (role_id)
);

alter table shop_role comment '用户角色表';

/*==============================================================*/
/* Table: shop_role2                                            */
/*==============================================================*/
create table shop_role2
(
   role_id              char(32) not null comment '角色编号，唯一，通过UUID产生',
   role_name            char(32) not null comment '角色名称',
   note                 char(100) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (role_id)
);

alter table shop_role2 comment '角色表';

/*==============================================================*/
/* Table: shop_role_authority                                   */
/*==============================================================*/
create table shop_role_authority
(
   sys_role_authority_id char(32) not null comment '自动编号，唯一，通过UUID产生',
   role_id              char(32) not null comment '角色ID',
   authority_id         char(10) not null comment '权限ID',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (sys_role_authority_id)
);

alter table shop_role_authority comment '角色-权限关联';

/*==============================================================*/
/* Table: shop_role_authority2                                  */
/*==============================================================*/
create table shop_role_authority2
(
   id                   char(32) not null comment '自动编号，唯一，通过UUID产生',
   role_id              char(32) not null comment '角色ID',
   authority_id         char(10) not null comment '权限ID',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table shop_role_authority2 comment '角色-权限关联';

/*==============================================================*/
/* Table: shop_table_info                                       */
/*==============================================================*/
create table shop_table_info
(
   id                   char(32) not null comment '自动编号',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   table_name           char(20) not null comment '餐桌名称：可由字母、数字、文字组成，同一实体店内不能重复，需与餐饮软件中保持一致',
   room_name            char(20) comment '包间名称：可由字母、数字、文字组成，同一实体店内不能重复，需与餐饮软件中保持一致',
   remark               char(50) comment '备用',
   table_type_code      char(32) not null comment '餐桌类型编码',
   status               char(1) not null comment '餐桌状态，参考通用字典表的desk_status，默认为1（空闲）',
   mac                  char(20) comment '所属转发器mac地址',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table shop_table_info comment '餐厅桌号信息表';

/*==============================================================*/
/* Table: shop_table_type_manage                                */
/*==============================================================*/
create table shop_table_type_manage
(
   table_type_code      char(32) not null comment '餐桌类型编码，UUID',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   min_nums             int not null comment '建议最小人数',
   max_nums             int not null comment '建议最大人数',
   table_type_name      char(32) not null comment '餐桌类型名称，如8人桌',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (table_type_code)
);

alter table shop_table_type_manage comment '餐桌类型管理';

/*==============================================================*/
/* Table: shop_tool_list                                        */
/*==============================================================*/
create table shop_tool_list
(
   id                   char(32) not null comment '自动编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   tool_id              char(32) not null comment '服务工具编号',
   tool_name            char(32) not null comment '服务工具名称',
   tool_url             varchar(255) comment '工具介绍URL',
   tool_ico_focus       varchar(255) comment '工具图标（选中）',
   tool_ico_unfocus     varchar(255) comment '工具图标（非选中状态）',
   tool_type            char(1) not null comment '服务工具类型，参考通用字典表的tool_type',
   status               char(1) not null comment '状态（服务工具），参考通用字典表的tool_status',
   local_cmd            varchar(50) comment '手机本地命令',
   ver                  varchar(10) comment '版本，不同版本对应不同的工具信息类型
            ',
   remark               varchar(255) comment '备注',
   authority            varchar(320) comment '权限设置，对应会员卡类别，以逗号分隔，如为空，则表示所有会员都可使用',
   order_no             int comment '排序编号',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table shop_tool_list comment '商家申请的服务工具';

/*==============================================================*/
/* Table: shop_user_info                                        */
/*==============================================================*/
create table shop_user_info
(
   user_id              char(50) not null comment '用户电子邮箱，由数字、字母、下划线、@组成',
   shop_id              char(32) not null comment '所属商家',
   is_shop_account      char(1) not null comment '是否为商家帐号，Y-是，N-否（商家帐号只有一个，并且是不可删除、修改的）',
   password             char(32) not null comment '密码，MD5加密',
   status               char(1) not null comment '状态0-锁定，1-正常（如果是商家帐号，则需要与商家状态保持一致）',
   name                 char(50) not null comment '姓名',
   sex                  char(1) not null comment '性别 M-男 F-女',
   birthday             date not null comment '出生日期',
   id_type              char(2) not null comment '证件类型',
   id_no                char(50) not null comment '证件号码',
   shop_entity_id       char(32) comment '所属实体店，为空表示所有实体店',
   brand                char(32) comment '所属品牌，为空表示所有品牌',
   head_img             char(255) not null comment '用户头像',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (user_id)
);

alter table shop_user_info comment '商家营销中心用户信息表';

/*==============================================================*/
/* Table: shop_user_role                                        */
/*==============================================================*/
create table shop_user_role
(
   sys_user_role_id     char(32) not null comment '自动编号，唯一，通过UUID产生',
   user_id              char(50) not null comment '用户ID',
   role_id              char(32) not null comment '角色ID',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (sys_user_role_id)
);

alter table shop_user_role comment '用户-角色关联';

/*==============================================================*/
/* Table: shop_user_role2                                       */
/*==============================================================*/
create table shop_user_role2
(
   shop_id              char(32) not null comment '商家编号',
   role_id              char(32) not null comment '角色ID',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shop_id)
);

alter table shop_user_role2 comment '用户-角色关联';

/*==============================================================*/
/* Table: shop_wifiinfo                                         */
/*==============================================================*/
create table shop_wifiinfo
(
   wifi_info_id         char(32) not null comment 'wifi编号，唯一，通过UUID产生',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   wifi_ssid            char(32) not null comment 'wifi的名称',
   wifi_mac             char(20) not null comment 'wifi的mac地址',
   wifi_password        char(30) comment 'wifi的口令，md5加密',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (wifi_info_id)
);

alter table shop_wifiinfo comment '实体店Wifi信息配置表，每个实体店可以配置多个wifi';

/*==============================================================*/
/* Index: shop_wifiinfo_mac                                     */
/*==============================================================*/
create unique index shop_wifiinfo_mac on shop_wifiinfo
(
   wifi_mac
);

alter table area_para add constraint FK_Reference_22 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table area_para add constraint FK_Reference_23 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table device_assistant add constraint FK_Reference_34 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table device_assistant add constraint FK_Reference_42 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table device_transponder add constraint FK_Reference_36 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table device_transponder add constraint FK_Reference_43 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table device_wifisensor add constraint FK_Reference_35 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table device_wifisensor add constraint FK_Reference_44 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table generatrix_info add constraint FK_Reference_10 foreign key (map_id)
      references area_para (map_id) on delete restrict on update restrict;

alter table section_line_info add constraint FK_Reference_11 foreign key (map_id)
      references area_para (map_id) on delete restrict on update restrict;

alter table shop_emailactive_code add constraint FK_Reference_15 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_entity_info add constraint FK_Reference_14 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_entity_link add constraint FK_Reference_17 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_entity_link add constraint FK_Reference_18 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table shop_gps_info add constraint FK_Reference_16 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_gps_info add constraint FK_Reference_21 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table shop_invoice_info add constraint FK_Reference_20 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table shop_lid_detail add constraint FK_Reference_3 foreign key (position_id)
      references shop_position (position_id) on delete restrict on update restrict;

alter table shop_lid_detail add constraint FK_Reference_38 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_lid_detail add constraint FK_Reference_4 foreign key (position_name)
      references shop_position (position_name) on delete restrict on update cascade;

alter table shop_lid_detail add constraint FK_Reference_46 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table shop_lid_detail add constraint FK_Reference_6 foreign key (lid_base)
      references shop_lid_info (lid_base) on delete restrict on update restrict;

alter table shop_lid_info add constraint FK_Reference_37 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_lid_info add constraint FK_Reference_45 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table shop_position add constraint FK_Reference_24 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_position add constraint FK_Reference_25 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table shop_position add constraint FK_Reference_26 foreign key (lessee_shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_role add constraint FK_Reference_29 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_role_authority add constraint FK_Reference_30 foreign key (role_id)
      references shop_role (role_id) on delete restrict on update restrict;

alter table shop_role_authority add constraint FK_Reference_31 foreign key (authority_id)
      references shop_authority (authority_id) on delete restrict on update restrict;

alter table shop_role_authority2 add constraint FK_Reference_51 foreign key (role_id)
      references shop_role2 (role_id) on delete restrict on update restrict;

alter table shop_role_authority2 add constraint FK_Reference_52 foreign key (authority_id)
      references shop_authority (authority_id) on delete restrict on update restrict;

alter table shop_table_info add constraint FK_Reference_1 foreign key (table_type_code)
      references shop_table_type_manage (table_type_code) on delete restrict on update restrict;

alter table shop_table_info add constraint FK_Reference_2 foreign key (mac)
      references device_transponder (device_mac) on delete restrict on update restrict;

alter table shop_table_info add constraint FK_Reference_40 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_table_info add constraint FK_Reference_48 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table shop_table_type_manage add constraint FK_Reference_39 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_table_type_manage add constraint FK_Reference_47 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;

alter table shop_tool_list add constraint FK_Reference_27 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_user_info add constraint FK_Reference_28 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_user_role add constraint FK_Reference_32 foreign key (user_id)
      references shop_user_info (user_id) on delete restrict on update restrict;

alter table shop_user_role add constraint FK_Reference_33 foreign key (role_id)
      references shop_role (role_id) on delete restrict on update restrict;

alter table shop_user_role2 add constraint FK_Reference_50 foreign key (role_id)
      references shop_role2 (role_id) on delete restrict on update restrict;

alter table shop_user_role2 add constraint FK_Reference_54 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_wifiinfo add constraint FK_Reference_41 foreign key (shop_id)
      references shop_info (shop_id) on delete restrict on update restrict;

alter table shop_wifiinfo add constraint FK_Reference_49 foreign key (shop_entity_id)
      references shop_entity_info (shop_entity_id) on delete restrict on update restrict;
