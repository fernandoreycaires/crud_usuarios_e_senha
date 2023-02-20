package usuarios.usuarios.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_ROLES")
public class RolesModel implements GrantedAuthority {

    @Id
    private String nomeRole;

    @JsonBackReference
    @ManyToMany(mappedBy = "roles")
    private Set<UsuariosModel> usuarios;

    public String getNomeRole() {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }

    public Set<UsuariosModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<UsuariosModel> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String getAuthority() {
        return null;
    }

}
