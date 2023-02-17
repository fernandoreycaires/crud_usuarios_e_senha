package usuarios.usuarios.services;

import org.springframework.stereotype.Service;
import usuarios.usuarios.models.RolesModel;
import usuarios.usuarios.repositories.RoleRepository;

import java.util.Optional;

@Service
public class RolesService {

    final RoleRepository roleRepository;

    public RolesService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<RolesModel> findById(String id){
        return roleRepository.findById(id);
    }
}
