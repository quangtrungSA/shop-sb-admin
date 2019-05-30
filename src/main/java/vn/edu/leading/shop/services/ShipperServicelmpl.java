package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.ShipperModel;
import vn.edu.leading.shop.repositories.ShipperRepository;

import java.util.List;

@Service
public class ShipperServicelmpl implements ShipperService {

    private final ShipperRepository shipperRepository;

    public ShipperServicelmpl(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    @Override
    public List<ShipperModel> findAll() {
        return shipperRepository.findAll();
    }

    @Override
    public List<ShipperModel> search(String term) {
        return shipperRepository.findByShipperNameContaining(term);
    }

    @Override
    public ShipperModel findById(Long id) {
        return shipperRepository.findById(id).get();
    }

    @Override
    public boolean update(ShipperModel shipper) {
        ShipperModel shipperModel = shipperRepository.findById(shipper.getId()).orElse(null);
        if (shipperModel == null)
            return false;
        shipperRepository.save(shipper);
        return true;
    }

    @Override
    public void save(ShipperModel shipper) {
        shipperRepository.save(shipper);
    }

    @Override
    public boolean delete(Long id) {
        ShipperModel shipperModel = shipperRepository.findById(id).orElse(null);
        if (shipperModel == null)
            return false;
        shipperRepository.delete(shipperModel);
        return true;
    }
}
