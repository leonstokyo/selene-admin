package cn.edu.seu.lone.admin.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {
    /**
     * 用户ID
     */
    private Long account_id;

    /**
     * token
     */
    private String token;
}
