package usuarios.usuarios.repositories;

import org.springframework.data.repository.CrudRepository;
import usuarios.usuarios.models.UsuariosModel;

import java.util.Optional;
import java.util.UUID;

public interface UsuariosRepository extends CrudRepository<UsuariosModel, String> {

    Optional<UsuariosModel> findByLogin(String login);
    Optional<UsuariosModel> findById(UUID id);
}
