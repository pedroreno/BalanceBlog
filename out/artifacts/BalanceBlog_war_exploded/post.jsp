<%@ page import="model.Post" %>
<%@ page import="controller.Servlet" %>
<%@ page import="model.Comentario" %>
<%@ page import="model.service.interfacesService.InterServiceComentario" %>
<%@ page import="model.service.ServiceComentario" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: Pedro Guerrero
  Date: 25/11/2018
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="stylesheets/post.css">
    <!--definindo icone da página-->
    <link rel="icon" href="imagens/yin-yang.png">
    <!--definindo título da página-->
    <title>Balance blog</title>
    <!--linkando com scripts-->
    <script type="text/javascript" src="scripts/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="scripts/post.js"></script>

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
                InterServiceComentario sComentario = new ServiceComentario();

                Post postSelecionado  = (Post) session.getAttribute("postSelecionado");

                List<Comentario> comentarios = sComentario.findByPostID(postSelecionado.getId());
            %>

            <%=postSelecionado.printarPaginaPost()%>

            <!--
            <div class="tituloPost">
                <h1 class="titulo">TITULO DO POST</h1>
            </div>

            <div id='img' style='background: url("/imagens/dobok.jpg") no-repeat center' ></div>

            <p>asdjklasjdkljaskldjkalsjdkjaskdjklasjdkljasdklas
            sajdklajskldjaskldjaklsjdklasjdjaskljdklajskldjaskljda
                sajdklajskldjaskldjaklsjdklasjdjaskljdklajskldjaskljda
                sajdklajskldjaskldjaklsjdklasjdjaskljdklajskldjaskljda
                sajdklajskldjaskldjaklsjdklasjdjaskljdklajskldjaskljda
                sajdklajskldjaskldjaklsjdklasjdjaskljdklajskldjaskljda
                sajdklajskldjaskldjaklsjdklasjdjaskljdklajskldjaskljda
                sajdklajskldjaskldjaklsjdklasjdjaskljdklajskldjaskljda
                sajdklajskldjaskldjaklsjdklasjdjaskljdklajskldjaskljda
                sajdklajskldjaskldjaklsjdklasjdjaskljdklajskldjaskljda</p>

            <footer class="rodapePost">
                <h3>Categorias:</h3>
                <a class="tag">#Taekwondo</a><a class="tag">#História</a>
            </footer>
            -->

            <div class="divTodosComentarios">

                <h1>COMENTARIOS</h1>
                <%
                    for(Comentario c:comentarios){%>

                        <%if(papelUsuarioLogado.equals("adm")){%>

                            <%=c.printarComentarioADM()%>

                        <%} else {%>

                            <%=c.printarComentario()%>

                         <%}%>

                <%}%>


                <!--
                <div class="divComentario">

                    <h1 class="nomeUsuarioComentario">JOSUEL</h1>
                    <p class="comentarioUsuario">gostei do post a informação é muito boa mesmo curti e compartilhei</p>

                </div>
                -->

                <form action="/AdicionarComentario.action" class="divCriarComentario">

                    <h3>FAÇA SEU COMENTÁRIO</h3>

                    <textarea name="textoComentario" class="comentario" required placeholder="Digite seu comentario aqui"></textarea>

                    <button type="submit" class="btnEnviarComentario">enviar</button>

                    <span name="erroComentario">${erro}</span>

                </form>

            </div>



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
