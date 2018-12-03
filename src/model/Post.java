package model;

import model.service.ServiceCategoria;
import model.service.ServiceCategoriaPost;
import model.service.interfacesService.InterServiceCategoria;
import model.service.interfacesService.InterServiceCategoriaPost;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Post{
    private int id, idUsuario;
    private String titulo, texto, imagem;

    public Post() {}

    public Post(String imagem, String titulo, String texto, int idUsuario) {
        this.setId(id);
        this.setImagem(imagem);
        this.setTitulo(titulo);
        this.setTexto(texto);
        this.setIdUsuario(idUsuario);
    }

    public String printarPost() {
        String article = "";

        InterServiceCategoriaPost cpService = new ServiceCategoriaPost();
        InterServiceCategoria cService = new ServiceCategoria();

        List<CategoriaPost> listaCateogiraPost = cpService.findByIdPost(this.getId());
        List<Categoria> categorias = new ArrayList();

        for(CategoriaPost cp:listaCateogiraPost) {
            categorias.add(cService.findById(cp.getIdCategoria()));
        }


        article += " <form class='post'>\n";
        article += "   <div class='tituloPost'><h1 class='titulo'>" + this.getTitulo() + "</h1></div>\n";
        article += "   <div id='img' style='background: url(\"/imagens/" + this.getImagem() + "\") no-repeat center' ></div>\n";
        article += "   <p>" + this.getTexto() + "</p>\n";
        article += "   <button name='" + this.getId() + "' class='btnPost'>Ler mais</button>\n";
        article += "   <footer class='rodapePost'>\n";
        article += "   <h3>Categorias:</h3>\n";
        if(categorias == null) System.out.println("CATEGORIAS ESTÁ VAZIO");
        else for(Categoria c:categorias) article += " <a id='" + c.getId() +"' class='tag'>#" + c.getNome() + "</a>";
        article += "\n   </footer>\n";
        article += " </form>";
        article += "<br/><br/><br/>";

        System.out.println(article);
        return article;
    }

    public String printarPaginaPost() {
        String pagina = "";

        InterServiceCategoriaPost cpService = new ServiceCategoriaPost();
        InterServiceCategoria cService = new ServiceCategoria();

        List<CategoriaPost> listaCateogiraPost = cpService.findByIdPost(this.getId());
        List<Categoria> categorias = new ArrayList();

        for(CategoriaPost cp:listaCateogiraPost) {
            categorias.add(cService.findById(cp.getIdCategoria()));
        }

        pagina += "<div class='tituloPost'>\n";
        pagina += "  <h1 class='titulo'>" + this.getTitulo() + "</h1>\n";
        pagina += "</div>\n";
        pagina += "<div id='img' style='background: url(\"/imagens/" + this.getImagem() + "\") no-repeat center' ></div>\n";
        pagina += "<p></p>\n";
        pagina += "<footer class='rodapePost'>\n";
        pagina += "  <h3>Categorias:</h3>\n";
        if(categorias == null) System.out.println("CATEGORIAS ESTÁ VAZIO");
        else for(Categoria c:categorias) pagina += " <a id='" + c.getId() +"' class='tag'>#" + c.getNome() + "</a>";
        pagina += "\n</footer>";

        System.out.println(pagina);

        return pagina;

    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getImagem() { return imagem; }

    public void setImagem(String imagem) { this.imagem = imagem; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTexto() { return texto; }

    public void setTexto(String texto) { this.texto = texto; }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
