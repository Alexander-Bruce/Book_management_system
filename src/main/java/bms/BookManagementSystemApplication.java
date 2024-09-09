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
        // System.out.println(userService.getAllUsers());
        // System.out.println(userService.getUser(1));
//        User user = User.builder()
//                    .id(1)
//                    .username("张三")
//                    .password("123456")
//                    .imageUrl("null")
//                    .email("example@gmail.com")
//                    .build();
//        System.out.println(userService.updateUser(user));
        User user = User.builder()
                .username("Alexander")
                .password("Heqinglin2021")
                .email("qinglinhe44@gmail.com")
                .build();
        System.out.println(userService.addUser(user));
        System.out.println(userService.getUser(13));
    }

}
