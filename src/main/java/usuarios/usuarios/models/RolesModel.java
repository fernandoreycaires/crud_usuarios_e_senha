package usuarios.usuarios.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@Table(name = "TB_ROLES")
public class RolesModel implements GrantedAuthority {

    @Id
    private String nomeRole;

    @ManyToMany(mappedBy = "roles")
    private List<UsuariosModel> usuarios;

    public String getNomeRole() {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }

    public List<UsuariosModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuariosModel> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String getAuthority() {
        return null;
    }



}