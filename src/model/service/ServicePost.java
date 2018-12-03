package model.service;

import model.Post;
import model.dao.PostDAO;
import model.dao.interfacesDAO.InterPostDAO;
import model.service.interfacesService.InterServicePost;

import java.util.List;

public class ServicePost implements InterServicePost {
    @Override
    public void insert(Post post) {
        InterPostDAO ipDAO = new PostDAO();
        ipDAO.insert(post);
    }

    @Override
    public Post findByTitulo(String titulo) {
        InterPostDAO ipDAO = new PostDAO();
        Post post = ipDAO.findByTitulo(titulo);
        return post;
    }

    @Override
    public void deleteByID(int idPost) {
        InterPostDAO pDAO = new PostDAO();
        pDAO.deleteById(idPost);

    }

    @Override
    public void deleteByTitulo(String tituloPost) {
        InterPostDAO pDAO = new PostDAO();
        pDAO.deleteByTitulo(tituloPost);
    }

    @Override
    public List<Post> findAll() {
        InterPostDAO pDAO = new PostDAO();
        List<Post> posts = pDAO.findAll();
        return posts;
    }

    @Override
    public Post findById(int idPost) {
        InterPostDAO pDAO = new PostDAO();
        Post post = pDAO.findById(idPost);
        return post;
    }
}
