package vn.edu.leading.shop.repositories;

import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.UserModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserModel, Long> {

    Optional<UserModel> findByUsername(String username);

    Optional<UserModel> findByEmail(String email);

    List<UserModel> findAllByUsernameContaining(String term);
}
