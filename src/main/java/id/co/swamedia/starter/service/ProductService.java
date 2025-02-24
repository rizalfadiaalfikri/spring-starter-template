package id.co.swamedia.starter.service;

import id.co.swamedia.starter.dto.request.PaginationRequestDto;
import id.co.swamedia.starter.dto.response.PaginationResponseDto;
import id.co.swamedia.starter.entity.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<Product> getAllProducts(PaginationRequestDto pagination);

    PaginationResponseDto createPaginationResponse(Page<?> page, PaginationRequestDto request);
}