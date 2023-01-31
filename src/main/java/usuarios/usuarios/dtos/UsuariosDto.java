package usuarios.usuarios.dtos;

import jakarta.validation.constraints.NotBlank;

public class UsuariosDto {

    //@NotBlank
    private String login;
    //@NotBlank
    private String nome;
    //@NotBlank
    private String password;

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
}
