package vn.edu.leading.shop.services;

import vn.edu.leading.shop.models.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    List<EmployeeModel> findAll();

    List<EmployeeModel> search(String term);

    EmployeeModel findById(Long id);

    boolean update(EmployeeModel employee);

    void save(EmployeeModel employee);

    boolean delete(Long id);
}
