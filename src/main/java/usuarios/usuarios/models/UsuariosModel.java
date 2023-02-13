package usuarios.usuarios.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_USUARIOS")
public class UsuariosModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 150)
    private String login;

    @Column(nullable = false, unique = false, length = 150)
    private String nome;

    @JsonIgnore
    private String password;

    @ManyToMany
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(
                    name = "usuarios_login",
                    referencedColumnName = "login"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role",
                    referencedColumnName = "nomeRole"
            ) )
    private List<RolesModel> roles = new ArrayList<>();


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RolesModel> getRolesModels() {
        return roles;
    }

    public void setRolesModels(List<RolesModel> rolesModels) {
        this.roles = rolesModels;
    }


}
