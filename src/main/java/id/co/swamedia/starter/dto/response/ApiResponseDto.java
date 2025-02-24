package id.co.swamedia.starter.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponseDto {
    private int status;
    private boolean success;
    private String message;
    private Object data;
    private PaginationResponseDto pagination;
}
