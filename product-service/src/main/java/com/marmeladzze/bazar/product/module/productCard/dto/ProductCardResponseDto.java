package com.marmeladzze.bazar.product.module.productCard.dto;

import com.marmeladzze.bazar.product.module.productCard.ProductCard;

public record ProductCardResponseDto(
    Long id, String title, Integer price, Double averageRating, Integer reviewsCount) {
  public static ProductCardResponseDto fromEntity(ProductCard productCard) {
    if (productCard == null) {
      return null;
    }

    return new ProductCardResponseDto(
        productCard.getId(),
        productCard.getTitle(),
        productCard.getPrice(),
        productCard.getAverageRating(),
        productCard.getReviewsCount());
  }
}
