drop table if exists bill_add_info;

drop table if exists bill_invoice_log;

drop table if exists bill_manual;

drop table if exists bill_pay_application;

drop table if exists order_coupon_info;

drop table if exists order_detail_info;

drop table if exists order_info;

drop table if exists order_pic;

drop table if exists original_bill_detail;

drop table if exists original_bill_info;

drop table if exists original_bill_pic;

drop table if exists shop_order_detail;

drop table if exists shop_order_info;

drop table if exists shop_order_pic;

drop table if exists shopping_cart;

drop table if exists user_order_coupon;

drop table if exists user_order_detail;

drop table if exists user_order_info;

/*==============================================================*/
/* Table: bill_add_info                                         */
/*==============================================================*/
create table bill_add_info
(
   order_detail_id      char(32) not null comment '订单明细编号',
   order_id             char(32) not null comment '订单编号',
   goods_id             char(32) not null comment '商品编号',
   goods_name           char(32) not null comment '商品名称',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   goods_category_root  char(32) comment '品类编号（根节点）',
   goods_category_leaf  char(32) comment '品类编号（叶节点）',
   goods_brand          char(32) comment '品牌编号',
   goods_serial         char(32) not null comment '商品序列号（商品的唯一识别编码）',
   item_serial          char(32) not null comment '自定义序列号（商品细分的唯一识别编码）',
   price                double(10,2) not null comment '商品价格',
   goods_img            national char(255) comment '商品主图地址',
   goods_num            int not null comment '商品数量',
   user_id              char(32) comment '提交者',
   type_deal            char(32) not null comment '类型，0-加菜，1-减菜',
   is_deal              char(1) not null comment '商家是否处理，Y-已处理，N未处理',
   deal_time            datetime comment '商家处理时间',
   note                 char(255) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (order_detail_id)
);

alter table bill_add_info comment '用户提交的加菜减菜申请（仅针对餐饮）';

/*==============================================================*/
/* Table: bill_invoice_log                                      */
/*==============================================================*/
create table bill_invoice_log
(
   order_id             char(32) not null comment '订单编号',
   user_id              char(32) not null comment '用户编号',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   invoiced_type        char(1) not null comment '发票类型，0-个人，1-公司',
   invoiced_tile        char(50) comment '发票抬头，发票类型为公司时必填',
   invoiced_price       double not null comment '发票金额，为订单对应的实际支付金额',
   invoiced_item        char(50) comment '开发票项目，如食品、礼品等，参考实体店的设定',
   invoiced_time        datetime comment '开发票时间',
   invoiced_request_time datetime not null comment '开发票申请时间',
   need_invoiced_detail char(1) not null default '0' comment '是否需要发票明细，Y-需要，N-不需要',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (order_id)
);

alter table bill_invoice_log comment '开发票申请信息';

/*==============================================================*/
/* Table: bill_manual                                           */
/*==============================================================*/
create table bill_manual
(
   bill_id              char(32) not null comment '账单编号',
   user_id              char(32) not null comment '用户编号',
   bill_no              char(32) not null comment '单号，填写订单或账单的编号',
   bill_type            char(32) comment '类别',
   fee                  double(10,2) not null comment '消费金额',
   request_time         datetime not null comment '消费时间',
   shop_name            char(32) comment '所属商家',
   note                 char(50) comment '备注',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (bill_id)
);

alter table bill_manual comment '通过网站手工添加的账单';

/*==============================================================*/
/* Table: bill_pay_application                                  */
/*==============================================================*/
create table bill_pay_application
(
   order_id             char(32) not null comment '订单编号，UUID',
   user_id              char(32) not null comment '用户编号',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   apply_time           datetime not null comment '申请结账时间',
   is_deal              char(1) not null comment '商家是否处理，Y-已处理，N未处理',
   deal_time            datetime comment '商家处理时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (order_id)
);

alter table bill_pay_application comment '手机端发起---后台---转发器---第三方系统';

/*==============================================================*/
/* Table: order_coupon_info                                     */
/*==============================================================*/
create table order_coupon_info
(
   order_detail_id      char(32) not null comment '订单明细编号，UUID',
   order_id             char(32) not null comment '订单编号',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   coupon_user_id       char(32) not null comment '优惠凭证收藏编号',
   user_id              char(32) comment '提交者',
   coupon_source        char(1) not null comment '优惠凭证来源，0-购阿购',
   status               char(1) comment '优惠凭证状态，0-不可用，1-等待商家处理，2-商家确认可使用，3-商家确认不可使用',
   is_deal              char(1) not null comment '商家是否处理，Y-已处理，N未处理',
   deal_time            datetime comment '商家处理时间',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (order_detail_id)
);

alter table order_coupon_info comment '订单优惠凭证详情，包括三种途径提交的优惠凭证：提交用户订单时、提交结账申请时、单独提出优惠凭证申请';

