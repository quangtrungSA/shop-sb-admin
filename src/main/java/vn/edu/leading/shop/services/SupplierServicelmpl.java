package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.SupplierModel;

import java.util.List;

@Service
public class SupplierServicelmpl extends BaseService<SupplierModel> implements SupplierService {

    @Override
    public List<SupplierModel> search(String term) {
        return baseRepository.findByAttributeContainsText("supplierName", term);
    }
}
