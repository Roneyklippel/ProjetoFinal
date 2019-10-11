package br.senac.chamados.model;

public class Login {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String login;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Login(Long id , String senha , String usuario){
        this.id=id;
        this.password = senha;
        this.login =usuario;
    }
}
