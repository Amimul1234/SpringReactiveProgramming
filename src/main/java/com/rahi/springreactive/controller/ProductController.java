package com.rahi.springreactive.controller;

import com.rahi.springreactive.dto.ProductDto;
import com.rahi.springreactive.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Amimul Ehsan
 * @version 1.0
 * @date 7/17/2021 12:03 AM
 */


@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController( ProductService service ) {
        this.service = service;
    }

    @GetMapping
    public Flux<ProductDto> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct( @PathVariable String id ) {
        return service.getProduct(id);
    }

    @GetMapping("/product-range")
    public Flux<ProductDto> getProductBetweenRange( @RequestParam("min") double min, @RequestParam("max") double max ) {
        return service.getProductInRange(min, max);
    }

    @PostMapping
    public Mono<ProductDto> saveProduct( @RequestBody Mono<ProductDto> productDtoMono ) {
        return service.saveProduct(productDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct( @RequestBody Mono<ProductDto> productDtoMono, @PathVariable String id ) {
        return service.updateProduct(productDtoMono, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct( @PathVariable String id ) {
        return service.deleteProduct(id);
    }

}
