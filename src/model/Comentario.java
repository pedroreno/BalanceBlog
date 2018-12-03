package model;

public class Comentario {
    private int idComentario, idPost, idUsuario;
    private String texto;

    public Comentario() {}

    public Comentario(int idPost, int idUsuario, String texto) {
        this.setIdComentario(idComentario);
        this.setIdPost(idPost);
        this.setIdUsuario(idUsuario);
        this.setTexto(texto);
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
