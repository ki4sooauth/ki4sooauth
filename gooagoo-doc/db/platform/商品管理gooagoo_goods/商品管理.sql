drop table if exists goods_base_info;

drop index brand_id_index on goods_brand;

drop table if exists goods_brand;

drop index category_id_index on goods_category;

drop table if exists goods_category;

drop index type_code_index on goods_feature;

drop index type_name_index on goods_feature;

drop table if exists goods_feature;

drop table if exists goods_feature_info;

drop table if exists goods_marketing_info;

/*==============================================================*/
/* Table: goods_base_info                                       */
/*==============================================================*/
create table goods_base_info
(
   goods_id             char(32) not null comment '商品编号，UUID',
   goods_name           char(32) not null comment '商品名称',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   goods_category_root  char(32) not null comment '品类编号（根节点）',
   goods_category_leaf  char(32) not null comment '品类编号（叶节点）',
   goods_brand          char(32) not null comment '品牌编号',
   goods_serial         char(32) not null comment '商品序列号（商品的唯一识别编码）',
   item_serial          char(32) not null comment '自定义序列号（商品细分的唯一识别编码）',
   price                double(10,2) not null comment '商品价格',
   template_id          char(32) comment '模板编号',
   template_data        longtext comment '模板数据，保存的是html代码',
   publish_status       char(1) not null comment '状态（审核与发布），参考通用字典表的publish_status',
   audit_note           char(100) comment '审核备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (goods_id)
);

alter table goods_base_info comment '商品基本信息';

/*==============================================================*/
/* Table: goods_brand                                           */
/*==============================================================*/
create table goods_brand
(
   id                   char(32) not null comment '自动编号，UUID',
   brand_id             char(32) not null comment '品牌编号',
   brand_name           char(32) not null comment '品牌名称',
   shop_id              char(32) not null comment '所属商家',
   shop_entity_id       char(32) not null comment '实体店编号',
   pic_url              char(255) comment '图片URL',
   sort                 int not null comment '排序',
   position_id          char(32) comment '位置编号，描述品牌在实体店中所处的位置',
   position_name        char(32) comment '位置名称，描述品牌在实体店中所处的位置',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table goods_brand comment '商家品牌信息，每个商家自行维护';

/*==============================================================*/
/* Index: brand_id_index                                        */
/*==============================================================*/
create index brand_id_index on goods_brand
(
   brand_id
);

/*==============================================================*/
/* Table: goods_category                                        */
/*==============================================================*/
create table goods_category
(
   id                   char(32) not null comment '自动编号，UUID',
   category_id          char(32) not null comment '品类编号',
   category_name        char(32) not null comment '品类名称',
   shop_id              char(32) not null comment '所属商家',
   shop_entity_id       char(32) not null comment '实体店编号',
   parent_category_id   char(32) not null comment '父品类编号，-1表示没有父品类',
   pic_url              char(255) comment '图片URL',
   sort                 int not null comment '排序',
   position_id          char(32) comment '位置编号，描述品类在实体店中所处的位置',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table goods_category comment '品类信息，每个商家自行维护';

/*==============================================================*/
/* Index: category_id_index                                     */
/*==============================================================*/
create index category_id_index on goods_category
(
   category_id
);

/*==============================================================*/
/* Table: goods_feature                                         */
/*==============================================================*/
create table goods_feature
(
   id                   char(32) not null comment '自动编号，UUID',
   shop_id              char(32) not null comment '商家编号',
   goods_serial         char(32) not null comment '商品序列号（商品的唯一识别编码）',
   type_code            char(32) not null comment '类型编号，例如color，同一商家唯一，由商家录入',
   type_name            char(32) not null comment '类型名称，例如颜色，同一商家唯一，由商家录入',
   enum_value           varchar(1000) not null comment '枚举值，保存的是json串，例如["黄色","蓝色","白色"]',
   is_display           char(1) not null comment '是否在界面展示，Y-是，N-否',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table goods_feature comment '商品特征字典表';

/*==============================================================*/
/* Index: type_name_index                                       */
/*==============================================================*/
create index type_name_index on goods_feature
(
   type_name
);

/*==============================================================*/
/* Index: type_code_index                                       */
/*==============================================================*/
create index type_code_index on goods_feature
(
   type_code
);

/*==============================================================*/
/* Table: goods_feature_info                                    */
/*==============================================================*/
create table goods_feature_info
(
   id                   char(32) not null comment '自动编号，UUID',
   goods_id             char(32) not null comment '商品编号',
   goods_name           char(32) not null comment '商品名称',
   shop_id              char(32) not null comment '商家编号',
   feature_code         char(32) not null comment '特征编码，如color',
   feature_name         char(32) not null comment '特征名称，如颜色',
   feature_value        char(32) not null comment '特征数值，如蓝色',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table goods_feature_info comment '商品特征信息';

/*==============================================================*/
/* Table: goods_marketing_info                                  */
/*==============================================================*/
create table goods_marketing_info
(
   goods_id             char(32) not null comment '商品编号',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   vendor               varchar(200) comment '供应商',
   position_id          char(32) comment '位置编号，描述商品在实体店中所处的位置',
   goods_content        text comment '商品推荐描述',
   goods_solution       text comment '商品解决方案描述',
   cross_goods          text comment '交叉销售商品，json串',
   relation_goods       text comment '关联销售商品，json串',
   replace_goods        text comment '可替换商品，json串',
   life_idea            varchar(32) comment '环保型，健康型，实惠型，品质型',
   use_type             varchar(32) comment '自用型，送礼型',
   feature              text comment '功能',
   address              varchar(1000) comment '产地',
   crowd                varchar(1000) comment '人群',
   use_message          text comment '使用方法',
   goods_img            text comment '商品图片URL，json串',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (goods_id)
);

alter table goods_marketing_info comment '商品营销信息';

alter table goods_base_info add constraint FK_Reference_2 foreign key (goods_category_root)
      references goods_category (category_id) on delete restrict on update restrict;

alter table goods_base_info add constraint FK_Reference_3 foreign key (goods_category_leaf)
      references goods_category (category_id) on delete restrict on update restrict;

alter table goods_base_info add constraint FK_Reference_4 foreign key (goods_brand)
      references goods_brand (brand_id) on delete restrict on update restrict;

alter table goods_feature_info add constraint FK_Reference_1 foreign key (feature_code)
      references goods_feature (type_code) on delete restrict on update restrict;

alter table goods_feature_info add constraint FK_Reference_6 foreign key (goods_id)
      references goods_base_info (goods_id) on delete restrict on update restrict;

alter table goods_feature_info add constraint FK_Reference_7 foreign key (feature_name)
      references goods_feature (type_name) on delete restrict on update cascade;

alter table goods_marketing_info add constraint FK_Reference_5 foreign key (goods_id)
      references goods_base_info (goods_id) on delete restrict on update restrict;
