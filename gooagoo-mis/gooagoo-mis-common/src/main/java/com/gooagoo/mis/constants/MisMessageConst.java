package com.gooagoo.mis.constants;
/**
 * 后台管理系统-提示信息地址配置常量
 * @author Administrator
 *
 */
public final class MisMessageConst
{
    /**
     *系统级别提示信息(SYS)--START
     */

    /**
     *连接错误
     */
    public final static String SYS_CONNECT_ERROR = "S001";

    /**
     *请重试
     */
    public final static String SYS_TRY_AGAIN = "S002";

    /**
     *数据加载失败
     */
    public final static String SYS_LOAD_DATA_ERROR = "S003";

    /**
     *数据加载成功
     */
    public final static String SYS_LOAD_DATA_SUCCESS = "S004";

    /**
     *系统异常
     */
    public final static String SYS_SYSTEM_EXCEPTION = "S005";

    /**
     *未找到符合条件的信息
     */
    public final static String SYS_GET_WANT_DATA_FAIL = "S006";

    /**
     *添加成功
     */
    public final static String SYS_ADD_SUCCESS = "S007";

    /**
     *添加失败
     */
    public final static String SYS_ADD_FAIL = "S008";

    /**
     *修改成功
     */
    public final static String SYS_UPD_SUCCESS = "S009";

    /**
     *修改失败
     */
    public final static String SYS_UPD_FAIL = "S010";

    /**
     *删除成功
     */
    public final static String SYS_DEL_SUCCESS = "S011";

    /**
     *删除失败
     */
    public final static String SYS_DEL_FAIL = "S012";

    /**
     *发布成功
     */
    public final static String SYS_PUBLISH_SUCCESS = "S013";

    /**
     *发布失败
     */
    public final static String SYS_PUBLISH_FAIL = "S014";

    /**
     *审核成功
     */
    public final static String SYS_CHECK_SUCCESS = "S015";

    /**
     *审核失败
     */
    public final static String SYS_CHECK_FAIL = "S016";

    /**
     *系统级别提示信息(SYS)--END
     */

    /**
     *文件上传系统（FILEUPLOAD）--START
     */

    /**
     *上传图片失败
     */
    public final static String FILE_UPLOAD_PIC_FAIL = "F001";

    /**
     *上传文件格式不符合要求
     */
    public final static String FILE_UPLOAD_PIC_FORMATTER_ERROR = "F002";

    /**
     *上传文件时保存文件失败
     */
    public final static String FILE_UPLOAD_SAVE_FAIL = "F003";

    /**
     *文件上传系统（FILEUPLOAD）--END
     */
    /**
     *后台管理系统（MIS）--START
     */

    /**
     *用户名不正确
     */
    public final static String MIS_LOGIN_USERNAME_ERROR = "MISA01";

    /**
     *用户密码不正确
     */
    public final static String MIS_LOGIN_PASSWORD_ERROR = "MISA02";

    /**
     *帐户已被冻结
     */
    public final static String MIS_LOGIN_ACCOUNT_IS_FREEZE = "MISA03";

    /**
     *帐户尚未激活
     */
    public final static String MIS_LOGIN_ACCOUNT_UNACTIVE = "MISA04";

    /**
     *登录成功
     */
    public final static String MIS_LGOIN_ENTER_SUCCESS = "MISA05";

    /**
     *验证码不正确
     */
    public final static String MIS_LOGINL_VERIFY_CODE_ERROR = "MISA06";

    /**
     *用户名或密码不正确
     */
    public final static String MIS_LOGIN_USERNAME_OR_PASSWORD_ERROR = "MISA07";

    /**
     *用户名不存在
     */
    public final static String MIS_RIGISTER_NOT_EXIST_USERNAME = "MISB01";

    /**
     *用户名已存在
     */
    public final static String MIS_RIGISTER_EXIST_USERNAME = "MISB02";

    /**
     *邮箱已被注册
     */
    public final static String MIS_RIGISTER_EMAIL_ISEXIST = "MISB03";

    /**
     *用户密码不正确
     */
    public final static String MIS_RIGISTER_PASSWORD_ERROR = "MISB04";

    /**
     *原始密码不正确
     */
    public final static String MIS_SYS_PWD_ORGPASSWORD_ERROR = "MISC01";

    /**
     *两次密码输入不正确
     */
    public final static String MIS_SYS_PWD_INPUT_PASSWORD_AGIAN_ERROR = "MISC02";

    /**
     *修改密码失败
     */
    public final static String MIS_SYS_PWD_UPD_FAIL = "MISC03";

    /**
     *修改密码成功
     */
    public final static String MIS_SYS_PWD_UPD_SUCCESS = "MISC04";

    /**
     *发送重置密码邮件成功
     */
    public final static String MIS_SYS_PWD_SEND_RESET_EMAIL_FAIL = "MISC05";

    /**
     *发送重置密码邮件失败
     */
    public final static String MIS_SYS_PWD_SEND_RESET_EMAIL_SUCCESS = "MISC06";

