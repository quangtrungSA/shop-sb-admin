package vn.edu.leading.shop.repositories;

import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.OrderModel;

@Repository
public interface OrderRepository extends BaseRepository<OrderModel, Long> {

}
