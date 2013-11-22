DELETE from gooagoo_base.sys_config;
#gmsConfigCache
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('server_code_url','http://code.gooagoo.com/code.do','二维码服务器访问地址','gms',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('statistics_file_url_head','http://statistics.gooagoo.com','统计数据文件访问地址头部','gms',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('html_url_head','http://html.gooagoo.com','静态文件访问地址头部','gms',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('img_url_head','http://img.gooagoo.com','图片访问地址头部','gms',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('no_auth_redirect_url','','无权限时系统默认跳转页','gms',CURRENT_TIMESTAMP());

INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('mobile_tool_channel_relation','{\"1\":\"20,21\",\"3\":\"12,13,14,15,16\",\"6\":\"17,18,19\"}','服务工具与手机服务渠道编码关联配置信息','gms',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('server_shop_logout_url','http://passport.gooagoo.com/shopLogout','商家退出登录访问地址','gms',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('server_mis_logout_url','http://passport.gooagoo.com/misLogout','mis用户退出登录访问地址','gms',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('server_mis_url','http://mis.gooagoo.com/index','mis系统访问地址','gms',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('shop_log_filter_behave_type','L','商家需要过滤的消息行为类型，多个逗号分隔','gms',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('generatrix_svg_property','#FF33FF','动线在SVG图中标识属性值','gms',CURRENT_TIMESTAMP());

#uploadConfigCache
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('fileupload.server.url','http://upload.goo.com/upload.do','文件上传服务请求地址','upload',CURRENT_TIMESTAMP());


#passportConfigCache
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('verifyTimeOut','120','验证码超时时间','passport',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('userTimeOut','1800','个人用户登录超时时间','passport',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('shopTimeOut','1800','商家用户登录超时时间','passport',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('misTimeOut','1800','MIS用户登录超时时间','passport',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('userDefaultPage','http://www.gooagoo.com/ucryout/index','个人用户登录成功默认跳转页面','passport',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('shopDefaultPage','http://marketing.gooagoo.com/gshopinfo','商家用户登录成功默认跳转页面','passport',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('misDefaultPage','http://mis.gooagoo.com/index','MIS用户登录成功默认跳转页面','passport',CURRENT_TIMESTAMP());



INSERT INTO gooagoo_base.sys_config (config_key,config_value,note,sys_type,c_time_stamp) VALUES ( 'usercenterdomain', 'http://www.gooagoo.com', '个人消费中心域名', 'gus', SYSDATE());
INSERT INTO gooagoo_base.sys_config (config_key,config_value,note,sys_type,c_time_stamp) VALUES ( 'passportdomain', 'http://passport.gooagoo.com', '身份验证系统域名', 'gus', SYSDATE());
INSERT INTO gooagoo_base.sys_config (config_key,config_value,note,sys_type,c_time_stamp) VALUES ( 'usertempdomain', 'http://user.temp.gooagoo.com', '个人模板系统域名', 'gus', SYSDATE());
INSERT INTO gooagoo_base.sys_config (config_key,config_value,note,sys_type,c_time_stamp) VALUES ( 'htmldomain', 'http://html.gooagoo.com', '静态资源域名', 'gus', SYSDATE());
#gusConfigCache
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('mobile_base_url','http://3g.gooagoo.com/mm/','手机虚拟商家基址','gus',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('web_base_url','http://merchant.gooagoo.com/wm/','网站虚拟商家基址','gus',CURRENT_TIMESTAMP());

#misConfigCache
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('activemq_address','192.168.3.225;192.168.3.226;192.168.3.227;192.168.3.228;192.168.3.229','activemq服务器地址','mis',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('html_url','http://html.gooagoo.com','静态资源访问地址头','mis',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('passport_url','http://passport.gooagoo.com','身份验证系统域名','mis',CURRENT_TIMESTAMP());
INSERT INTO gooagoo_base.sys_config(config_key,config_value,note,sys_type,c_time_stamp) VALUES ('ajax_url','http://ajax.gooagoo.com','ajax访问域名','mis',CURRENT_TIMESTAMP());