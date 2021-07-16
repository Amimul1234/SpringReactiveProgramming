package com.rahi.springreactive.service;

import com.rahi.springreactive.dto.ProductDto;
import com.rahi.springreactive.repository.ProductRepository;
import com.rahi.springreactive.utils.AppUtils;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Amimul Ehsan
 * @version 1.0
 * @date 7/16/2021 10:16 PM
 */


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService( ProductRepository productRepository ) {
        this.productRepository = productRepository;
    }

    public Flux<ProductDto> getProducts() {
        return productRepository.findAll()
                .map(AppUtils::entityToDto);
    }

    public Mono<ProductDto> getProduct( String id ) {
        return productRepository.findById(id)
                .map(AppUtils::entityToDto);
    }

    public Flux<ProductDto> getProductInRange( double min, double max ) {
        return productRepository.findByPriceBetween(Range.closed(min, max));
    }

    public Mono<ProductDto> saveProduct( Mono<ProductDto> productDtoMono ) {
        return productDtoMono
                .map(AppUtils::dtoToEntity)
                .flatMap(productRepository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<ProductDto> updateProduct( Mono<ProductDto> productDtoMono, String id ) {
        return productRepository.findById(id)
                .flatMap(product -> productDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(productRepository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteProduct( String id ) {
        return productRepository.deleteById(id);
    }
}
