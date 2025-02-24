package id.co.swamedia.starter.dto;

import java.util.Map;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaginationBaseRequestDto<T> {
    @NotBlank
    private String requestId;

    @NotNull
    private String requestTime;

    private T data;

    @Valid
    private PaginationRequestDto pagination;

    private Map<String, Object> filters;
}