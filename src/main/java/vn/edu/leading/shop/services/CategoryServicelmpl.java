package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.CategoryModel;

import java.util.List;

@Service
public class CategoryServicelmpl extends BaseService<CategoryModel> implements CategoryService {

    @Override
    public List<CategoryModel> search(String term) {
        return baseRepository.findByAttributeContainsText("categoryName", term);
    }
}
