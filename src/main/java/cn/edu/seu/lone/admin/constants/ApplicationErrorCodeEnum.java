package cn.edu.seu.lone.admin.constants;

public enum ApplicationErrorCodeEnum implements ErrorCodeEnum {


    SUCCESS("0", "成功"),
    FAILURE("300", "系统异常"),
    SYS_BUSY("301", "系统繁忙, 请稍候重试!"),
    SYS_FLOW("302", "系统峰值， 请稍后请求！"),
    SYS_NOT_VALID_TOKEN("303", "未能获取有效的TOKEN信息!"),
    SYS_NOT_ACCESS_USER("304", "未能获取有效的用户信息!"),
    SYS_NOT_VALID_REQUEST("305", "非法请求，未授予菜单权限！"),


    PARAMS_NOT_VALID("501", "参数不合法!"),
    PARAMS_FILE_NOT_NULL("502", "文件不能为空!"),


    //全局的系统异常
    COMPONENT_LOAD_PROPERTIES_OBJ_HAD_EXIST("000001", "配置文件加载类已经存在" ),
    SYS_ERROR_ENCRYPT_SINGED(ErrorCodeEnum.MODULE_SYSTEM, "000002", "签名加密错误"),
    WAITING_UNLOCK(ErrorCodeEnum.MODULE_SYSTEM, "000003", "正在处理请求， 请稍后重试！"),
    TRY_LOCK_FAIL(ErrorCodeEnum.MODULE_SYSTEM, "000004", "加锁失败！"),


    // 用户服务模块的异常信息
    USER_NOT_FOUND(ErrorCodeEnum.MODULE_USER, "100003", "用户不存在！"),
    USER_PWD_ERROR(ErrorCodeEnum.MODULE_USER, "100004", "用户密码错误！"),
    USER_EXISTS(ErrorCodeEnum.MODULE_USER, "100005", "用户已存在！"),
    USER_COMPANY_NOT_FOUND(ErrorCodeEnum.MODULE_USER, "100006", "公司不存在！"),
    USER_FILE_NOT_FOUND(ErrorCodeEnum.MODULE_USER, "100007", "用户文件未找到！"),
    USER_ROLE_NOT_FOUND(ErrorCodeEnum.MODULE_USER, "100008", "用户角色未找到！"),

    // 后台管理服务的异常信息
    ADMIN_USER_INSTITUTION_UNIQUE(ErrorCodeEnum.MODULE_ADMIN_USER, "200001", "用户不能添加相同机构类型的角色！"),
    ADMIN_USER_NEED_LOGIN(ErrorCodeEnum.MODULE_ADMIN_USER, "200002", "请重新登陆！"),
    ADMIN_USER_ACCOUNT_EXISTS(ErrorCodeEnum.MODULE_ADMIN_USER, "200003", "用户账号已存在！"),
    ADMIN_USER_ACCOUNT_PWD_ERROR(ErrorCodeEnum.MODULE_ADMIN_USER, "200004", "用户密码错误！"),
    ADMIN_USER_NOT_ASSIGN_ROLES(ErrorCodeEnum.MODULE_ADMIN_USER, "200005", "用户未分配角色权限！"),
    ADMIN_USER_ACCOUNT_NOT_FOUND(ErrorCodeEnum.MODULE_ADMIN_USER, "200006", "用户账号不存在！"),
    ADMIN_USER_NOT_ADMIN(ErrorCodeEnum.MODULE_ADMIN_USER, "200007", "非管理员， 不能进行此操作！"),

    // 代理服务的异常信息
    NOT_FOUND_PROCESSOR(ErrorCodeEnum.MODULE_STOCK_PROXY, "300001", "不支持的业务处理数据， 请检查！"),
    NOT_VALID_LOGIN(ErrorCodeEnum.MODULE_STOCK_PROXY, "300002", "用户未登录或已过期， 请重新登录！"),

    // 交易服务异常码
    QUOTE_LAST_PRICE_NOT_FOUND(ErrorCodeEnum.MODULE_STOCK_DEAL, "400001", "未获取最新行情报价， 请稍后重试！"),
    NO_STOCK_POSITION_DATA(ErrorCodeEnum.MODULE_STOCK_DEAL, "400002", "没有持仓信息！"),
    NO_ENOUGH_POSITION_VOLUME(ErrorCodeEnum.MODULE_STOCK_DEAL, "400003", "持仓数量不足！"),

    // 挂单服务异常码
    ORDER_HAS_PROCESSED(ErrorCodeEnum.MODULE_STOCK_PENDING, "500001", "订单已处理！"),
    ORDER_NOT_FOUND(ErrorCodeEnum.MODULE_STOCK_PENDING, "500002", "未找到订单！"),
    ORDER_NOT_RECALL(ErrorCodeEnum.MODULE_STOCK_PENDING, "500003", "订单不能撤回！请检查是否已成交或撤回！"),
    ACCOUNT_NOT_MATCH(ErrorCodeEnum.MODULE_STOCK_PENDING, "500004", "账号信息不一致！不能作此操作！"),

    //资金服务
    ACCOUNT_NOT_FOUND(ErrorCodeEnum.MODULE_STOCK_FINANCE, "600001", "用户账号不存在！"),
    BALANCE_NOT_ENOUGH(ErrorCodeEnum.MODULE_STOCK_FINANCE, "600002", "可用资金不足！"),
    ;

    /**
     * 业务模块
     */
    private String module;

    /**
     * 错误编号
     */
    private String code;

    /**
     * 消息
     */
    private String message;

    /**
     * 错误级别
     */
    private WarningLevelEnum warningLevel;


    ApplicationErrorCodeEnum(String code, String message, WarningLevelEnum warningLevelEnum) {
        this.code = code;
        this.message = message;
        this.warningLevel = warningLevelEnum;
    }

    ApplicationErrorCodeEnum(String module, String code, String message, WarningLevelEnum warningLevelEnum) {
        this.module = module;
        this.code = code;
        this.message = message;
        this.warningLevel = warningLevelEnum;
    }

    ApplicationErrorCodeEnum(String module, String code, String message) {
        this.module = module;
        this.code = code;
        this.message = message;
        this.warningLevel = WarningLevelEnum.COMMON;;
    }


    ApplicationErrorCodeEnum(String code, String message) {
        this.module = ErrorCodeEnum.MODULE_SYSTEM;
        this.code = code;
        this.message = message;
        this.warningLevel = WarningLevelEnum.COMMON;
    }


    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public WarningLevelEnum getLevel() {
        return warningLevel;
    }


    @Override
    public String toString() {
        return ErrorCodeEnum.MODULE_SYSTEM + this.code + ", " + this.message;
    }
}
