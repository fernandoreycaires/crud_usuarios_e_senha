package usuarios.usuarios.repositories;

import org.springframework.data.repository.CrudRepository;
import usuarios.usuarios.models.RolesModel;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<RolesModel, String> {

    Optional<RolesModel> findById(String id);
}