    /**
     *查询用户权限信息失败
     */
    public final static String MIS_SYS_USER_GET_AUTHORITY_FAIL = "MISD01";

    /**
     *查询用户详情失败
     */
    public final static String MIS_SYS_USER_GET_INFO_FAIL = "MISD02";

    /**
     *证件号码格式不正确
     */
    public final static String MIS_SYS_USER_IDEN_FORMATTER_ERROR = "MISD03";

    /**
     *添加管理员信息失败
     */
    public final static String MIS_SYS_USER_ADD_MANAGE_FAIL = "MISD04";

    /**
     *添加管理员信息成功
     */
    public final static String MIS_SYS_USER_ADD_MANAGE_SUCCESS = "MISD05";

    /**
     *修改管理员信息失败
     */
    public final static String MIS_SYS_USER_UPD_MANAGE_FAIL = "MISD06";

    /**
     *修改管理员信息成功
     */
    public final static String MIS_SYS_USER_UPD_MANAGE_SUCCESS = "MISD07";

    /**
     *删除管理员信息成功
     */
    public final static String MIS_SYS_USER_DEL_MANAGE_SUCCESS = "MISD08";

    /**
     *删除管理员信息失败
     */
    public final static String MIS_SYS_USER_DEL_MANAGE_FAIL = "MISD09";

    /**
     *查询所有管理员信息失败
     */
    public final static String MIS_SYS_USER_GET_ALLINFO_FAIL = "MISD10";

    /**
     *请选择为用户分配的角色
     */
    public final static String MIS_SYS_USER_SELECT_GIVE_ROLE = "MISD11";

    /**
     *为用户分配角色成功
     */
    public final static String MIS_SYS_USER_GIVE_ROLE_SUCCESS = "MISD12";

    /**
     *为用户分配角色失败
     */
    public final static String MIS_SYS_USER_GIVE_AUTHORITY_FAIL = "MISD13";

    /**
     *查询用户是否拥有该权限失败
     */
    public final static String MIS_SYS_USER_ISEXIST_AUTHORITY = "MISD14";

    /**
     *已存在该角色名称
     */
    public final static String MIS_SYS_ROLE_ISEXIST_ROLENAME = "MISE01";

    /**
     *添加角色信息失败
     */
    public final static String MIS_SYS_ROLE_ADD_ROLE_FAIL = "MISE02";

    /**
     *添加角色信息成功
     */
    public final static String MIS_SYS_ROLE_ADD_ROLE_SUCCESS = "MISE03";

    /**
     *修改角色信息成功
     */
    public final static String MIS_SYS_ROLE_UPD_ROLE_SUCCESS = "MISE04";

    /**
     *修改角色信息失败
     */
    public final static String MIS_SYS_ROLE_UPD_ROLE_FAIL = "MISE05";

    /**
     *删除角色信息成功
     */
    public final static String MIS_SYS_ROLE_DEL_ROLE_SUCCESS = "MISE06";

    /**
     *删除角色信息失败
     */
    public final static String MIS_SYS_ROLE_DEL_ROLE_FAIL = "MISE07";

    /**
     *查询用户拥有的角色成功
     */
    public final static String MIS_SYS_ROLE_USER_GET_OWN_ROLE_SUCCESS = "MISE08";

    /**
     *查询用户拥有的角色失败
     */
    public final static String MIS_SYS_ROLE_USER_GET_OWN_ROLE_FAIL = "MISE09";

    /**
     *查询所有角色信息失败
     */
    public final static String MIS_SYS_ROLE_GET_ALLROLE_FAIL = "MISE10";

    /**
     *查询角色详情失败
     */
    public final static String MIS_SYS_ROLE_GET_ROLE_FAIL = "MISE11";

    /**
     *请选择要设置的权限
     */
    public final static String MIS_SYS_ROLE_SELECT_SET_AUTHORITY = "MISE12";

    /**
     *角色设置权限成功
     */
    public final static String MIS_SYS_ROLE_SET_AUTHORITY_SUCCESS = "MISE13";

    /**
     *角色设置权限失败
     */
    public final static String MIS_SYS_ROLE_SET_AUTHORITY_FAIL = "MISE14";

    /**
     *该角色还未分配权限
     */
    public final static String MIS_SYS_ROLE_NO_SET_AUTHORITY = "MISE15";

    /**
     *查询角色拥有的权限失败
     */
    public final static String MIS_SYS_ROLE_EXIST_AUTHORITY_FAIL = "MISE16";

    /**
     *角色名称已存在
     */
    public final static String MIS_SYS_ROLE_NAME_ALREADY_EXIST = "MISE17";

    /**
     *查询所有权限信息失败
     */
    public final static String MIS_SYS_ROLE_GET_ALL_AUTHORITY_FAIL = "MISE18";

    /**
     *查询系统日志出错
     */
    public final static String MIS_SYS_LOG_QUERY_FAIL = "MISF01";

    /**
     *保存日志信息失败
     */
    public final static String MIS_SYS_LOG_SAVE_FAIL = "MISF02";

