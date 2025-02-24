package id.co.swamedia.starter.service.impl;

import id.co.swamedia.starter.dto.PaginationDto;
import id.co.swamedia.starter.dto.PaginationRequestDto;
import id.co.swamedia.starter.entity.Product;
import id.co.swamedia.starter.repository.ProductRepository;
import id.co.swamedia.starter.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;
    
    @Override
    public Page<Product> getAllProducts(PaginationRequestDto pagination) {
        Sort sort = Sort.by(
                Sort.Direction.valueOf(pagination.getSortDirection()),
                pagination.getSortBy());

        return productRepository.findAll(
                PageRequest.of(pagination.getPageForSpring(), pagination.getSize(), sort));
    }

    @Override
    public PaginationDto createPaginationResponse(Page<?> page, PaginationRequestDto request) {
        return PaginationDto.builder()
                .page(request.getPage())
                .size(request.getSize())
                .totalPages(page.getTotalPages())
                .totalItems(page.getTotalElements())
                .build();
    }
}