package vn.edu.leading.shop.repositories;

import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.ProductModel;

@Repository
public interface ProductRepository extends BaseRepository<ProductModel, Long> {

}
