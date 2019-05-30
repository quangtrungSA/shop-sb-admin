package vn.edu.leading.shop.services;

import vn.edu.leading.shop.models.ProductModel;

import java.util.List;

public interface ProductService {

    List<ProductModel> findAll();

    List<ProductModel> search(String term);

    ProductModel findById(Long id);

    boolean update(ProductModel product);

    void save(ProductModel product);

    boolean delete(Long id);
}
