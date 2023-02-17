package usuarios.usuarios.services;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import usuarios.usuarios.models.RolesModel;
import usuarios.usuarios.models.UsuariosModel;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuariosRolesService {

    final UsuariosService usuariosService;
    final RolesService rolesService;

    public UsuariosRolesService(UsuariosService usuariosService, RolesService rolesService) {
        this.usuariosService = usuariosService;
        this.rolesService = rolesService;
    }

    @Transactional
    public ResponseEntity<String> saveUsuarioRole(UUID usuariosModel, String rolesModel) {

        Optional<UsuariosModel> usuariosModelOptional = usuariosService.findById(usuariosModel);
        if (!usuariosModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado !");
        }

        Optional<RolesModel> rolesModelOptional = rolesService.findById(rolesModel);
        if (!rolesModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfil de usuario não encontrado !");
        }

        usuariosModelOptional.get().getRolesModels().add(rolesModelOptional.get());
        usuariosService.save(usuariosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Perfil de usuario cadastrado com sucesso");

    }

}
