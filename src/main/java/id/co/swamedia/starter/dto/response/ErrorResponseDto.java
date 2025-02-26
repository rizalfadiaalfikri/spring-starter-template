package id.co.swamedia.starter.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for representing error responses in an API.
 * This class encapsulates standard error response attributes, including status,
 * success flag, error message, optional data, and additional error details.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseDto {

    private int status;

    private boolean success;

    private String message;

    private Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object errors;

}
