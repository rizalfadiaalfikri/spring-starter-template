package id.co.swamedia.starter.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Basic DTO class for API requests.
 * <p>
 * This class provides a common structure for each request sent
 * to the server, including the request ID, request time, and specific data.
 * </p>
 *
 * @param <T> The type of data sent in the request.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
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