    /**
     *新增服务工具失败
     */
    public final static String MIS_SYS_SERVERTOOL_ADD_FAIL = "MISG01";

    /**
     *编辑服务工具失败
     */
    public final static String MIS_SYS_SERVERTOOL_EDIT_FAIL = "MISG02";

    /**
     *查询服务工具详情失败 
     */
    public final static String MIS_SYS_SERVERTOOL_SEARCHDETAIL_FAIL = "MISG03";

    /**
     *新增服务工具成功
     */
    public final static String MIS_SYS_SERVERTOOL_ADD_SUCCESS = "MISG04";

    /**
     *编辑服务工具成功
     */
    public final static String MIS_SYS_SERVERTOOL_EDIT_SUCCESS = "MISG05";

    /**
     *中文名称已存在
     */
    public final static String MIS_SYS_DIC_ISEXIST_CHINA_NAME = "MISH01";

    /**
     *添加字典数据成功
     */
    public final static String MIS_SYS_DIC_ADD_SUCCESS = "MISH02";

    /**
     *删除字典数据成功
     */
    public final static String MIS_SYS_DIC_DEL_SUCCESS = "MISH03";

    /**
     *修改字典数据成功
     */
    public final static String MIS_SYS_DIC_UPD_SUCCESS = "MISH04";

    /**
     *添加字典数据失败
     */
    public final static String MIS_SYS_DIC_ADD_FAIL = "MISH05";

    /**
     *删除字典数据失败
     */
    public final static String MIS_SYS_DIC_DEL_FAIL = "MISH06";

    /**
     *修改字典数据失败
     */
    public final static String MIS_SYS_DIC_UPD_FAIL = "MISH07";

    /**
     *查询所有字典信息出错
     */
    public final static String MIS_SYS_DIC_GET_ALLINFO_FAIL = "MISH08";

    /**
     *查询字典详情信息失败
     */
    public final static String MIS_SYS_DIC_GET_INFO_FAIL = "MISH09";

    /**
     *查询所有用户信息失败
     */
    public final static String MIS_USERMANAGE_PERSONAL_GET_ALLINFO_FAIL = "MISI01";

    /**
     *查看用户基本信息失败
     */
    public final static String MIS_USERMANAGE_PERSONAL_GET_BASINFO_FAIL = "MISI02";

    /**
     *查看用户留言信息失败
     */
    public final static String MIS_USERMANAGE_PERSONAL_GET_MESSAGE_FAIL = "MISI03";

    /**
     *查看用户评论信息失败
     */
    public final static String MIS_USERMANAGE_PERSONAL_GET_COMMENT_FAIL = "MISI04";

    /**
     *用户状态为已冻结
     */
    public final static String MIS_USERMANAGE_PERSONAL_STATUS_IS_FREEZE = "MISI05";

    /**
     *冻结用户成功
     */
    public final static String MIS_USERMANAGE_PERSONAL_FREEZE_SUCCESS = "MISI06";

    /**
     *冻结用户失败
     */
    public final static String MIS_USERMANAGE_PERSONAL_FREEZE_FAIL = "MISI07";

    /**
     *用户状态为已解冻
     */
    public final static String MIS_USERMANAGE_PERSONAL_USERSTATUS_UNFREEZE = "MISI08";

    /**
     *解冻用户成功
     */
    public final static String MIS_USERMANAGE_PERSONAL_UNFREEZE_SUCCESS = "MISI09";

    /**
     *解冻用户失败
     */
    public final static String MIS_USERMANAGE_PERSONAL_UNFREEZE_FAIL = "MISI10";

    /**
     *查看所有商家信息失败
     */
    public final static String MIS_USERMANA_ENTERPRISE_GET_ALLSHOP_FAIL = "MISJ01";

    /**
     *查看商家基本信息失败
     */
    public final static String MIS_USERMANA_ENTERPRISE_GET_SHOP_FAIL = "MISJ02";

    /**
     *查看商家wifi信息失败
     */
    public final static String MIS_MISIERMANA_ENTERPRISE_GET_WIFI_FAIL = "MISJ03";

    /**
     *审核成功
     */
    public final static String MIS_USERMANA_ENTERPRISE_CHECK_SUCCESS = "MISJ04";

    /**
     *审核失败
     */
    public final static String MIS_USERMANA_ENTERPRISE_CHECK_FAIL = "MISJ05";

    /**
     *只有状态为锁定的商家才可以进行审核操作
     */
    public final static String MIS_USERMANA_ENTERPRISE_ONLY_LOCK_STATUS_CAN_CHECK = "MISJ06";

    /**
     *商家状态为已冻结
     */
    public final static String MIS_USERMANA_ENTERPRISE_SHOPSTATUS_IS_FREEZE = "MISJ07";

    /**
     *锁定商家成功
     */
    public final static String MIS_USERMANA_ENTERPRISE_LOCK_SHOP_SUCCESS = "MISJ08";

