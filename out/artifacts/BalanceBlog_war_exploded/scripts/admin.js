$(document).ready(function () {

    // LIMPANDO CAMPOS AO INICIAR OU REINICIAR A PAGINA
    $("#imgPost").val('');
    $("#tituloPost").val('');
    $("#textoPost").val('');
    $("#tituloPostExcluir").val('');
    $("#idPostExcluir").val('');
    $("#nomeUsuarioExcluir").val('');
    $("#idUsuarioExcluir").val('');
    //----------------------------------------------------------

    // ESCONDENDO TODAS AS DIVS
    $("#divAddPost").hide();
    $("#divExcluirPost").hide();
    $("#divListarUsuarios").hide();
    $("#divExcluirUsuario").hide();
    //--------------------------------------------------------

    // APRESENTANDO A DIV REQUISITADA ENQUANTO ESCONDE AS OUTRAS
    $("#btnAddPost").on('click', function () {
        $("#divAddPost").show();
        $("#divExcluirPost").hide();
        $("#divListarUsuarios").hide();
        $("#divExcluirUsuario").hide();
    });

    $("#btnExcluirPost").on('click', function () {
        $("#divAddPost").hide();
        $("#divExcluirPost").show();
        $("#divListarUsuarios").hide();
        $("#divExcluirUsuario").hide();
    });

    $("#btnListarUsuarios").on('click', function () {
        $("#divAddPost").hide();
        $("#divExcluirPost").hide();
        $("#divListarUsuarios").show();
        $("#divExcluirUsuario").hide();
    });

    $("#btnExcluirUsuario").on('click', function () {
        $("#divAddPost").hide();
        $("#divExcluirPost").hide();
        $("#divListarUsuarios").hide();
        $("#divExcluirUsuario").show();
    });
    //---------------------------------------------------------------

    // ADICIONANDO POST
    $("#inputAddPost").on('click',function () {
        alert("Post cadastrado com sucesso!");
    });
    //------------------------------------------------------------

    // EXCLUINDO POST
    $("#inputExcluirPost").on('click', function () {
        var titulo = $("#tituloPostExcluir").val();
        var id = $("#idPostExcluir").val();

        if(titulo == "" && id == "") $("#erroExcluirPost").html("Um dos campos deve ser preenchido!");
        else {
            $.ajax({
                method: 'post',
                url: "/ExcluirPost.action",
                data: {
                    titulo: titulo,
                    id: id
                }
            });
            alert("Post excluído com sucesso!");
            window.location.reload();
        }
    });
    //-----------------------------------------------------------

    // EXCLUINDO USUÁRIO
    $("#inputExcluirUsuario").on('click', function () {
        var nome = $("#nomeUsuarioExcluir").val();
        var id = $("#idUsuarioExcluir").val();

        if(nome == "" && id == "") $("#erroExcluirUsuario").html("Um dos campos deve ser preenchido!");
        else {
            $.ajax({
                method: 'post',
                url: '/ExcluirUsuario.action',
                data: {
                    nome: nome,
                    id: id
                }
            });
            alert("Usuário excluído com sucesso!");
            window.location.reload();


        }

    });
});