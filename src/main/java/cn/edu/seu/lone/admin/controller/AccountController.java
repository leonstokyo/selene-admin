package cn.edu.seu.lone.admin.controller;

import cn.edu.seu.lone.admin.entity.Account;
import cn.edu.seu.lone.admin.mapper.AccountMapper;
import cn.edu.seu.lone.admin.service.LoginService;
import cn.edu.seu.lone.admin.vo.ApiRespResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final LoginService loginService;

    private final AccountMapper accountMapper;

    @PostMapping("/login")
    public ApiRespResult<String> login(@RequestBody Account account) {
        // 登录
        return loginService.login(account);
    }

    // 用户列表
    @GetMapping
    public ApiRespResult<Page<Account>> getAccountList(Page<Account> page, Account account) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(account.getUsername())) {

            wrapper.like("username", "%" + account.getUsername() + "%");
        }
        if (Objects.nonNull(account.getId()) && account.getId() > 0) {
            wrapper.eq("id", account.getId());
        }
        Page<Account> accountPage = accountMapper.selectPage(page, wrapper);
        return ApiRespResult.success(accountPage);
    }

    // 退出登录
    @PostMapping("/logout")
    public ApiRespResult<String> logout() {
        return loginService.logout();
    }
}
