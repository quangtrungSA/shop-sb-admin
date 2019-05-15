package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.ShipperModel;

import java.util.List;

@Service
public class ShipperServicelmpl extends BaseService<ShipperModel> implements ShipperService {

    @Override
    public List<ShipperModel> search(String term) {
        return baseRepository.findByAttributeContainsText("shipperName", term);
    }
}