    /**
     *锁定商家失败
     */
    public final static String MIS_USERMANA_ENTERPRISE_LOCK_SHOP_FAIL = "MISJ09";

    /**
     *只有正常营业的商家才可以进行锁定
     */
    public final static String MIS_USERMANA_ENTERPRISE_ONLY_NORMALBUSINESS_SHOP_CAN_LOCK = "MISJ10";

    /**
     *查询商家Lid信息失败
     */
    public final static String MIS_USERMANA_ENTERPRISE_GET_SHOPLID_FAIL = "MISJ11";

    /**
     *删除商家Lid信息成功
     */
    public final static String MIS_USERMANA_ENTERPRISE_DEL_SHOPLID_SUCCESS = "MISJ12";

    /**
     *Lid信息分配成功
     */
    public final static String MIS_USERMANA_ENTERPRISE_GIVE_SHOPLID_SUCCESS = "MISJ13";

    /**
     *Lid值不允许重复分配
     */
    public final static String MIS_USERMANA_ENTERPRISE_GIVE_SHOPLID_SAME_FAIL = "MISJ14";

    /**
     *配置商家转发器成功
     */
    public final static String MIS_USERMANA_ENTERPRISE_SET_TRANS_SUCCESS = "MISJ15";

    /**
     *删除商家Lid信息失败
     */
    public final static String MIS_USERMANA_ENTERPRISE_DEL_SHOPLID_FAIL = "MISJ16";

    /**
     *Lid信息分配失败
     */
    public final static String MIS_USERMANA_ENTERPRISE_GIVE_SHOPLID_FAIL = "MISJ17";

    /**
     *配置商家转发器失败
     */
    public final static String MIS_USERMANA_ENTERPRISE_SET_TRANS_FAIL = "MISJ18";

    /**
     *查询商家转发器失败
     */
    public final static String MIS_USERMANA_ENTERPRISE_GET_TRANS_FAIL = "MISJ19";

    /**
     *删除商家转发器成功
     */
    public final static String MIS_USERMANA_ENTERPRISE_DEL_TRANS_SUCCESS = "MISJ20";

    /**
     *删除商家转发器失败
     */
    public final static String MIS_USERMANA_ENTERPRISE_DEL_TRANS_FAIL = "MISJ21";

    /**
     *商家转发器的MAC地址已存在
     */
    public final static String MIS_USERMANA_ENTERPRISE_IS_EXIST = "MISJ22";

    /**
     *推荐商品成功
     */
    public final static String MIS_NOMINATE_GOODS_SUCCESS = "MISK01";

    /**
     *推荐商品失败
     */
    public final static String MIS_NOMINATE_GOODS_FAIL = "MISK02";

    /**
     *取消推荐商品成功
     */
    public final static String MIS_CANCEL_GOODS_SUCCESS = "MISK03";

    /**
     *取消推荐商品失败
     */
    public final static String MIS_CANCEL_GOODS_FAIL = "MISK04";

    /**
     *修改推荐商品成功
     */
    public final static String MIS_UPDATE_GOODS_SUCCESS = "MISK05";

    /**
     *修改推荐商品失败
     */
    public final static String MIS_UPDATE_GOODS_FAIL = "MISK06";

    /**
     *推荐活动成功
     */
    public final static String MIS_NOMINATE_ACTIVITY_SUCCESS = "MISK07";

    /**
     *推荐活动失败
     */
    public final static String MIS_NOMINATE_ACTIVITY_FAIL = "MISK08";

    /**
     *取消推荐活动成功
     */
    public final static String MIS_CANCEL_ACTIVITY_SUCCESS = "MISK09";

    /**
     *取消推荐活动失败
     */
    public final static String MIS_CANCEL_ACTIVITY_FAIL = "MISK10";

    /**
     *修改推荐活动成功
     */
    public final static String MIS_UPDATE_ACTIVITY_SUCCESS = "MISK11";

    /**
     *修改推荐活动失败
     */
    public final static String MIS_UPDATE_ACTIVITY_FAIL = "MISK12";

    /**
     *推荐优惠凭证成功
     */
    public final static String MIS_NOMINATE_COUPON_SUCCESS = "MISK13";

    /**
     *推荐优惠凭证失败
     */
    public final static String MIS_NOMINATE_COUPON_FAIL = "MISK14";

    /**
     *取消推荐优惠凭证成功
     */
    public final static String MIS_CANCEL_COUPON_SUCCESS = "MISK15";

    /**
     *取消推荐优惠凭证失败
     */
    public final static String MIS_CANCEL_COUPON_FAIL = "MISK16";

    /**
     *修改推荐优惠凭证成功
     */
    public final static String MIS_UPDATE_COUPON_SUCCESS = "MISK17";

    /**
     *修改推荐优惠凭证失败
     */
    public final static String MIS_UPDATE_COUPON_FAIL = "MISK18";

    /**
     * 该商品已经推荐
     */
    public final static String MIS_DICTIARY_PARAMETER_CHECKGOODS_FAIL = "MISK19";

