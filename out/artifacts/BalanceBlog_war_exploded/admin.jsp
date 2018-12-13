<%@ page import="model.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.service.interfacesService.InterServiceUsuario" %>
<%@ page import="model.service.ServiceUsuario" %><%--
  Created by IntelliJ IDEA.
  User: Pedro Guerrero
  Date: 19/11/2018
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <link rel="stylesheet" href="${contexto}stylesheets/admin.css">
    <!--definindo icone da página-->
    <link rel="icon" href="imagens/yin-yang.png">
    <!--definindo título da página-->
    <title>Balance blog</title>
    <!--linkando com scripts-->
    <script type="text/javascript" src="${contexto}scripts/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${contexto}scripts/admin.js"></script>

</head>
<body>
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

            <!--BOTÕES DE GERENCIAMENTO-->

            <div class="divsGerencia" id="divGerenciaPosts">
                <button class="btnsGerencia" id="btnAddPost">ADICIONAR NOVO POST</button>
                <br/>
                <button class="btnsGerencia" id="btnExcluirPost">EXCLUIR POST EXISTENTE</button>
            </div>
            <div class="divsGerencia" id="divGerenciaUsuarios">
                <button class="btnsGerencia" id="btnListarUsuarios">LISTAR TODOS OS USUÁRIOS</button>
                <br/>
                <button class="btnsGerencia" id="btnExcluirUsuario">EXCLUIR USUÁRIO EXISTENTE</button>
            </div>

            <!--CAIXAS DE ATIVIDADE REQUISITADA-->

            <!--ADICIONAR POST-->

            <div class="divsGerencia" id="divAddPost">
                <form action="/AdicionarPost.action" id="formAddPost">

                    <h3>Imagem do post</h3>
                    <input type="file" name="imagemPostAdd" id="imgPost" required>

                    <h3>Título</h3>
                    <input type="text" name="tituloPostAdd" id="tituloPost" maxlength="45" required>

                    <h3>Conteúdo</h3>
                    <textarea name="conteudoPostAdd" id="textoPost" required></textarea>

                    <h3>Categorias</h3>
                    <select multiple id="selectCategorias"  name="selectCategoriasPost">
                        <option class="opCategorias" value="taekwondo">Taekwondo</option>
                        <option class="opCategorias" value="brucelee">Bruce Lee</option>
                        <option class="opCategorias" value="filmes">Filmes</option>
                        <option class="opCategorias" value="esporte">Esporte</option>
                        <option class="opCategorias" value="historia">História</option>
                    </select>

                    <br/>
                    <input type="submit" id="inputAddPost" class="inputSubmit" value="postar">

                </form>
            </div>

            <!--EXCLUIR POST-->

            <div class="divsGerencia" id="divExcluirPost">
                <form>
                    <h3>Nome do post</h3>
                    <input type="text" name="tituloPostExcluir" id="tituloPostExcluir">

                    <h3 id="ou">Ou...</h3>

                    <h3>ID do post</h3>
                    <input type="text" name="idPostExcluir" id="idPostExcluir">
                </form>
                <button id="inputExcluirPost" class="inputSubmit">excluir</button>

                <br/>
                <span name="erro" id="erroExcluirPost">${erro}</span>
            </div>

            <!--LISTAR USUARIOS-->

            <div id="divListarUsuarios">
                <%
                    InterServiceUsuario sUsuario = new ServiceUsuario();
                    List<Usuario> usuarios = sUsuario.findAll();

                    for(Usuario u:usuarios) {%>

                        <%=u.printarUsuario()%>

                <%}%>
            </div>

            <!--EXCLUIR USUARIO-->

            <div class="divsGerencia" id="divExcluirUsuario">
                <form>
                    <h3>Nome do usuário</h3>
                    <input type="text" name="nomeUsuarioExcluir" id="nomeUsuarioExcluir">

                    <h3 class="ou">Ou...</h3>

                    <h3>ID do usuário</h3>
                    <input type="text" name="idUsuarioExcluir" id="idUsuarioExcluir">
                </form>
                <button id="inputExcluirUsuario" class="inputSubmit">excluir</button>

                <br/>
                <span name="erro" id="erroExcluirUsuario">${erro}</span>
            </div>

        </div>


        <!--CATEGORIAS-->

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