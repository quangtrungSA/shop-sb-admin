package vn.edu.leading.shop.repositories;

import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.OrderDetailModel;

@Repository
public interface OrderDetailRepository extends BaseRepository<OrderDetailModel, Long> {

}
