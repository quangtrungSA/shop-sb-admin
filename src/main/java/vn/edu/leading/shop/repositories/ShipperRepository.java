package vn.edu.leading.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.ShipperModel;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<ShipperModel, Long> {

    List<ShipperModel> findByShipperNameContaining(String term);
}
