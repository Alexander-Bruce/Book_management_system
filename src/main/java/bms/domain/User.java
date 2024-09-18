package bms.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	@NonNull
	private Integer id;

	private Integer type;

	@NotEmpty
	private String username;

	@NotEmpty
	private String surname;

	@NotEmpty
	private String password;

	@Email
	private String email;

	private String imageUrl;

	private LocalDateTime updatedTime;

	private LocalDateTime createdTime;

	private Boolean isDeleted;

}
