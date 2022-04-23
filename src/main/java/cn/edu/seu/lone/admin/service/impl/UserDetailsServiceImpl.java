package cn.edu.seu.lone.admin.service.impl;

import cn.edu.seu.lone.admin.domain.LoginAccount;
import cn.edu.seu.lone.admin.entity.Account;
import cn.edu.seu.lone.admin.mapper.AccountMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getUsername, username);
        Account account = accountMapper.selectOne(queryWrapper);
        System.out.println(account);
        if (Objects.isNull(account)) {
            throw new RuntimeException("用户名或密码错误");
        }
        // 把数据封装成UserDetails

        return LoginAccount.builder()
                .account(account)
                .build();
    }
}
