package vn.edu.leading.shop.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.leading.shop.controllers.api.dto.CategoryDTO;
import vn.edu.leading.shop.errors.ObjectNotFoundException;
import vn.edu.leading.shop.models.CategoryModel;
import vn.edu.leading.shop.services.CategoryService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryApiController {

    private final CategoryService categoryService;

    public CategoryApiController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        CategoryModel categoryModel = categoryService.findById(id).orElseThrow(() -> new ObjectNotFoundException("category"));
        return new ResponseEntity<>(categoryModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryName(categoryDTO.getCategoryName());
        categoryModel.setDescription(categoryDTO.getDescription());
        return new ResponseEntity(categoryService.save(categoryModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryModel categoryModel = categoryService.findById(id).orElseThrow(() -> new ObjectNotFoundException("category"));
        categoryModel.setCategoryName(categoryDTO.getCategoryName());
        categoryModel.setDescription(categoryDTO.getDescription());
        return new ResponseEntity(categoryService.save(categoryModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoryService.findById(id).orElseThrow(() -> new ObjectNotFoundException("category"));
        return new ResponseEntity<>(categoryService.delete(id), HttpStatus.OK);
    }
}
