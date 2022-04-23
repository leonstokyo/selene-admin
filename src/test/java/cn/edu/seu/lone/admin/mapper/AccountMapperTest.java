package cn.edu.seu.lone.admin.mapper;

import cn.edu.seu.lone.admin.entity.Account;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
// @RequiredArgsConstructor 这种方法注入失败
class AccountMapperTest {

    private AccountMapper accountMapper;
    @Autowired
    private void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void testAccountMapper() {
        List<Account> accounts = accountMapper.selectList(null);
        System.out.println(accounts);
    }

    @Test
    public void TestBCryptPasswordEncoder() {
        String encode1 = passwordEncoder.encode("123456");
        String encode2 = passwordEncoder.encode("123456");
        System.out.println(encode1);
        System.out.println(encode2);
        System.out.println(passwordEncoder.matches("123456",
                "$2a$10$AGQRld.TswuiycF8B3OLVOgxlH1KgnC9LG7cli54pV82Yck767UAq"));
    }
}