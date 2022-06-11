package cn.edu.seu.lone.admin.service;

import cn.edu.seu.lone.admin.entity.Account;
import cn.edu.seu.lone.admin.vo.ApiRespResult;

public interface LoginService {

    ApiRespResult<String> login(Account account);

    ApiRespResult<String> logout();
}
