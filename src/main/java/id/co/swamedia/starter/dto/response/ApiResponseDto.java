package id.co.swamedia.starter.dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for API response.
 * This class encapsulates the standard structure of an API response,
 * including status, success indicator, message, data, and pagination information.
 * <p>
 * Uses Lombok annotations:
 * <ul>
 *     <li>{@code @Data} - Generates getters, setters, toString, equals, and hashCode.</li>
 *     <li>{@code @Builder} - Provides a builder pattern for creating instances.</li>
 * </ul>
 * </p>
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Data
@Builder
public class ApiResponseDto {

    private int status;
    private boolean success;
    private String message;
    private Object data;
    private PaginationResponseDto pagination;
}
