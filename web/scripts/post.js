$(document).ready(function () {
    var papelUsuarioLogado = $(".qDificil").attr("id");

    if(papelUsuarioLogado !== "adm") {
        $("#btnADM").hide();
    }

    // REDIRECIONANDO PARA A PAGINA DE CATEGORIA SELECIONADA
    $(".tag").on('click', function () {
        var tag = $(this).text();

        alert("PQ NÃO FUNCIONA VELHO");

        $.ajax({
            method: 'post',
            url: '/DirecionarPaginaCategoria.action',
            data: {tag: tag}
        });


        window.location.assign("pageCategoria.jsp");

    });
});