/*==============================================================*/
/* Table: order_detail_info                                     */
/*==============================================================*/
create table order_detail_info
(
   order_detail_id      char(32) not null comment '订单明细编号，UUID',
   order_id             char(32) not null comment '订单编号',
   goods_id             char(32) comment '商品编号',
   goods_name           char(32) not null comment '商品名称（来自账单文件）',
   shop_id              char(32) comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   goods_category_root  char(32) comment '品类编号（根节点）',
   goods_category_leaf  char(32) comment '品类编号（叶节点）',
   goods_brand          char(32) comment '品牌编号',
   goods_serial         char(32) comment '商品序列号（商品的唯一识别编码）',
   item_serial          char(32) comment '自定义序列号（商品细分的唯一识别编码）',
   price                double(10,2) comment '商品价格',
   goods_img            national char(255) comment '商品主图地址',
   pay_price            double(10,2) not null comment '实际支付单价（来自账单文件）',
   goods_num            int not null comment '商品数量（来自账单文件）',
   goods_weight         double(10,2) comment '商品重量（来自账单文件）',
   total_price          double(10,2) not null comment '实际支付总价=商品数量×实际支付单价',
   user_id              char(32) comment '提交者（只保留第一个提交此商品的人，后来提交的只做数量合并，不覆盖提交者）',
   avoid_item           char(32) comment '忌口',
   serve_num            int not null comment '上菜情况（仅针对餐饮），默认值为0',
   comment_id           char(32) comment '评论编号',
   primary key (order_detail_id)
);

alter table order_detail_info comment '订单商品详细信息';

/*==============================================================*/
/* Table: order_info                                            */
/*==============================================================*/
create table order_info
(
   order_id             char(32) not null comment '订单编号，UUID',
   bill_type            char(1) not null comment '订单状态，-1-远程提交，0-用户提交，1-商家处理，2-申请结账，3-已结账',
   shop_id              char(32) comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   user_id              char(32) comment '用户编号',
   mac                  national char(20) comment '商家硬件设备MAC地址',
   request_time         datetime comment '消费时间',
   third_order_id       national char(32) comment '第三方订单编号',
   scard_no             char(32) comment '会员卡号，16位音频卡号',
   goods_total_num      int default 1 comment '账单商品总数',
   original_price       double(10,2) comment '原价格',
   discount_rate        double(10,2) default 1.00 comment '折扣',
   pay_price            double(10,2) comment '实际支付价格',
   take_method          char(1) not null comment '提货方式，0-直接拿走、1-前台提货、2-送货上门',
   consignee_id         char(32) comment '收货人信息编号，关联收货人信息的主键',
   delivery_status      char(1) not null comment '取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物',
   room_name            char(32) comment '房间名称（仅针对餐饮）',
   desk_name            char(32) comment '桌子名称（仅针对餐饮）',
   is_sa_commit         char(1) not null comment '是否店员助理提交，Y-是，N-否',
   account              char(50) comment '店员助理登录帐号',
   user_order_time      datetime comment '用户订单提交时间',
   shop_order_time      datetime comment '商家订单提交时间（仅针对餐饮）',
   payment_application_time datetime comment '申请结账时间（仅针对餐饮）',
   payment_time         datetime comment '结账时间',
   invoice_application_time datetime comment '申请开发票时间',
   is_invoice           char(1) not null default '0' comment '是否开具发票，N-未开发票，Y-已开发票',
   invoice_time         datetime comment '开发票时间',
   invoice_latest_time  datetime comment '最晚开发票时间，为结账时间+最晚开发票天数',
   avoid_item           char(255) comment '整单忌口',
   dining_numbers       int comment '就餐人数',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (order_id)
);

alter table order_info comment '订单信息，记录用户订单、商家订单、账单、开发票的全程变化，对外服务的数据全都从这个表中获取。';

/*==============================================================*/
/* Table: order_pic                                             */
/*==============================================================*/
create table order_pic
(
   order_detail_id      char(32) not null comment '订单明细编号，UUID',
   order_id             char(32) not null comment '订单编号',
   pic_url              char(255) not null comment '图片地址',
   pic_type             char(1) not null comment '图片类型，0-订单图片，1-账单图片',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   primary key (order_detail_id)
);

alter table order_pic comment '订单图片详情';

/*==============================================================*/
/* Table: original_bill_detail                                  */
/*==============================================================*/
create table original_bill_detail
(
   bill_detail_id       char(32) not null comment '账单明细编号，UUID',
   bill_id              char(32) not null comment '账单编号',
   shop_id              char(32) comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   goods_id             char(32) comment '商品编号',
   goods_name           national char(50) comment '商品名称',
   goods_price          double(10,2) comment '商品单价',
   pay_price            double(10,2) comment '实际支付单价',
   goods_num            int comment '商品数量',
   total_price          double(10,2) comment '实际支付总价=商品数量×实际支付单价',
   primary key (bill_detail_id)
);

