package id.co.swamedia.starter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseDto {
    
    private int status;

    private boolean success;

    private String message;

    private Object data;

}
