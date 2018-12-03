<%@ page import="model.Post" %>
<%@ page import="controller.Servlet" %><%--
  Created by IntelliJ IDEA.
  User: Pedro Guerrero
  Date: 25/11/2018
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contexto = request.getContextPath();
    if(!contexto.equals("")) contexto += "/";
%>
<html>
<head>
    <!--definindo o tipo dos caracteres do doc-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--definindo a descrição do site-->
    <meta name="description" content="Blog sobre artes marciais">
    <!--renderizando todos os elementos mais consistentemente e os alinhando aos padrões modernos-->
    <link rel="stylesheet" href="${contexto}stylesheets/normalize.css">
    <!--linkando com a folha de estilo-->
    <link rel="stylesheet" href="${contexto}stylesheets/post.css">
    <!--definindo icone da página-->
    <link rel="icon" href="">
    <!--definindo título da página-->
    <title>Balance blog</title>
    <!--linkando com scripts-->
    <script type="text/javascript" src="${contexto}scripts/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${contexto}scripts/home.js"></script>

</head>
<body>
<div id="${papelUsuarioLogado}" class="qDificil"></div>
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
                Servlet servlet = new Servlet();
                Post post = servlet.getPostSelecionado();
                post.printarPaginaPost();
            %>
            <!--<div class="tituloPost">
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
