package vn.edu.leading.shop.repositories;

import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.EmployeeModel;

@Repository
public interface EmployeeRepository extends BaseRepository<EmployeeModel, Long> {

}