    /**
     * 该活动已经推荐
     */
    public final static String MIS_DICTIARY_PARAMETER_CHECKACTIVITY_FAIL = "MISK20";

    /**
     * 该优惠凭证已经推荐
     */
    public final static String MIS_DICTIARY_PARAMETER_CHECKCOUPON_FAIL = "MISK21";

    /**
     *推荐商家成功
     */
    public final static String MIS_NOMINATE_SHOP_SUCCESS = "MISK22";

    /**
     *推荐商家失败
     */
    public final static String MIS_NOMINATE_SHOP_FAIL = "MISK23";

    /**
     *取消推荐商家成功
     */
    public final static String MIS_CANCEL_SHOP_SUCCESS = "MISK24";

    /**
     *取消推荐商家失败
     */
    public final static String MIS_CANCEL_SHOP_FAIL = "MISK25";

    /**
     * 该商家已经推荐
     */
    public final static String MIS_DICTIARY_PARAMETER_CHECKSHOP_FAIL = "MISK26";

    /**
     *修改推荐商家成功
     */
    public final static String MIS_UPDATE_SHOP_SUCCESS = "MISK27";

    /**
     *修改推荐商家失败
     */
    public final static String MIS_UPDATE_SHOP_FAIL = "MISK28";
    
    /**
     *结束时间必须大于起始时间
     */
    public final static String MIS_NOMINATE_START_END = "MISK29";
    
    /**
     *推荐起始时间已存在
     */
    public final static String MIS_NOMINATE_START_EXITS = "MISK30";
    
    /**
     *推荐结束时间已存在
     */
    public final static String MIS_NOMINATE_END_EXITS = "MISK31";
    
    /**
     *推荐时间段已存在
     */
    public final static String MIS_NOMINATE_TIME_EXITS = "MISK32";

    /**
     *服务工具查询失败
     */
    public final static String MIS_USERMANA_ENTOOL_QUERY_FAIL = "MISL01";

    /**
     *服务工具审核成功
     */
    public final static String MIS_USERMANA_ENTOOL_CHECK_SUCCESS = "MISL02";

    /**
     *服务工具审核失败
     */
    public final static String MIS_USERMANA_ENTOOL_CHECK_FAIL = "MISL03";

    /**
     *服务工具发布成功
     */
    public final static String MIS_USERMANA_ENTOOL_RELEASE_SUCCESS = "MISL04";

    /**
     *服务工具发布失败
     */
    public final static String MIS_USERMANA_ENTOOL_RELEASE_FAIL = "MISL05";

    /**
     *服务工具已启用
     */
    public final static String MIS_USERMANA_ENTOOL_IS_START = "MISL06";

    /**
     *服务工具启用成功
     */
    public final static String MIS_USERMANA_ENTOOL_START_SUCCESS = "MISL07";

    /**
     *服务工具启用失败
     */
    public final static String MIS_USERMANA_ENTOOL_START_FAIL = "MISL08";

    /**
     *服务工具已停用
     */
    public final static String MIS_USERMANA_ENTOOL_IS_STOP = "MISL09";

    /**
     *服务工具停用成功
     */
    public final static String MIS_USERMANA_ENTOOL_STOP_SUCCESS = "MISL10";

    /**
     *服务工具停用失败
     */
    public final static String MIS_USERMANA_ENTOOL_STOP_FAIL = "MISL11";

    /**
     *修改服务工具信息失败
     */
    public final static String MIS_USERMANA_ENTOOL_UPD_FAIL = "MISL12";

    /**
     *修改服务工具信息成功
     */
    public final static String MIS_USERMANA_ENTOOL_UPD_SUCCESS = "MISL13";

    /**
     *配置商家wifisensor失败
     */
    public final static String MIS_USERMANA_WIFISENSOR_SET_FAIL = "MISM01";

    /**
     *删除商家wifisensor失败
     */
    public final static String MIS_USERMANA_WIFISENSOR_DEL_FAIL = "MISM02";

    /**
     *配置商家wifisensor成功
     */
    public final static String MIS_USERMANA_WIFISENSOR_SET_SUCCESS = "MISM03";

    /**
     *删除商家wifisensor成功
     */
    public final static String MIS_USERMANA_WIFISENSOR_DEL_SUCCESS = "MISM04";

    /**
     *商家wifisensor的MAC地址已存在
     */
    public final static String MIS_USERMANA_WIFISENSOR_IS_EXIST = "MISM05";

    /**
     *配置商家助手失败
     */
    public final static String MIS_USERMANA_ASSSISTANT_SET_FAIL = "MISN01";

    /**
     *删除商家助手失败
     */
    public final static String MIS_USERMANA_ASSSISTANT_DEL_FAIL = "MISN02";

    /**
     *配置商家助手成功
     */
    public final static String MIS_USERMANA_ASSSISTANT_SET_SUCCESS = "MISN03";

    /**
     *删除商家助手成功
     */
    public final static String MIS_USERMANA_ASSSISTANT_DEL_SUCCESS = "MISN04";

