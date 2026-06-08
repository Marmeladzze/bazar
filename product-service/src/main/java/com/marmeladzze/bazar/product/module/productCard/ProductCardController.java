package com.marmeladzze.bazar.product.module.productCard;

import com.marmeladzze.bazar.product.module.productCard.dto.ProductCardRequestDto;
import com.marmeladzze.bazar.product.module.productCard.dto.ProductCardResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product-сards")
@RequiredArgsConstructor
public class ProductCardController {
    private final ProductCardService productCardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCardResponseDto create (
            @Valid @RequestBody ProductCardRequestDto dto) {
        return productCardService.create(dto);
    }

    @DeleteMapping("/{productCardId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long productCardId){
     productCardService.delete(productCardId);
    }

    @GetMapping("/{productCardId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductCardResponseDto getById(@PathVariable Long productCardId) {
        return productCardService.getById(productCardId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ProductCardResponseDto> search(
            @RequestParam(defaultValue = "") String searchText,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return productCardService.searchProducts(searchText, page, size);
    }
}
