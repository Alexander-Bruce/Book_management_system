package bms;

import bms.domain.User;
import bms.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("bms.mapper")
public class BookManagementSystemApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(BookManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = User.builder()
                .id(1)
                .build();
        System.out.println(userService.getUser(user));
    }

}
