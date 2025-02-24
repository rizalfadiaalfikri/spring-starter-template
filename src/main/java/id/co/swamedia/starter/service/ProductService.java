package id.co.swamedia.starter.service;

import id.co.swamedia.starter.dto.PaginationDto;
import id.co.swamedia.starter.dto.PaginationRequestDto;
import id.co.swamedia.starter.entity.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<Product> getAllProducts(PaginationRequestDto pagination);

    PaginationDto createPaginationResponse(Page<?> page, PaginationRequestDto request);
}