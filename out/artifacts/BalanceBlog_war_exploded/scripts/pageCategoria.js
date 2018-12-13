$(document).ready(function () {
    var papelUsuarioLogado = $(".qDificil").attr("id");

    if(papelUsuarioLogado !== "adm") {
        $("#btnADM").hide();
    }

    // REDIRECIONANDO PARA A PAGINA DE CATEGORIA SELECIONADA
    $(".tag").on('click', function () {
        var tag = $(this).text();

        $("#divPosts").innerHTML.hide();

        $.ajax({
            method: 'post',
            url: '/DirecionarPaginaCategoria.action',
            data: {tag: tag}
        });

        location.reload();


    });
});