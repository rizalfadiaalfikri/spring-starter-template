package id.co.swamedia.starter.service;

import id.co.swamedia.starter.dto.request.PaginationRequestDto;
import id.co.swamedia.starter.dto.response.PaginationResponseDto;
import id.co.swamedia.starter.entity.Product;
import org.springframework.data.domain.Page;

/**
 * Service interface for managing {@link Product} operations.
 * This interface defines methods for retrieving products with pagination
 * and creating a standardized pagination response.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
public interface ProductService {

    Page<Product> getAllProducts(PaginationRequestDto pagination);

    PaginationResponseDto createPaginationResponse(Page<?> page, PaginationRequestDto request);
}