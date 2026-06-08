package com.marmeladzze.bazar.product.module.productCard;

import com.marmeladzze.bazar.product.module.productCard.dto.ProductCardRequestDto;
import com.marmeladzze.bazar.product.module.productCard.dto.ProductCardResponseDto;
import com.marmeladzze.bazar.product.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductCardService {

    private final ProductCardRepository productCardRepository;

    @Transactional
    public ProductCardResponseDto create(ProductCardRequestDto requestDto){

        ProductCard newProduct = requestDto.toEntity();
        ProductCard savedProduct = productCardRepository.save(newProduct);

        return ProductCardResponseDto.fromEntity(savedProduct);
    }

    @Transactional
    public void delete(Long productCardId){
                ProductCard productCard = productCardRepository.findById(productCardId)
                                .orElseThrow(() -> new NotFoundException("Product-card not found!"));

        productCardRepository.delete(productCard);
    }

    public Page<ProductCardResponseDto> searchProducts(String searchText, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<ProductCard> entityPage = productCardRepository
                .findAllByTitleContainingIgnoreCase(searchText, pageable);

        return entityPage.map(ProductCardResponseDto::fromEntity);
    }
}
