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
    private Integer id;
    private String uuid;
    private String username;
    private String surname;
    private String password;
    private String email;
    private String imageUrl;
    private LocalDateTime updatedTime;
    private LocalDateTime createdTime;
}
