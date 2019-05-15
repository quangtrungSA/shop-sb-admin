package vn.edu.leading.shop.utils;

import vn.edu.leading.shop.controllers.api.dto.ProductDTO;
import vn.edu.leading.shop.models.ProductModel;

public class ModelMapper {

    public static ProductDTO toProductDTO(ProductModel product) {
        if (product == null)
            return null;
        return ProductDTO.builder().id(product.getId())
                .price(product.getPrice())
                .productName(product.getProductName())
                .supplierId(product.getSupplierModel().getId())
                .categoryId(product.getCategoryModel().getId())
                .unit(product.getUnit())
                .build();
    }
}
