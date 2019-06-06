package vn.edu.leading.shop.services;


import vn.edu.leading.shop.models.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductModel> findAll();

    List<ProductModel> search(String term);

    Optional<ProductModel> findById(Long id);

    boolean update(ProductModel product);

    ProductModel save(ProductModel product);

    boolean delete(Long id);
}
