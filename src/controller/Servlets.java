package controller;

import model.Usuario;
import model.service.InterServiceUsuario;
import model.service.ServiceUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Login"})
public class Servlets extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher rd;
        try{
            request.setCharacterEncoding("UTF-8");
        }catch(Exception e){e.printStackTrace();}

        String nome = request.getParameter("loginNome");
        String senha = request.getParameter("loginSenha");

        InterServiceUsuario sUsuario = new ServiceUsuario();
        Usuario user = sUsuario.findByNome(nome);
        ServletContext sc = request.getServletContext();


        if(user != null) {
            if (user.getSenha().equals(senha)) {
                try {
                    rd = request.getRequestDispatcher("home.jsp");
                    rd.forward(request, response);

                } catch (IOException | ServletException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    request.setAttribute("erro", "Senha incorreta!");
                    sc.getRequestDispatcher("/index.jsp").forward(request, response);
                }catch(IOException | ServletException e){
                    e.printStackTrace();
                }
            }
        }else {
            try {
                request.setAttribute("erro", "Usuário não reconhecido!");
                sc.getRequestDispatcher("/index.jsp").forward(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processRequest(request, response);
    }

}
