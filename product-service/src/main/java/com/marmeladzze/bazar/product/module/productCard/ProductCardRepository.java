package com.marmeladzze.bazar.product.module.productCard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCardRepository extends JpaRepository<ProductCard, Long> {

    Page<ProductCard> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);
}
