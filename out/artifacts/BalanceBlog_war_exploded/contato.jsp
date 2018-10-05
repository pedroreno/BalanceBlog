<%--
  Created by IntelliJ IDEA.
  User: Pedro Guerrero
  Date: 05/10/2018
  Time: 02:47
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
    <link rel="stylesheet" href="${contexto}stylesheets/contato.css">
    <!--definindo icone da página-->
    <link rel="icon" href="">
    <!--definindo título da página-->
    <title>Balance blog</title>
    <!--linkando com scripts-->
    <script type="text/javascript" src="scripts/${contexto}jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="scripts/"></script>
</head>
<body>
<div id="divGeral">


    <header id="topo">

        <input id="inPesquisa" name="pesquisa" type="search" placeholder="Pesquise Aqui :)"/>

        <img src="imagens/dobok.jpg" class="logo"/>

        <nav id="navBar">

            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contato</a></li>
            </ul>

        </nav>

    </header>

    <div id="divCorpo">

        <div id="divPosts">
            <div id="divContato">
                <h3>O que você quiser compartilhar é importante para nós. Deixe seu comentário, crítica, dica de melhoria
                    ou agradecimentos. É NÓIS!</h3>
                <input name="inAssunto" required="" type="text" placeholder="Assunto"/></br>
                <textarea name="conteudo" required="" placeholder="Deixe a sua mensagem aqui!"></textarea></br>
                <button type="button" name="btnContato">Enviar</button>
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
