package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.ProductModel;
import vn.edu.leading.shop.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServicelmpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServicelmpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductModel> search(String term) {
        return productRepository.findByProductNameContaining(term);
    }

    @Override
    public ProductModel findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public boolean update(ProductModel product) {
        ProductModel productModel = productRepository.findById(product.getId()).orElse(null);
        if (productModel == null)
            return false;
        productRepository.save(product);
        return true;
    }

    @Override
    public void save(ProductModel product) {
        productRepository.save(product);
    }

    @Override
    public boolean delete(Long id) {
        ProductModel productModel = productRepository.findById(id).orElse(null);
        if (productModel == null)
            return false;
        productRepository.delete(productModel);
        return true;
    }
}
