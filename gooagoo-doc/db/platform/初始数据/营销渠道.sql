delete from gooagoo_base.marketing_channel;
INSERT INTO gooagoo_base.marketing_channel VALUES (1, '吆喝', -1, 1, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (2, '通知', -1, 2, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (3, '短信', -1, 3, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (4, '邮件', -1, 4, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (5, '购好奇', -1,5, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (6, '手机服务', -1, 6, 'N','2000-01-01 00:00:00','2000-01-01 00:00:00');

INSERT INTO gooagoo_base.marketing_channel VALUES (10, '刷卡', 6, 1, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (11, '滑动刷卡', 10, 1, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');

INSERT INTO gooagoo_base.marketing_channel VALUES (12, '点餐与结账', 6, 2, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (13, '查看菜谱', 12, 1, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (14, '查看菜单', 12, 2, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (15, '查看已点菜品', 12, 3, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (16, '申请结账', 12, 4, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');

INSERT INTO gooagoo_base.marketing_channel VALUES (17, '快速结账', 6, 3, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (18, '扫描商品', 17, 1, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (19, '查看购物车', 17, 2, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');

INSERT INTO gooagoo_base.marketing_channel VALUES (20, '购物匹配', 6, 4, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (21, '进入购物匹配', 20, 1, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');

INSERT INTO gooagoo_base.marketing_channel VALUES (22, '账单', 6, 5, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (23, '查看账单', 22, 1, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');
INSERT INTO gooagoo_base.marketing_channel VALUES (24, '申请开发票', 22, 3, 'N', '2000-01-01 00:00:00','2000-01-01 00:00:00');

COMMIT;