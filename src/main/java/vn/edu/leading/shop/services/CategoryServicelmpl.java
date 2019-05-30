package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.CategoryModel;
import vn.edu.leading.shop.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryServicelmpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServicelmpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryModel> search(String term) {
        return categoryRepository.findByCategoryNameContaining(term);
    }

    @Override
    public CategoryModel findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public boolean update(CategoryModel category) {
        CategoryModel categoryModel = categoryRepository.findById(category.getId()).orElse(null);
        if (categoryModel == null)
            return false;
        categoryRepository.save(category);
        return true;
    }

    @Override
    public void save(CategoryModel category) {
        categoryRepository.save(category);
    }

    @Override
    public boolean delete(Long id) {
        CategoryModel categoryModel = categoryRepository.findById(id).orElse(null);
        if (categoryModel == null)
            return false;
        categoryRepository.delete(categoryModel);
        return true;
    }
}
