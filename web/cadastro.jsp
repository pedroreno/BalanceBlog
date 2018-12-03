<%--
  Created by IntelliJ IDEA.
  User: Pedro Guerrero
  Date: 12/11/2018
  Time: 15:33
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
    <link rel="stylesheet" type="text/css" href="${contexto}stylesheets/cadastro.css">
    <!--definindo icone da página-->
    <link rel="icon" href="imagens/tomato_red.png">
    <!--definindo título da página-->
    <title>Balance blog</title>
    <!--linkando com scripts-->
    <script type="text/javascript" src="${contexto}scripts/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${contexto}scripts/"></script>

</head>

<body>
<h1 id="teste">BALANCE BLOG</h1>
<h3>Informação de qualidade sobre o maravilhoso mundo das artes marciais</h3>

<form action="Cadastro.action" id="formCadastro">

    <h2>Login</h2>
    <input name="cadNome" type="text" required/>

    <h2>Senha</h2>
    <input name="cadSenha" type="password" required/>

    <h2>Senha novamente</h2>
    <input name="cadSenha2" type="password" required/>

    <h2>Email</h2>
    <input name="cadEmail" type="text" required/>
    <br />
    <input id="inputCadastrar" type="submit" value="cadastro" id="inputCadastrar">

    <br />
    <span name="erro">${erro}</span>
</form>

</body>
</html>
