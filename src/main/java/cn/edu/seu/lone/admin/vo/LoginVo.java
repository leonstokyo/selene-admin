package cn.edu.seu.lone.admin.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class LoginVo implements Serializable {
    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

}
