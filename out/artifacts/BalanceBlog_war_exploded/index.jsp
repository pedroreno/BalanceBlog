<%--
  Created by IntelliJ IDEA.
  User: Pedro Guerrero
  Date: 17/09/2018
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
    String contexto = request.getContextPath();
    if(!contexto.equals("")) contexto += "/";
%>

<!DOCTYPE html>
<html>
<head>
    <!--definindo o tipo dos caracteres do doc-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--definindo a descrição do site-->
    <meta name="description" content="Blog sobre artes marciais">
    <!--renderizando todos os elementos mais consistentemente e os alinhando aos padrões modernos-->
    <link rel="stylesheet" type="text/css" href="${contexto}stylesheets/normalize.css">
    <!--linkando com a folha de estilo-->
    <link rel="stylesheet" type="text/css" href="${contexto}stylesheets/login.css">
    <!--definindo icone da página-->
    <link rel="icon" href="imagens/tomato_red.png">
    <!--definindo título da página-->
    <title>Balance blog</title>
    <!--linkando com scripts-->
    <script type="text/javascript" src="${contexto}scripts/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${contexto}scripts/login.js"></script>

</head>

<body>
<h1 id="teste">BALANCE BLOG</h1>
<h3>Informação de qualidade sobre o maravilhoso mundo das artes marciais</h3>

<form action="Login.action" method="post" id="formLogin">

    <h2>Login</h2>
    <input name="loginNome" required type="text" placeholder="Login">

    <h2>Senha</h2>
    <input name="loginSenha" required type="password" placeholder="Senha">

    <br />
    <input type="submit" value="login" id="inputLogin">

    <h4 id="muda">Não possui login? Cadastre-se aqui!</h4>

    <br />
    <span name="erro">${erro}</span>
</form>

<!--
<form id="formCadastro">

    <h3>Digite seu nome de login</h3>
    <input name="cadNome" type="text" placeholder="Login"/>

    <h3>Digite sua senha</h3>
    <input name="cadSenha" type="password" />

    <h3>Digite sua senha novamente</h3>
    <input name="cadSenha2" type="password"/>

    <h3>Digite seu Email</h3>
    <input name="inEmail" />
    <br />
    <button id="btnCadastrar">Cadastrar-se</button>


</form>-->

</body>
</html>
