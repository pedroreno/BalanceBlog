package controller;

import model.*;
import model.service.*;
import model.service.interfacesService.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Servlet extends HttpServlet {
    static Servlet servlet = new Servlet();
    static HttpSession session;
    private Usuario usuarioLogado;
    private Post postSelecionado;
    private Categoria categoriaSelecionada;

    public Categoria getCategoriaSelecionada() {
        return categoriaSelecionada;
    }

    public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
    }

    public Post getPostSelecionado() {
        return postSelecionado;
    }

    public void setPostSelecionado(Post postSelecionado) {
        this.postSelecionado = postSelecionado;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    @WebServlet(urlPatterns = {"/Login"})
    public static class Login extends HttpServlet {

        private void processRequest(HttpServletRequest request, HttpServletResponse response) {
            session = request.getSession(true);
            response.setContentType("text/html");
            RequestDispatcher rd;
            try{
                request.setCharacterEncoding("UTF-8");
            }catch(Exception e){e.printStackTrace();}

            String nome = request.getParameter("loginNome");
            String senha = request.getParameter("loginSenha");

            InterServiceUsuario sUsuario = new ServiceUsuario();
            Usuario user = sUsuario.findByName(nome);
            ServletContext sc = request.getServletContext();


            if(user == null) {
                try {
                    request.setAttribute("erro", "Usuário não reconhecido!");
                    sc.getRequestDispatcher("/index.jsp").forward(request, response);

                } catch (IOException | ServletException e) { e.printStackTrace(); }
            }else {
                if (user.getSenha().equals(senha)) {
                    try {
                        servlet.setUsuarioLogado(user);
                        session.setAttribute("usuarioLogado", user);
                        rd = request.getRequestDispatcher("home.jsp");
                        rd.forward(request, response);
                        System.out.println(servlet.getUsuarioLogado().getNome());

                    } catch (IOException | ServletException e) { e.printStackTrace(); }
                }else {
                    try {
                        request.setAttribute("erro", "Senha incorreta!");
                        sc.getRequestDispatcher("/index.jsp").forward(request, response);

                    }catch(IOException | ServletException e){ e.printStackTrace(); }
                }
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

    }

    @WebServlet(urlPatterns = {"/Cadastro"})
    public static class Cadastro extends HttpServlet {

        private void processRequest(HttpServletRequest request, HttpServletResponse response) {
            response.setContentType("text/html");
            RequestDispatcher rd;
            try{
                request.setCharacterEncoding("UTF-8");
            }catch(Exception e){e.printStackTrace();}

            String nome   = request.getParameter("cadNome");
            String senha  = request.getParameter("cadSenha");
            String senha2 = request.getParameter("cadSenha2");
            String email  = request.getParameter("cadEmail");

            InterServiceUsuario sUsuario = new ServiceUsuario();
            ServletContext sc = request.getServletContext();

            if(sUsuario.findByName(nome) == null) {
                if(senha.equals(senha2)){
                    try{
                        Usuario novoUser = new Usuario(nome, senha, email, "user");
                        sUsuario.insert(novoUser);
                        rd = request.getRequestDispatcher("/index.jsp");
                        rd.forward(request, response);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try{
                        request.setAttribute("erro", "As senhas não são equivalentes!");
                        sc.getRequestDispatcher("/cadastro.jsp").forward(request, response);

                    } catch(IOException | ServletException e) { e.printStackTrace(); }
                }
            } else {
                try{
                    request.setAttribute("erro", "Este nome de usuário já está em uso!");
                    sc.getRequestDispatcher("/cadastro.jsp").forward(request, response);
                } catch (IOException | ServletException e) { e.printStackTrace(); }
            }



        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

    }

    @WebServlet(urlPatterns = {"/ListarUsuarios"})
    public static class ListarUsuarios extends HttpServlet{
        private void processRequest(HttpServletRequest request, HttpServletResponse response) {
            response.setContentType("text/html");
            RequestDispatcher rd;
            try{
                request.setCharacterEncoding("UTF-8");

            }catch(Exception e){e.printStackTrace();}

            InterServiceUsuario sUsuario = new ServiceUsuario();
            List<Usuario> usuarios = sUsuario.findAll();

            try{
                request.setAttribute("listaUsuarios", usuarios);
                rd = request.getRequestDispatcher("/admin.jsp");
                rd.forward(request, response);

            } catch(IOException | ServletException e) { e.printStackTrace(); }


        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }
    }

    @WebServlet(urlPatterns = {"/AdicionarPost"})
    public static class AdicionarPost extends HttpServlet {
        private void processRequest(HttpServletRequest request, HttpServletResponse response) {
            response.setContentType("text/html");
            RequestDispatcher rd;
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (Exception e) { e.printStackTrace(); }


            try {
                String imagem = request.getParameter("imagemPostAdd");
                String titulo = request.getParameter("tituloPostAdd");
                String conteudo = request.getParameter("conteudoPostAdd");
                int idUsuario = servlet.getUsuarioLogado().getId();


                Post novoPost = new Post(imagem, titulo, conteudo, idUsuario);

                InterServicePost sPost = new ServicePost();
                sPost.insert(novoPost);

                String[] categorias = request.getParameterValues("selectCategoriasPost");
                if(categorias == null) System.out.println("CATEGORIAS ESTÁ VAZIO");

                List<Integer> idsCategorias = new ArrayList();

                InterServiceCategoria sCategoria = new ServiceCategoria();
                for(String c:categorias) {
                    Categoria categoria = sCategoria.findByName(c);
                    idsCategorias.add(categoria.getId());
                }

                Post post = sPost.findByTitulo(titulo);
                InterServiceCategoriaPost sCategoriaPost = new ServiceCategoriaPost();
                for(int i:idsCategorias) {
                    if(post == null) System.out.println("FODEU");
                    else {
                        CategoriaPost nova = new CategoriaPost(post.getId(), i);
                        sCategoriaPost.insert(nova);
                    }
                }


                rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response);


            } catch(IOException | ServletException e) { e.printStackTrace(); }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }
    }

    @WebServlet(urlPatterns = {"/ExcluirPost"})
    public static class ExcluirPost extends HttpServlet {
        private void processRequest(HttpServletRequest request, HttpServletResponse response) {
            response.setContentType("text/html");
            RequestDispatcher rd;
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (Exception e) { e.printStackTrace(); }

            String idPost = request.getParameter("id");
            String tituloPost = request.getParameter("titulo");

            InterServicePost sPost = new ServicePost();
            ServletContext sc = request.getServletContext();

            if(tituloPost.equals("")) {
                sPost.deleteByID(Integer.valueOf(idPost));
                System.out.println("Post deletado com sucesso!");
            } else {
                sPost.deleteByTitulo(tituloPost);
                System.out.println("Post deletado com sucesso!");
            }


        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

    }

    @WebServlet(urlPatterns = {"/ExcluirUsuario"})
    public static class ExcluirUsuario extends HttpServlet {
        private void processRequest(HttpServletRequest request, HttpServletResponse response) {
            response.setContentType("text/html");
            RequestDispatcher rd;
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (Exception e) { e.printStackTrace(); }

            String idUsuario = request.getParameter("id");
            String nomeUsuario = request.getParameter("nome");

            InterServiceUsuario sUsuario = new ServiceUsuario();
            InterServiceComentario sComentario = new ServiceComentario();

            if(nomeUsuario.equals("")) {
                sUsuario.deleteById(Integer.valueOf(idUsuario));
                sComentario.deleteByUsuario(Integer.valueOf(idUsuario));
                System.out.println("Post deletado com sucesso!");

            }
            else {
                sUsuario.deleteByName(nomeUsuario);

                Usuario user = sUsuario.findByName(nomeUsuario);
                sComentario.deleteByUsuario(user.getId());

                System.out.println("Post deletado com sucesso!");
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }
    }

    @WebServlet(urlPatterns = {"/DirecionarPost"})
    public static class DirecionarPost extends HttpServlet {
        private void processRequest(HttpServletRequest request, HttpServletResponse response) {
            response.setContentType("text/html");
            session = request.getSession(true);
            RequestDispatcher rd;
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (Exception e) { e.printStackTrace(); }

            int idPost = Integer.parseInt(request.getParameter("idPost"));

            InterServicePost sPost = new ServicePost();
            Post post = sPost.findById(idPost);

            servlet.setPostSelecionado(post);
            session.setAttribute("postSelecionado", post);

            ServletContext sc = request.getServletContext();

            try {
                sc.getRequestDispatcher("/post.jsp").forward(request, response);

            } catch(IOException | ServletException e) {e.printStackTrace();}


        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

    }

    @WebServlet(urlPatterns = {"/AdicionarComentario"})
    public static class AdicionarComentario extends HttpServlet {
        private void processRequest(HttpServletRequest request, HttpServletResponse response) {
            response.setContentType("text/html");
            session = request.getSession(true);
            RequestDispatcher rd;
            ServletContext sc = request.getServletContext();
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (Exception e) { e.printStackTrace(); }

            List<String> palavroes = new ArrayList();
            try {
                FileReader arquivo = new FileReader("../../palavroes.txt");
                BufferedReader br = new BufferedReader(arquivo);
                String linha;
                while((linha = br.readLine()) != null) {
                    palavroes.add(linha.toLowerCase());
                }

            } catch(IOException e) {
                System.out.println("Arquivo não encontrado... AdicionarComentario");
                e.printStackTrace();
            }

            Usuario userAtual = (Usuario) session.getAttribute("usuarioLogado");
            Post postAtual = (Post) session.getAttribute("postSelecionado");

            InterServiceComentario sComentario = new ServiceComentario();

            String textoComentario = request.getParameter("textoComentario");

            boolean achouPalavrao = false;
            for(String p:palavroes) {
                if(textoComentario.toLowerCase().contains(p)) achouPalavrao = true;
            }

            if(!achouPalavrao) {
                int idUsuario = userAtual.getId();
                int idPost = postAtual.getId();

                Comentario comentario = new Comentario(idPost, idUsuario, textoComentario);
                sComentario.insert(comentario);

                try {
                    rd = request.getRequestDispatcher("post.jsp");
                    rd.forward(request, response);

                } catch(IOException | ServletException e) { e.printStackTrace(); }
            } else {
                try {
                    request.setAttribute("erro", "O comentário não pode conter palavrões, seu boca suja!");
                    sc.getRequestDispatcher("/post.jsp").forward(request, response);
                } catch (IOException | ServletException e) { e.printStackTrace(); }
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

    }

    @WebServlet(urlPatterns = {"/ExcluirComentario"})
    public static class ExcluirComentario extends HttpServlet {
        private void processRequest(HttpServletRequest request, HttpServletResponse response) {
            session = request.getSession(true);
            response.setContentType("text/html");
            RequestDispatcher rd;
            try{
                request.setCharacterEncoding("UTF-8");
            }catch(Exception e){e.printStackTrace();}

            int idComentario = Integer.parseInt(request.getParameter("idComentario"));

            InterServiceComentario sComentario = new ServiceComentario();
            sComentario.deleteById(idComentario);

            try {
                rd = request.getRequestDispatcher("post.jsp");
                rd.forward(request, response);

            } catch(IOException | ServletException e) { e.printStackTrace(); }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }
    }

    @WebServlet(urlPatterns = {"/DirecionarPaginaCategoria"})
    public static class DirecionarPaginaCategoria extends HttpServlet {
        private void processRequest(HttpServletRequest request, HttpServletResponse response) {
            session = request.getSession(true);
            response.setContentType("text/html");
            RequestDispatcher rd;
            try{
                request.setCharacterEncoding("UTF-8");
            }catch(Exception e){e.printStackTrace();}

            InterServiceCategoria sCategoria = new ServiceCategoria();

            String nomeCategoria = request.getParameter("tag");
            nomeCategoria = nomeCategoria.toLowerCase();
            nomeCategoria = nomeCategoria.replaceAll(" ", "");

            Categoria categoria = sCategoria.findByName(nomeCategoria);

            servlet.setCategoriaSelecionada(categoria);
            session.setAttribute("categoriaSelecionada", categoria);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
        }
    }


}
