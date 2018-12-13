package model;

public class Usuario{
    private int id;
    private String nome, senha, email, papel;

    public Usuario(){}

    public Usuario(String nome, String senha, String email, String papel) {
        this.setId(id);
        this.setNome(nome);
        this.setSenha(senha);
        this.setEmail(email);
        this.setPapel(papel);
    }

    public String printarUsuario() {
        String usuario = "";

        usuario += "<div class='divUsuario'>\n";
        usuario += "  <h3>Id: " + this.getId() + "</h3>\n";
        usuario += "  <h3>Nome: " + this.getNome() + "</h3>\n";
        usuario += "  <h3>Email: " + this.getEmail() + "</h3>\n";
        usuario += "  <h3>Papel: " + this.getPapel() + "</h3>\n";
        usuario += "</div>";
        usuario += "<h1>______________________________________</h1>\n";

        return usuario;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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
