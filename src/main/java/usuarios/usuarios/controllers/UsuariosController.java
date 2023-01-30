package usuarios.usuarios.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import usuarios.usuarios.dtos.UsuariosDto;
import usuarios.usuarios.models.UsuariosModel;
import usuarios.usuarios.services.UsuariosService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuarios")
public class UsuariosController {

    final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuariosDto usuariosDto) {
        var usuariosModel = new UsuariosModel();
        BeanUtils.copyProperties(usuariosDto, usuariosModel);
        usuariosModel.setPassword(new BCryptPasswordEncoder().encode(usuariosModel.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuariosService.save(usuariosModel));
    }

    @GetMapping
    public ResponseEntity<List<UsuariosModel>> getAllUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.findAll());
    }

    @GetMapping("/{login}")
    public ResponseEntity<Object> getoneusuario(@PathVariable(value = "login") String login){
        Optional<UsuariosModel> usuariosModeloptional = usuariosService.findByLogin(login);
        if (!usuariosModeloptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado !");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuariosModeloptional.get());
    }

    @DeleteMapping("/{login}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "login") String login){
        Optional<UsuariosModel> usuariosModelOptional = usuariosService.findByLogin(login);
        if (!usuariosModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado !");
        }
        usuariosService.delete(usuariosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> UpdateOneUsuario(@PathVariable(value = "id") UUID id,
                                                   @RequestBody @Valid UsuariosDto usuariosDto) {
        Optional<UsuariosModel> usuariosModelOptional = usuariosService.findById(id);
        if (!usuariosModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado !");
        }
        var usuarioModel = new UsuariosModel();
        BeanUtils.copyProperties(usuariosDto, usuarioModel);
        usuarioModel.setId(usuariosModelOptional.get().getId());
        usuarioModel.setPassword(new BCryptPasswordEncoder().encode(usuarioModel.getPassword()));
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.save(usuarioModel));
    }
}
