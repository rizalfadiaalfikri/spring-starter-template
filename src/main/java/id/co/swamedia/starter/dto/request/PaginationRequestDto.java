package id.co.swamedia.starter.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PaginationRequestDto {
    @Min(1)
    @Schema(description = "Page number (starts from 1)", example = "1", defaultValue = "1")
    private int page = 1;

    @Min(1)
    @Schema(description = "Number of items per page", example = "10", defaultValue = "10")
    private int size = 10;

    @Schema(description = "Field to sort by", example = "id", defaultValue = "id")
    private String sortBy = "id";

    @Schema(description = "Sort direction (ASC or DESC)", example = "ASC", defaultValue = "ASC", allowableValues = {
            "ASC", "DESC" })
    private String sortDirection = "ASC";

    @JsonIgnore
    public int getPageForSpring() {
        return page - 1;
    }
}