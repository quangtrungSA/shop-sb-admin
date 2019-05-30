package vn.edu.leading.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.OrderDetailModel;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailModel, Long> {

    //    List<OrderDetailModel> findByOrderIdContaining(String term);
//
    List<OrderDetailModel> findByOrderModelOrderById(Long id);
}
