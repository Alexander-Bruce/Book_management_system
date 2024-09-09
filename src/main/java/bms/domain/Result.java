package bms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(Integer code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static Result success(Integer code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> error(Integer code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static Result error(Integer code, String message) {
        return new Result<>(code, message, null);
    }
}
