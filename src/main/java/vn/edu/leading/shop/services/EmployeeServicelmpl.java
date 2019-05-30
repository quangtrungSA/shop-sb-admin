package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.EmployeeModel;
import vn.edu.leading.shop.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServicelmpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServicelmpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeModel> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<EmployeeModel> search(String term) {
        return employeeRepository.findByFirstNameContaining(term);
    }

    @Override
    public EmployeeModel findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public boolean update(EmployeeModel employee) {
        EmployeeModel employeeModel = employeeRepository.findById(employee.getId()).orElse(null);
        if (employeeModel == null)
            return false;
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public void save(EmployeeModel employee) {
        employeeRepository.save(employee);
    }

    @Override
    public boolean delete(Long id) {
        EmployeeModel employeeModel = employeeRepository.findById(id).orElse(null);
        if (employeeModel == null)
            return false;
        employeeRepository.delete(employeeModel);
        return true;
    }
}