    /**
     *商家助手的MAC地址已存在
     */
    public final static String MIS_USERMANA_ASSSISTANT_IS_EXIST = "MISN05";

    /**
     *添加接口成功
     */
    public final static String MIS_INTERFACE_ADD_SUCCESS = "MISO01";

    /**
     *编辑接口成功
     */
    public final static String MIS_INTERFACE_EDIT_SUCCESS = "MISO02";

    /**
     *删除接口成功
     */
    public final static String MIS_INTERFACE_DEL_SUCCESS = "MISO03";

    /**
     *添加接口失败
     */
    public final static String MIS_INTERFACE_ADD_FAIL = "MISO04";

    /**
     *编辑接口失败
     */
    public final static String MIS_INTERFACE_EDIT_FAIL = "MISO05";

    /**
     *删除接口失败
     */
    public final static String MIS_INTERFACE_DEL_FAIL = "MISO06";

    /**
     *查询接口失败
     */
    public final static String MIS_INTERFACE_QUERY_FAIL = "MISO07";

    /**
     *分配接口成功
     */
    public final static String MIS_INTERFACE_GIVE_SUCCESS = "MISO08";

    /**
     *分配接口失败
     */
    public final static String MIS_INTERFACE_GIVE_FAIL = "MISO09";

    /**
     *新增模板成功
     */
    public final static String MIS_RESOURCE_TEMPLATE_ADD_SUCCESS = "MISP01";

    /**
     *新增模板失败
     */
    public final static String MIS_RESOURCE_TEMPLATE_ADD_FAIL = "MISP02";

    /**
     *查询所有模板信息失败
     */
    public final static String MIS_RESOURCE_TEMPLATE_GET_ALLTEMP_FAIL = "MISP03";

    /**
     *编辑模板成功
     */
    public final static String MIS_RESOURCE_TEMPLATE_EDIT_SUCCESS = "MISP04";

    /**
     *编辑模板失败
     */
    public final static String MIS_RESOURCE_TEMPLATE_EDIT_FAIL = "MISP05";

    /**
     *删除模板成功
     */
    public final static String MIS_RESOURCE_TEMPLATE_DEL_SUCCESS = "MISP06";

    /**
     *删除模板失败
     */
    public final static String MIS_RESOURCE_TEMPLATE_DEL_FAIL = "MISP07";

    /**
     * 上传文件内容为空
     */
    public final static String MIS_DICTIARY_BATCH_EXCEL_FAIL = "MISQ01";

    /**
     * 导入成功
     */
    public final static String MIS_DICTIARY_BATCH_SYS_SUCCESS = "MISQ02";

    /**
     * 导入失败
     */
    public final static String MIS_DICTIARY_BATCH_SYS_FAIL = "MISQ03";

    /**
     * 提示信息字典编码具有唯一性，请修改
     */
    public final static String MIS_DICTIARY_PARAMETER_PROM_FAIL = "MISQ04";

    /**
     * 营销渠道编码具有唯一性，请修改
     */
    public final static String MIS_DICTIARY_PARAMETER_MARK_FAIL = "MISQ05";

    /**
     * 接口编码具有唯一性，请修改
     */
    public final static String MIS_DICTIARY_PARAMETER_INTERBASE_FAIL = "MISQ06";

    /**
     * 后台管理权限ID具有唯一性，请修改
     */
    public final static String MIS_DICTIARY_PARAMETER_SYSAUTH_FAIL = "MISQ07";

    /**
     * 商家管理权限ID具有唯一性，请修改
     */
    public final static String MIS_DICTIARY_PARAMETER_SHOPAUTH_FAIL = "MISQ08";

    /**
     *添加渠道成功
     */
    public final static String MIS_RESOURCE_CHANNEL_ADD_SUCCESS = "MISR01";

    /**
     *添加渠道失败
     */
    public final static String MIS_RESOURCE_CHANNEL_ADD_FAIL = "MISR02";

    /**
     *查询所有渠道信息失败
     */
    public final static String MIS_RESOURCE_CHANNEL_GET_ALLINFO_FAIL = "MISR03";

    /**
     *编辑渠道信息成功
     */
    public final static String MIS_RESOURCE_CHANNEL_EDIT_SUCCESS = "MISR04";

    /**
     *删除渠道信息成功
     */
    public final static String MIS_RESOURCE_CHANNEL_DEL_SUCCESS = "MISR05";

    /**
     *编辑渠道信息失败
     */
    public final static String MIS_RESOURCE_CHANNEL_EDIT_FAIL = "MISR06";

    /**
     *删除渠道信息失败
     */
    public final static String MIS_RESOURCE_CHANNEL_DEL_FAIL = "MISR07";

    /**
     *营销资源查询失败
     */
    public final static String MIS_RESOURCE_MARKETING_QUERY_FAIL = "MISS01";

    /**
     *营销资源审核成功
     */
    public final static String MIS_RESOURCE_MARKETING_CHECK_SUCCESS = "MISS02";

