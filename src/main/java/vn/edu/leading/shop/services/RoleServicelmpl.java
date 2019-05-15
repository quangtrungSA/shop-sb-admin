package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.RoleModel;

import java.util.List;

@Service
public class RoleServicelmpl extends BaseService<RoleModel> implements RoleService {

    @Override
    public List<RoleModel> search(String term) {
        return baseRepository.findByAttributeContainsText("name", term);
    }
}
