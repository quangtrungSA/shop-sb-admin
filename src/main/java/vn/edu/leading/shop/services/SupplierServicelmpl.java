package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.SupplierModel;
import vn.edu.leading.shop.repositories.SupplierRepository;

import java.util.List;

@Service
public class SupplierServicelmpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServicelmpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierModel> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public List<SupplierModel> search(String term) {
        return supplierRepository.findBySupplierNameContaining(term);
    }

    @Override
    public SupplierModel findById(Long id) {
        return supplierRepository.findById(id).get();
    }

    @Override
    public boolean update(SupplierModel supplier) {
        SupplierModel supplierModel = supplierRepository.findById(supplier.getId()).orElse(null);
        if (supplierModel == null)
            return false;
        supplierRepository.delete(supplierModel);
        return true;
    }

    @Override
    public void save(SupplierModel supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public boolean delete(Long id) {
        SupplierModel supplierModel = supplierRepository.findById(id).orElse(null);
        if (supplierModel == null)
            return false;
        supplierRepository.delete(supplierModel);
        return true;
    }
}
