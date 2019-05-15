package vn.edu.leading.shop.repositories;

import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.RoleModel;

@Repository
public interface RoleRepository extends BaseRepository<RoleModel, Long> {

    RoleModel findByName(String s);
}