alter table original_bill_detail comment '原始账单商品详情';

/*==============================================================*/
/* Table: original_bill_info                                    */
/*==============================================================*/
create table original_bill_info
(
   bill_id              char(32) not null comment '账单编号，UUID',
   order_id             char(32) not null comment '统一订单编号，关联订单管理主表',
   shop_id              char(32) comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   user_id              char(32) comment '用户编号',
   mac                  national char(20) comment '商家硬件设备MAC地址',
   request_time         datetime comment '消费时间',
   third_order_id       national char(32) comment '第三方订单编号',
   scard_no             char(32) comment '会员卡号，16位音频卡号',
   goods_total_num      int default 1 comment '账单商品总数',
   original_price       double(10,2) comment '原价格',
   discount_rate        double(10,2) default 1.00 comment '折扣',
   pay_price            double(10,2) comment '实际支付价格',
   room_name            char(32) comment '房间名称（仅针对餐饮）',
   desk_name            char(32) comment '桌子名称（仅针对餐饮）',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (bill_id)
);

alter table original_bill_info comment '原始账单信息';

/*==============================================================*/
/* Table: original_bill_pic                                     */
/*==============================================================*/
create table original_bill_pic
(
   bill_detail_id       char(32) not null comment '账单明细编号，UUID',
   bill_id              char(32) not null comment '账单编号',
   pic_url              char(255) not null comment '账单图片地址',
   primary key (bill_detail_id)
);

alter table original_bill_pic comment '原始账单信息图片详情';

/*==============================================================*/
/* Table: shop_order_detail                                     */
/*==============================================================*/
create table shop_order_detail
(
   shop_order_detail_id char(32) not null comment '订单明细编号，UUID',
   shop_order_id        char(32) not null comment '商家订单编号',
   shop_id              char(32) comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   goods_id             char(32) comment '商品编号',
   goods_name           national char(50) comment '商品名称',
   goods_price          double(10,2) comment '商品单价',
   pay_price            double(10,2) comment '实际支付单价',
   goods_num            int comment '商品数量',
   total_price          double(10,2) comment '实际支付总价=商品数量×实际支付单价',
   primary key (shop_order_detail_id)
);

alter table shop_order_detail comment '商家订单原始信息商品详情';

/*==============================================================*/
/* Table: shop_order_info                                       */
/*==============================================================*/
create table shop_order_info
(
   shop_order_id        char(32) not null comment '商家订单编号，UUID',
   order_id             char(32) not null comment '统一订单编号，关联订单管理主表',
   shop_id              char(32) comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   user_id              char(32) comment '用户编号',
   mac                  national char(20) comment '商家硬件设备MAC地址',
   third_order_id       national char(32) comment '第三方订单编号',
   scard_no             char(32) comment '会员卡号，16位音频卡号',
   goods_total_num      int default 1 comment '订单商品总数',
   original_price       double(10,2) comment '原价格',
   discount_rate        double(10,2) default 1.00 comment '折扣',
   pay_price            double(10,2) comment '实际支付价格',
   room_name            char(32) comment '房间名称（仅针对餐饮）',
   desk_name            char(32) comment '桌子名称（仅针对餐饮）',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (shop_order_id)
);

alter table shop_order_info comment '商家订单原始信息。商家订单来源：转发器产生的订单文件。只有餐饮业才有商家订单。';

/*==============================================================*/
/* Table: shop_order_pic                                        */
/*==============================================================*/
create table shop_order_pic
(
   shop_order_detail_id char(32) not null comment '订单明细编号，UUID',
   shop_order_id        char(32) not null comment '商家订单编号',
   pic_url              char(255) not null comment '订单图片地址',
   primary key (shop_order_detail_id)
);

alter table shop_order_pic comment '商家订单原始信息图片详情';

/*==============================================================*/
/* Table: shopping_cart                                         */
/*==============================================================*/
create table shopping_cart
(
   id                   char(32) not null comment '自动编号，UUID',
   user_id              char(32) not null comment '用户编号',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) not null comment '实体店编号',
   goods_id             char(32) not null comment '商品编号',
   goods_name           char(32) comment '商品名称',
   goods_category_root  char(32) comment '品类编号（根节点）',
   goods_category_leaf  char(32) comment '品类编号（叶节点）',
   goods_brand          char(32) comment '品牌编号',
   goods_serial         char(32) comment '商品序列号（商品的唯一识别编码）',
   item_serial          char(32) comment '自定义序列号（商品细分的唯一识别编码）',
   price                double(10,2) comment '商品价格',
   goods_img            national char(255) comment '商品主图地址',
   goods_num            int not null comment '商品数量',
   is_del               char(1) not null comment '是否删除，Y-已删除，N-未删除',
   create_time          datetime not null comment '创建时间',
   c_time_stamp         timestamp not null comment '最后一次修改时间',
   primary key (id)
);

