package id.co.swamedia.starter.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
