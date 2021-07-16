package com.rahi.springreactive.repository;

import com.rahi.springreactive.dto.ProductDto;
import com.rahi.springreactive.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author Amimul Ehsan
 * @version 1.0
 * @date 7/16/2021 10:14 PM
 */

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    Flux<ProductDto> findByPriceBetween( Range<Double> priceRange );
}
