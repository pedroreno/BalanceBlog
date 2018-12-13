package model;

import model.service.ServiceUsuario;
import model.service.interfacesService.InterServiceUsuario;

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

    public String printarComentario() {
        String comentario = "";


        InterServiceUsuario sUsuario = new ServiceUsuario();
        Usuario user = sUsuario.findById(this.getIdUsuario());
        String nomeUser = user.getNome().toUpperCase();

        comentario += "<div class='divComentario'>\n";
        comentario += "  <h1 class='nomeUsuarioComentario'>" + nomeUser + "</h1>\n";
        comentario += "  <p class='comentarioUsuario'>" + this.getTexto() + "</p>\n";
        comentario += "</div>\n\n";
        comentario += "<h1>________________________________________________________________</h1>";

        return comentario;
    }

    public String printarComentarioADM() {
        String comentario = "";


        InterServiceUsuario sUsuario = new ServiceUsuario();
        Usuario user = sUsuario.findById(this.getIdUsuario());
        String nomeUser = user.getNome().toUpperCase();

        comentario += "<form action='/ExcluirComentario.action' class='divComentario'>\n";
        comentario += "  <h1 class='nomeUsuarioComentario'>" + nomeUser + "</h1>\n";
        comentario += "  <p class='comentarioUsuario'>" + this.getTexto() + "</p>\n";
        comentario += "  <input type='hidden' name='idComentario' value='" + this.getIdComentario() + "'>\n";
        comentario += "  <button class='btnExcluirComentario'>X</button>\n";
        comentario += "</form>\n\n";
        comentario += "<h1>________________________________________________________________</h1>";

        return comentario;
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
