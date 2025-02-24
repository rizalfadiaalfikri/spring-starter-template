package id.co.swamedia.starter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationDto {
    private int page;
    private int size;
    private int totalPages;
    private long totalItems;
}