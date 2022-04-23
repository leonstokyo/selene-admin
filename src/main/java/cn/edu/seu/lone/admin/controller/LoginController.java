package cn.edu.seu.lone.admin.controller;

import cn.edu.seu.lone.admin.entity.Account;
import cn.edu.seu.lone.admin.service.LoginService;
import cn.edu.seu.lone.admin.vo.ApiRespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/account/login")
    public ApiRespResult<String> login(@RequestBody Account account) {
        // 登录
        return loginService.login(account);
    }

}
