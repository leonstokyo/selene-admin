package cn.edu.seu.lone.admin.controller;

import cn.edu.seu.lone.admin.vo.ApiRespResult;
import cn.edu.seu.lone.admin.vo.LoginVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @PostMapping("/login")
    public ApiRespResult<List<LoginVo>> login(LoginVo loginVo) {
        System.out.println(loginVo.toString());
        ApiRespResult<List<LoginVo>>  result = null;
        List<LoginVo> list = new ArrayList<>();
        list.add(loginVo);
        result = ApiRespResult.success(list);
        return result;
    }
}
