package usuarios.usuarios.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import usuarios.usuarios.models.UsuariosModel;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuariosRepository extends CrudRepository<UsuariosModel, String> {

    Optional<UsuariosModel> findByLogin(String login);
    Optional<UsuariosModel> findById(UUID id);
}
