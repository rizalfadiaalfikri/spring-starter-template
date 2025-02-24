package id.co.swamedia.starter.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BaseRequestDto<T> {
    @NotBlank
    private String requestId;

    @NotNull
    private String requestTime;

    @Valid
    @NotNull
    private T data;
}