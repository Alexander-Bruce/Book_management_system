package bms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private int id;
    private String username;
    private String password;
    private String imageUrl;
    private String email;
    private LocalDateTime createdTime;

    public User(String username,  String email, String password, String imageUrl) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.imageUrl = imageUrl;
        this.email = email;
        this.createdTime = createdTime;
    }
}
