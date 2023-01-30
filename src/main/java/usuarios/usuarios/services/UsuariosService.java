package usuarios.usuarios.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import usuarios.usuarios.models.UsuariosModel;
import usuarios.usuarios.repositories.UsuariosRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuariosService {

    final UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Transactional
    public UsuariosModel save(UsuariosModel usuariosModel) {
        return usuariosRepository.save(usuariosModel);
    }

    public List<UsuariosModel> findAll() {
        return (List<UsuariosModel>) usuariosRepository.findAll();
    }

    public Optional<UsuariosModel> findByLogin(String login) {
        return usuariosRepository.findByLogin(login);
    }

    public Optional<UsuariosModel> findById(UUID id) {
        return usuariosRepository.findById(id);
    }

    @Transactional
    public void delete(UsuariosModel usuariosModel){
        usuariosRepository.delete(usuariosModel);
    }
}
