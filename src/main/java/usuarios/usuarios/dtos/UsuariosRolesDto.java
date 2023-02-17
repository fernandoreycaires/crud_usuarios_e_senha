package usuarios.usuarios.dtos;

import java.util.UUID;

public class UsuariosRolesDto {

    private UUID id;
    private String nomeRole;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeRole() {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }
}
