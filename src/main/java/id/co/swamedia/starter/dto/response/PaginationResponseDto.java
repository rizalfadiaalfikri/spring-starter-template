package id.co.swamedia.starter.dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for representing pagination details in API responses.
 * This class encapsulates pagination-related metadata, such as the current page,
 * page size, total pages, and total items.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Data
@Builder
public class PaginationResponseDto {

    private int page;
    private int size;
    private int totalPages;
    private long totalItems;
}