    /**
     *营销资源审核失败
     */
    public final static String MIS_RESOURCE_MARKETING_CHECK_FAIL = "MISS03";

    /**
     * 添加规则配置成功
     */
    public final static String MIS_RESOURCE_RULECONFIG_ADD_SUCCESS = "MIST01";

    /**
     * 添加规则配置失败
     */
    public final static String MIS_RESOURCE_RULECONFIG_ADD_FAIL = "MIST02";

    /**
     * 修改规则配置成功
     */
    public final static String MIS_RESOURCE_RULECONFIG_UPDATE_SUCCESS = "MIST03";

    /**
     * 修改规则配置失败
     */
    public final static String MIS_RESOURCE_RULECONFIG_UPDATE_FAIL = "MIST04";

    /**
     * 删除规则配置成功
     */
    public final static String MIS_RESOURCE_RULECONFIG_DELETE_SUCCESS = "MIST05";

    /**
     * 删除规则配置失败
     */
    public final static String MIS_RESOURCE_RULECONFIG_DELETE_FAIL = "MIST06";

    /**
     * 查询规则配置详细失败
     */
    public final static String MIS_RESOURCE_RULECONFIG_QUERY_FAIL = "MIST07";

    /**
     * 商家编号、行为类型的联合值必须唯一
     */
    public final static String MIS_RESOURCE_RULECONFIG_CHECK_FAIL = "MIST08";

    /**
     * 添加商家角色成功
     */
    public final static String MIS_USER_SHOPROLE2_ADD_SUCCESS = "MIST09";

    /**
     * 添加商家角色失败
     */
    public final static String MIS_USER_SHOPROLE2_ADD_FAIL = "MIST10";

    /**
     * 修改商家角色成功
     */
    public final static String MIS_USER_SHOPROLE2_UPDATE_SUCCESS = "MIST11";

    /**
     * 修改商家角色失败
     */
    public final static String MIS_USER_SHOPROLE2_UPDATE_FAIL = "MIST12";

    /**
     * 删除商家角色成功
     */
    public final static String MIS_USER_SHOPROLE2_DELETE_SUCCESS = "MIST13";

    /**
     * 删除商家角色失败
     */
    public final static String MIS_USER_SHOPROLE2_DELETE_FAIL = "MIST14";

    /**
     * 查询商家角色详细失败
     */
    public final static String MIS_USER_SHOPROLE2_QUERY_FAIL = "MIST15";

    /**
     * 查询商家权限失败
     */
    public final static String MIS_USER_SHOPAUTHORITY_QUERY_FAIL = "MIST16";

    /**
     * 查询角色权限-关联表失败
     */
    public final static String MIS_USER_SHOPROLEAUTHORITY2_QUERY_FAIL = "MIST17";

    /**
     * 分配商家角色权限成功
     */
    public final static String MIS_USER_SHOPROLE2_ASSIGN_SUCCESS = "MIST18";

    /**
     * 分配商家角色权限失败
     */
    public final static String MIS_USER_SHOPROLE2_ASSIGN_FAIL = "MIST19";

    /**
     * 查询所有商家角色失败
     */
    public final static String MIS_USER_SHOPUSER_QUERYALL_FAIL = "MIST20";

    /**
     * 分配商家用户角色成功
     */
    public final static String MIS_USER_SHOPUSER_ASSIGN_SUCCESS = "MIST21";

    /**
     * 分配商家用户角色失败
     */
    public final static String MIS_USER_SHOPUSER_ASSIGN_FAIL = "MIST22";

    /**
     * 查询商家用户详细失败
     */
    public final static String MIS_USER_SHOPUSER_QUERY_FAIL = "MIST23";

    /**
     *查询商家信息失败
     */
    public final static String GMS_SHOPINFO_BASE_QUERY_FAIL = "MISU10";

    /**
     *请先完善商家实体店联系方式信息
     */
    public final static String GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_LINKWAY = "MISV12";

    /**
     *请先完善商家实体店GPS信息
     */
    public final static String GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_GPS = "MISV13";

    /**
     *请先完善商家实体店LID信息
     */
    public final static String GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_LID = "MISV14";

    /**
     *请先完善商家转发器信息
     */
    public final static String GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_TRANS = "MISV15";

    /**
     *请先完善商家实体店基本信息
     */
    public final static String GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_BASE = "MISV16";

    /**
     *请先确认商家是否有且只有一个主实体店
     */
    public final static String GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_ENTITYINFO = "MISV17";

    /**
     *查询广告位详细信息失败
     */
    public final static String MIS_RESOURCE_SHOPAD_QUERY_FAIL = "MISW01";

    /**
     *新增广告位信息成功
     */
    public final static String MIS_RESOURCE_SHOPAD_ADD_SUCCESS = "MISW02";

    /**
     *新增广告位信息失败
     */
    public final static String MIS_RESOURCE_SHOPAD_ADD_FAIL = "MISW03";

    /**
     *编辑广告位信息成功
     */
    public final static String MIS_RESOURCE_SHOPAD_UPDATE_SUCCESS = "MISW04";

