package usuarios.usuarios.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import usuarios.usuarios.models.UsuariosModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuariosRepository extends CrudRepository<UsuariosModel, String> {

    Optional<UsuariosModel> findByLogin(String login);
    Optional<UsuariosModel> findById(UUID id);

/*    @Query(value = "SELECT * FROM tb_usuarios JOIN usuarios_roles ON usuarios_id = id", nativeQuery = true)
    List<UsuariosModel> findAllUsers();

    @Query(value = "SELECT * FROM tb_usuarios JOIN usuarios_roles ON usuarios_id = id WHERE login = login", nativeQuery = true)
    Optional<UsuariosModel> findOneUsers(String login);*/
}
