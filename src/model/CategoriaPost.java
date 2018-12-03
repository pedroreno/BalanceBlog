package model;

public class CategoriaPost {
    private int idPost, idCategoria;

    public CategoriaPost() {}

    public CategoriaPost(int idPost, int idCategoria) {
        this.setIdCategoria(idCategoria);
        this.setIdPost(idPost);
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