alter table shopping_cart comment '购物车';

/*==============================================================*/
/* Table: user_order_coupon                                     */
/*==============================================================*/
create table user_order_coupon
(
   user_order_detail_id char(32) not null comment '订单明细编号，UUID',
   user_order_id        char(32) not null comment '用户订单编号',
   shop_id              char(32) not null comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   coupon_user_id       char(32) not null comment '优惠凭证收藏编号',
   user_id              char(32) comment '提交者',
   coupon_source        char(1) not null comment '优惠凭证来源，0-购阿购',
   primary key (user_order_detail_id)
);

alter table user_order_coupon comment '用户订单原始信息优惠凭证详情';

/*==============================================================*/
/* Table: user_order_detail                                     */
/*==============================================================*/
create table user_order_detail
(
   user_order_detail_id char(32) not null comment '订单明细编号',
   user_order_id        char(32) not null comment '用户订单编号',
   shop_id              char(32) comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   goods_id             char(32) comment '商品编号',
   goods_name           national char(50) comment '商品名称',
   goods_price          double(10,2) comment '商品单价',
   pay_price            double(10,2) comment '实际支付单价',
   goods_num            int comment '商品数量',
   total_price          double(10,2) comment '实际支付总价=商品数量×实际支付单价',
   user_id              char(32) comment '提交者',
   primary key (user_order_detail_id)
);

alter table user_order_detail comment '用户订单原始信息商品详情';

/*==============================================================*/
/* Table: user_order_info                                       */
/*==============================================================*/
create table user_order_info
(
   user_order_id        char(32) not null comment '用户订单编号，UUID',
   order_id             char(32) not null comment '统一订单编号，关联订单管理主表',
   shop_id              char(32) comment '商家编号',
   shop_entity_id       char(32) comment '实体店编号',
   user_id              char(32) comment '用户编号',
   goods_total_num      int default 1 comment '订单商品总数',
   original_price       double(10,2) comment '原价格',
   discount_rate        double(10,2) default 1.00 comment '折扣',
   pay_price            double(10,2) comment '实际支付价格',
   take_method          char(1) comment '提货方式，0-直接拿走、1-前台提货、2-送货上门',
   consignee_id         char(32) comment '收货人信息编号，关联收货人信息的主键',
   room_name            char(32) comment '房间名称（仅针对餐饮）',
   desk_name            char(32) comment '桌子名称（仅针对餐饮）',
   is_sa_commit         char(1) not null comment '是否店员助理提交，Y-是，N-否',
   account              char(50) comment '店员助理登录帐号',
   create_time          datetime not null comment '创建时间',
   primary key (user_order_id)
);

alter table user_order_info comment '用户订单原始信息';

alter table bill_add_info add constraint FK_Reference_9 foreign key (order_id)
      references order_info (order_id) on delete restrict on update restrict;

alter table bill_invoice_log add constraint FK_Reference_13 foreign key (order_id)
      references order_info (order_id) on delete restrict on update restrict;

alter table bill_pay_application add constraint FK_Reference_12 foreign key (order_id)
      references order_info (order_id) on delete restrict on update restrict;

alter table order_coupon_info add constraint FK_Reference_10 foreign key (order_id)
      references order_info (order_id) on delete restrict on update restrict;

alter table order_detail_info add constraint FK_Reference_1 foreign key (order_id)
      references order_info (order_id) on delete restrict on update restrict;

alter table order_pic add constraint FK_Reference_11 foreign key (order_id)
      references order_info (order_id) on delete restrict on update restrict;

alter table original_bill_detail add constraint FK_Reference_8 foreign key (bill_id)
      references original_bill_info (bill_id) on delete restrict on update restrict;

alter table original_bill_pic add constraint FK_Reference_7 foreign key (bill_id)
      references original_bill_info (bill_id) on delete restrict on update restrict;

alter table shop_order_detail add constraint FK_Reference_5 foreign key (shop_order_id)
      references shop_order_info (shop_order_id) on delete restrict on update restrict;

alter table shop_order_pic add constraint FK_Reference_6 foreign key (shop_order_id)
      references shop_order_info (shop_order_id) on delete restrict on update restrict;

alter table user_order_coupon add constraint FK_Reference_4 foreign key (user_order_id)
      references user_order_info (user_order_id) on delete restrict on update restrict;

alter table user_order_detail add constraint FK_Reference_3 foreign key (user_order_id)
      references user_order_info (user_order_id) on delete restrict on update restrict;
