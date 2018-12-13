<%@ page import="model.Usuario" %>
<%@ page import="model.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="model.service.interfacesService.InterServicePost" %>
<%@ page import="model.service.ServicePost" %>
<%@ page import="model.Categoria" %>
<%@ page import="model.CategoriaPost" %>
<%@ page import="model.service.interfacesService.InterServiceCategoriaPost" %>
<%@ page import="model.service.ServiceCategoriaPost" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: Pedro Guerrero
  Date: 18/09/2018
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%
    Usuario usuarioLogado     = (Usuario) session.getAttribute("usuarioLogado");
    String papelUsuarioLogado = usuarioLogado.getPapel();
%>
<html>
<head>
    <!--definindo o tipo dos caracteres do doc-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--definindo a descrição do site-->
    <meta name="description" content="Blog sobre artes marciais">
    <!--renderizando todos os elementos mais consistentemente e os alinhando aos padrões modernos-->
    <link rel="stylesheet" href="stylesheets/normalize.css">
    <!--linkando com a folha de estilo-->
    <link rel="stylesheet" href="stylesheets/home.css">
    <!--definindo icone da página-->
    <link rel="icon" href="imagens/yin-yang.png">
    <!--definindo título da página-->
    <title>Balance blog</title>
    <!--linkando com scripts-->
    <script type="text/javascript" src="scripts/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="scripts/pageCategoria.js"></script>

</head>
<body>
<div id="<%=papelUsuarioLogado%>" class="qDificil"></div>
<div id="divGeral">


    <header id="topo">

        <input id="inPesquisa" name="pesquisa" type="search" placeholder="Pesquise Aqui :)"/>

        <img src="imagens/dobok.jpg" class="logo">

        <nav id="navBar">

            <ul>
                <li><a id="btnHome" href="home.jsp">Home</a></li>
                <li><a id="btnSobre" href="sobre.jsp">Sobre</a></li>
                <li><a id="btnContato" href="contato.jsp">Contato</a></li>
                <li><a id="btnADM" href="admin.jsp">ADM</a></li>
            </ul>

        </nav>

    </header>

    <div id="divCorpo">

        <div id="divPosts">

            <%
                InterServiceCategoriaPost sCategoriaPost = new ServiceCategoriaPost();
                InterServicePost sPost = new ServicePost();

                Categoria categoriaSelecionada = (Categoria) session.getAttribute("categoriaSelecionada");
                System.out.println(categoriaSelecionada.getNome());

                if(categoriaSelecionada == null) {
                    System.out.println("CATEGORIA ESTÁ VAZIA");
                } else {
                    List<CategoriaPost> categoriaPosts = sCategoriaPost.findByIdCategoria(categoriaSelecionada.getId());
                    List<Post> posts = new ArrayList();

                    for(CategoriaPost cp:categoriaPosts) {
                        Post post = sPost.findById(cp.getIdPost());
                        posts.add(post);
                    }

                    Collections.reverse(posts);

                    for(Post p:posts){%>

                        <%=p.printarPost()%>
                    <%}%>

                <%}%>




            <!--
            <article class="post">
                <div class="cabeçalhoPost">
                    <div class="dataPost"><h1 class="data">17</br>SET</h1></div><div class="tituloPost"><h1 class="titulo">A HISTÓRIA DO TAEKWONDO</h1></div>
                </div>
                <div id="img"></div>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
                    dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat
                    non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                </p>
                <button class="btnPost">Ler mais</button>
                <footer class="rodapePost">
                    <h3>Categorias:</h3>
                    <a class="tag">#Taekwondo</a><a class="tag">#História</a>
                </footer>
            </article>
            -->

        </div>

        <div id="divCategorias">
            <header><h1>Categorias</h1><img id="imgCategorias" src="imagens/yinyang.png" /></header>

            <section id="secCategorias">
                <a class="tag">Taekwondo</a>
                <a class="tag">Filmes</a>
                <a class="tag">História</a>
                <a class="tag">Bruce Lee</a>
                <a class="tag">Esporte</a>
            </section>
        </div>

    </div>

    <footer id="footerPagina">

    </footer>

</div>

</body>
</html>
