package cn.edu.seu.lone.admin.service.impl;

import cn.edu.seu.lone.admin.constants.ApplicationErrorCodeEnum;
import cn.edu.seu.lone.admin.domain.LoginAccount;
import cn.edu.seu.lone.admin.entity.Account;
import cn.edu.seu.lone.admin.service.LoginService;
import cn.edu.seu.lone.admin.utils.JwtUtils;
import cn.edu.seu.lone.admin.utils.RedisCache;
import cn.edu.seu.lone.admin.vo.ApiRespResult;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;

    private final RedisCache redisCache;


    @Override
    public ApiRespResult<String> login(Account account) {
        // AuthenticationManager authenticate 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            // 如果认证通过，把完整的用户信息存入redis
            LoginAccount loginAccount = (LoginAccount) authentication.getPrincipal();
            String accountId = loginAccount.getAccount().getId().toString();
            String jwt = JwtUtils.createJWT(accountId);

            redisCache.setCacheObject("account_login:" + accountId, loginAccount);
            return ApiRespResult.success(jwt);
        } catch (InternalAuthenticationServiceException e) { // 这里认证不通过是抛出异常
            // 如果认证没通过，给出对应的提示
            return  ApiRespResult.error(ApplicationErrorCodeEnum.USER_NOT_FOUND_OR_INCORRECT_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiRespResult.error(ApplicationErrorCodeEnum.FAILURE);
        }
    }

    @Override
    public ApiRespResult<String> logout() {
        // 获取 SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext();
        LoginAccount loginAccount = (LoginAccount) authenticationToken.getPrincipal();
        Long accountId = loginAccount.getAccount().getId();
        // 删除redis key
        redisCache.deleteObject("account_login" + accountId);
        return ApiRespResult.success("退出成功");
    }


}
