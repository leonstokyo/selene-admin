package cn.edu.seu.lone.admin.service.impl;

import cn.edu.seu.lone.admin.constants.ApplicationErrorCodeEnum;
import cn.edu.seu.lone.admin.domain.LoginAccount;
import cn.edu.seu.lone.admin.entity.Account;
import cn.edu.seu.lone.admin.service.LoginService;
import cn.edu.seu.lone.admin.utils.JwtUtils;
import cn.edu.seu.lone.admin.vo.ApiRespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;


    @Override
    public ApiRespResult<String> login(Account account) {
        // AuthenticationManager authenticate 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            // 如果认证没通过，给出对应的提示
            System.out.println(authentication);
            if (Objects.isNull(authentication)) {
                return  ApiRespResult.error(ApplicationErrorCodeEnum.USER_NOT_FOUND);
            }
            // 如果认证通过，把完整的用户信息存入redis
            LoginAccount loginAccount = (LoginAccount) authentication.getPrincipal();
            String accountId = loginAccount.getAccount().getId().toString();
            String jwt = JwtUtils.createJWT(accountId);
            System.out.println(jwt);
            return ApiRespResult.success(jwt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
