package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.CustomerModel;
import vn.edu.leading.shop.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerServicelmpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServicelmpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerModel> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<CustomerModel> search(String term) {
        return customerRepository.findByCustomerNameContaining(term);
    }

    @Override
    public CustomerModel findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public boolean update(CustomerModel customer) {
        CustomerModel customerModel = customerRepository.findById(customer.getId()).orElse(null);
        if (customerModel == null)
            return false;
        customerRepository.save(customer);
        return true;
    }

    @Override
    public void save(CustomerModel customer) {
        customerRepository.save(customer);
    }

    @Override
    public boolean delete(Long id) {
        CustomerModel customerModel = customerRepository.findById(id).orElse(null);
        if (customerModel == null)
            return false;
        customerRepository.delete(customerModel);
        return true;
    }
}
