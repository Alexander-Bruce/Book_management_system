package bms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseBody<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> ResponseBody<T> success(Integer code, String message, T data) {
        return new ResponseBody<>(code, message, data);
    }

    public static ResponseBody success(Integer code, String message) {
        return new ResponseBody<>(code, message, null);
    }

    public static <T> ResponseBody<T> error(Integer code, String message, T data) {
        return new ResponseBody<>(code, message, data);
    }

    public static ResponseBody error(Integer code, String message) {
        return new ResponseBody<>(code, message, null);
    }
}
