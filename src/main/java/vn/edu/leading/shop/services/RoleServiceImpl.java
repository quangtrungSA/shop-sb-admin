package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.RoleModel;
import vn.edu.leading.shop.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleModel> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<RoleModel> search(String term) {
        return null;
    }

    @Override
    public RoleModel findById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public boolean update(RoleModel role) {
        RoleModel roleModel = roleRepository.findById(role.getId()).orElse(null);
        if (roleModel == null)
            return false;
        roleRepository.save(role);
        return true;
    }

    @Override
    public void save(RoleModel role) {
        roleRepository.save(role);

    }

    @Override
    public boolean delete(Long id) {
        RoleModel roleModel = roleRepository.findById(id).orElse(null);
        if (roleModel == null)
            return false;
        roleRepository.delete(roleModel);
        return true;
    }
}
