package vn.edu.leading.shop.services;

import vn.edu.leading.shop.models.SupplierModel;

import java.util.List;

public interface SupplierService {

    List<SupplierModel> findAll();

    List<SupplierModel> search(String term);

    SupplierModel findById(Long id);

    boolean update(SupplierModel supplier);

    void save(SupplierModel supplier);

    boolean delete(Long id);
}
