package com.rahi.springreactive.utils;

import com.rahi.springreactive.dto.ProductDto;
import com.rahi.springreactive.entity.Product;
import org.springframework.beans.BeanUtils;

/**
 * @author Amimul Ehsan
 * @version 1.0
 * @date 7/16/2021 9:31 PM
 */


public class AppUtils {

    public static ProductDto entityToDto( Product product ) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntity( ProductDto productDto ) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
