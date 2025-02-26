package id.co.swamedia.starter.dto.request;

import java.util.Map;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Generic Data Transfer Object (DTO) for handling paginated requests.
 * This class encapsulates common fields required for pagination,
 * including request metadata, pagination details, and optional filters.
 *
 * @param <T> The type of the data payload contained in the request.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
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