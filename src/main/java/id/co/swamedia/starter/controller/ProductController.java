package id.co.swamedia.starter.controller;

import id.co.swamedia.starter.dto.ApiResponseDto;
import id.co.swamedia.starter.dto.PaginationBaseRequestDto;
import id.co.swamedia.starter.dto.PaginationDto;
import id.co.swamedia.starter.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/list")
    public ResponseEntity<ApiResponseDto> getProducts(@Valid @RequestBody PaginationBaseRequestDto<?> request) {
        Page<?> productPage = productService.getAllProducts(request.getPagination());
        PaginationDto paginationResponse = productService.createPaginationResponse(productPage,
                request.getPagination());

        return ResponseEntity.ok(
                ApiResponseDto.builder()
                        .data(productPage.getContent())
                        .message("Products retrieved successfully")
                        .success(true)
                        .status(200)
                        .pagination(paginationResponse)
                        .build());
    }
}