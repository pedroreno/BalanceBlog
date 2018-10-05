package model;

import java.util.List;

public class Usuario extends Identificador{
    private Long id;
    private String nome, senha, email;
    private List<Papel> papeis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    public Usuario(){};
    public Usuario(Long id, String nome, String senha, String email, List<Papel> papeis) {
        super(id);
        this.setNome(nome);
        this.setSenha(senha);
        this.setEmail(email);
        this.setPapeis(papeis);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
