package com.marmeladzze.bazar.product.module.productCard.dto;

import com.marmeladzze.bazar.product.module.productCard.ProductCard;
import jakarta.validation.constraints.*;

public record ProductCardRequestDto(
    @NotBlank(message = "Название не должно быть пустым!")
        @Size(
            min = 5,
            max = 100,
            message = "Название товара должно содержать от 5 до 100 символов!")
        String title,
    @NotNull(message = "Товар не должен быть бесплатным!")
        @Positive(message = "Цена должна быть положительной!ыыыыыыыыыы")
        Integer price) {
  public ProductCard toEntity() {
    return ProductCard.builder().title(this.title).price(this.price).build();
  }
}
