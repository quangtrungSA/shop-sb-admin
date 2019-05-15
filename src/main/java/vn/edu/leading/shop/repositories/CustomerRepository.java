package vn.edu.leading.shop.repositories;

import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.CustomerModel;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerModel, Long> {

}
