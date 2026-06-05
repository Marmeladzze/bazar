package com.marmeladzze.bazar.product.module.productCard;


import com.marmeladzze.bazar.product.shared.baseEntities.UpdatableBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "product_cards")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "id_generator", sequenceName = "product_card_seq")
public class ProductCard extends UpdatableBaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    @Builder.Default
    @Column(name = "average_rating")
    private Double averageRating = 0.0;

    @Builder.Default
    @Column(name = "reviews_count")
    private Integer reviewsCount = 0;
}
