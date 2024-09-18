package bms.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	private Integer id;

	private String author;

	private String bookName;

	private String bookAlias;

	private String bookDescription;

	private Integer categoryType;

	private String categoryName;

	@NotNull
	private Integer createdUser;

	@NotNull
	private LocalDateTime updatedTime;

	@NotNull
	private LocalDateTime createdTime;

}