    /**
     *编辑广告位信息失败
     */
    public final static String MIS_RESOURCE_SHOPAD_UPDATE_FAIL = "MISW05";

    /**
     *查询广告位管理详细信息失败
     */
    public final static String MIS_RESOURCE_ADMANAGE_QUERY_FAIL = "MISW06";

    /**
     *新增广告位管理信息成功
     */
    public final static String MIS_RESOURCE_ADMANAGE_ADD_SUCCESS = "MISW07";

    /**
     *新增广告位管理信息失败
     */
    public final static String MIS_RESOURCE_ADMANAGE_ADD_FAIL = "MISW08";

    /**
     *竞价起始时间必须大于当前时间
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKBIDSTATR_FAIL = "MISW09";

    /**
     *竞价结束时间必须大于当前时间
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKBIDEND_FAIL = "MISW10";

    /**
     *生效起始日期必须大于当前日期
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKEFFECTSD_FAIL = "MISW11";

    /**
     *生效结束日期必须大于当前日期
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKEFFECTED_FAIL = "MISW12";

    /**
     *生效起始时间必须大于当前时间
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKEFFECTST_FAIL = "MISW13";

    /**
     *生效结束时间必须大于当前时间
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKEFFECTET_FAIL = "MISW14";

    /**
     *起拍价、涨幅只能是数字且不能为负数
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKSI_FAIL = "MISW15";

    /**
     *生效起始日期大于等于竞价结束日期
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKSETIME_FAIL = "MISW16";

    /**
     *竞价结束时间必须大于竞价起始时间
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKBIDSE_FAIL = "MISW17";

    /**
     *生效结束日期必须大于等于生效起始日期
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKEFFECTSE_FAIL = "MISW18";

    /**
     *生效结束时间必须大于生效起始时间
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKEFFECTTSE_FAIL = "MISW19";

    /**
     *只能删除状态为空闲的广告位
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKADSMDEL_FAIL = "MISW20";

    /**
     *删除广告位管理成功
     */
    public final static String MIS_RESOURCE_ADMANAGE_DELETE_SUCCESS = "MISW21";

    /**
     *删除广告位管理失败
     */
    public final static String MIS_RESOURCE_ADMANAGE_DELETE_FAIL = "MISW22";

    /**
     *发布成功
     */
    public final static String MIS_RESOURCE_ADMANAGE_UPDATESTATE_SUCCESS = "MISW23";

    /**
     *发布失败
     */
    public final static String MIS_RESOURCE_ADMANAGE_UPDATESTATE_FAIL = "MISW24";

    /**
     *只能修改状态为空闲的广告位
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKADSMUPDATE_FAIL = "MISW25";

    /**
     *该广告位生效日期时间已存在，请修改
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKADSMESE_FAIL = "MISW26";

    /**
     *修改广告位管理成功
     */
    public final static String MIS_RESOURCE_ADMANAGE_UPDATE_SUCCESS = "MISW27";

    /**
     *修改广告位管理失败
     */
    public final static String MIS_RESOURCE_ADMANAGE_UPDATE_FAIL = "MISW28";

    /**
     *只能对状态为空闲的广告位发布
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKSF_FAIL = "MISW29";

    /**
     *只能对状态为已提交资料的广告位审核
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKSZ_FAIL = "MISW30";

    /**
     *审核成功
     */
    public final static String MIS_RESOURCE_ADMANAGE_SZ_SUCCESS = "MISW31";

    /**
     *审核失败
     */
    public final static String MIS_RESOURCE_ADMANAGE_SZ_FAIL = "MISW32";

    /**
     *只能对状态为审核的广告位收款
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKSK_FAIL = "MISW33";

    /**
     *收款成功
     */
    public final static String MIS_RESOURCE_ADMANAGE_SK_SUCCESS = "MISW34";

    /**
     *收款失败
     */
    public final static String MIS_RESOURCE_ADMANAGE_SK_FAIL = "MISW35";

    /**
     *只能对状态为已收款的广告位卖出
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKSM_FAIL = "MISW36";

    /**
     *卖出成功
     */
    public final static String MIS_RESOURCE_ADMANAGE_SM_SUCCESS = "MISW37";

    /**
     *卖出失败
     */
    public final static String MIS_RESOURCE_ADMANAGE_SM_FAIL = "MISW38";

    /**
     *只能对状态为已拍或已提交资料的广告位提交资料
     */
    public final static String MIS_RESOURCE_ADMANAGE_ST_FAIL = "MISW39";

    /**
     *提交资料成功
     */
    public final static String MIS_RESOURCE_ADMANAGE_STZ_SUCCESS = "MISW40";

    /**
     *提交资料失败
     */
    public final static String MIS_RESOURCE_ADMANAGE_STZ_FAIL = "MISW41";

    /**
     *生效起始时间必须大于竞价结束时间
     */
    public final static String MIS_RESOURCE_ADMANAGE_CHECKSETIMET_FAIL = "MISW42";

}