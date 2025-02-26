package id.co.swamedia.starter.service.impl;

import id.co.swamedia.starter.dto.request.PaginationRequestDto;
import id.co.swamedia.starter.dto.response.PaginationResponseDto;
import id.co.swamedia.starter.entity.Product;
import id.co.swamedia.starter.repository.ProductRepository;
import id.co.swamedia.starter.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link ProductService} for managing product-related operations.
 * This service provides methods to retrieve paginated products and generate pagination responses.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    /**
     * Repository for accessing product data.
     */
    private final ProductRepository productRepository;

    /**
     * Retrieves a paginated list of products based on the given pagination request.
     *
     * @param pagination the pagination request containing page number, size, sort field, and direction
     * @return a {@link Page} containing the paginated list of {@link Product} entities
     */
    @Override
    public Page<Product> getAllProducts(PaginationRequestDto pagination) {
        Sort sort = Sort.by(
                Sort.Direction.valueOf(pagination.getSortDirection()),
                pagination.getSortBy());

        return productRepository.findAll(
                PageRequest.of(pagination.getPageForSpring(), pagination.getSize(), sort));
    }

    /**
     * Creates a pagination response DTO from a given paginated result.
     *
     * @param page    the paginated data
     * @param request the original pagination request
     * @return a {@link PaginationResponseDto} containing pagination details
     */
    @Override
    public PaginationResponseDto createPaginationResponse(Page<?> page, PaginationRequestDto request) {
        return PaginationResponseDto.builder()
                .page(request.getPage())
                .size(request.getSize())
                .totalPages(page.getTotalPages())
                .totalItems(page.getTotalElements())
                .build();
    }

}