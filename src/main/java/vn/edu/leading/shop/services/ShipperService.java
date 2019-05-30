package vn.edu.leading.shop.services;

import vn.edu.leading.shop.models.ShipperModel;

import java.util.List;

public interface ShipperService {

    List<ShipperModel> findAll();

    List<ShipperModel> search(String term);

    ShipperModel findById(Long id);

    boolean update(ShipperModel shipper);

    void save(ShipperModel shipper);

    boolean delete(Long id);
}
