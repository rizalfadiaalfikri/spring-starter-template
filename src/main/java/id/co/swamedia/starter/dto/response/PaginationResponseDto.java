package id.co.swamedia.starter.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationResponseDto {
    private int page;
    private int size;
    private int totalPages;
    private long totalItems;
}