package id.co.swamedia.starter.controller;

import id.co.swamedia.starter.dto.request.PaginationBaseRequestDto;
import id.co.swamedia.starter.dto.response.ApiResponseDto;
import id.co.swamedia.starter.dto.response.PaginationResponseDto;
import id.co.swamedia.starter.service.MessageService;
import id.co.swamedia.starter.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to handle product-related operations.
 * <p>
 * Provide an endpoint to retrieve the product list with pagination support.
 * </p>
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

        private final ProductService productService;
        private final MessageService messageService;

        /**
         * Retrieve a list of products with pagination.
         * <p>
         * Supported headers:
         * - Accept-Language: en-US
         * - Accept-Language: id-ID
         * </p>
         *
         * @param request A DTO object containing pagination information.
         * @return ResponseEntity that contains a list of products in paginated format.
         */
        @PostMapping("/list")
        public ResponseEntity<ApiResponseDto> getProducts(@Valid @RequestBody PaginationBaseRequestDto<?> request) {
                log.info("✅ Request ID {} at {}", request.getRequestId(), request.getRequestTime());
                Page<?> productPage = productService.getAllProducts(request.getPagination());
                PaginationResponseDto paginationResponse = productService.createPaginationResponse(productPage,
                                request.getPagination());

                return ResponseEntity.ok(
                                ApiResponseDto.builder()
                                                .data(productPage.getContent())
                                                .message(messageService.getMessage("message.success"))
                                                .success(true)
                                                .status(200)
                                                .pagination(paginationResponse)
                                                .build());
        }
}