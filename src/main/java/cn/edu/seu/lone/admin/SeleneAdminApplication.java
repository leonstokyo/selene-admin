package cn.edu.seu.lone.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.seu.lone.admin.mapper")
public class SeleneAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeleneAdminApplication.class, args);
    }

}
