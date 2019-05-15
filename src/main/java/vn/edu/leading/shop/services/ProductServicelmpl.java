package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.ProductModel;

import java.util.List;

@Service
public class ProductServicelmpl extends BaseService<ProductModel> implements ProductService {

    public List<ProductModel> search(String term) {
        return baseRepository.findByAttributeContainsText("productName", term);
    }
}
