package vn.edu.leading.shop.services;

import vn.edu.leading.shop.models.CustomerModel;

import java.util.List;

public interface CustomerService {

    List<CustomerModel> findAll();

    List<CustomerModel> search(String term);

    CustomerModel findById(Long id);

    boolean update(CustomerModel customer);

    void save(CustomerModel customer);

    boolean delete(Long id);
}
