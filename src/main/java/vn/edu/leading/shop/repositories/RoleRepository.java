package vn.edu.leading.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.leading.shop.models.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel,Long> {
    RoleModel findByName(String term);
}
