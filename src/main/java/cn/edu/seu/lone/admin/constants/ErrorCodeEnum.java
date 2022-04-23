package cn.edu.seu.lone.admin.constants;

public interface ErrorCodeEnum {

    // 定义服务模块名称, 标识是哪个服务抛出的错误码
    /**
     * 用户服务模块
     */
    String MODULE_USER = "USER_";

    /**
     * 系统模块
     */
    String MODULE_SYSTEM = "SYS_";

    /**
     * 后台管理服务模块
     */
    String MODULE_ADMIN_USER= "ADMIN_USER_";

    /**
     * 代理服务模块
     */
    String MODULE_STOCK_PROXY="STOCK_PROXY_";

    /**
     * 交易服务模块
     */
    String MODULE_STOCK_DEAL = "STOCK_DEAL_";

    /**
     * 挂单服务模块
     */
    String MODULE_STOCK_PENDING = "STOCK_PENDING_";

    /**
     * 资金服务模块
     */
    String MODULE_STOCK_FINANCE = "STOCK_FINANCE_";


    /**
     * 获取自定义的错误码
     * @return
     */
    public String getCode();

    /**
     * 获取自定义的错误码提示消息
     * @return
     */
    public String getMessage();

    /**
     * 获取自定义的错误级别信息
     * @return
     */
    public WarningLevelEnum getLevel();

}

