package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.EmployeeModel;

import java.util.List;

@Service
public class EmployeeServicelmpl extends BaseService<EmployeeModel> implements EmployeeService {

    @Override
    public List<EmployeeModel> search(String term) {
        return baseRepository.findByAttributeContainsText("firstName", term);
    }
}
