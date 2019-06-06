package vn.edu.leading.shop.repositories;

import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.CategoryModel;

@Repository
public interface CategoryRepository extends BaseRepository<CategoryModel, Long> {

}
