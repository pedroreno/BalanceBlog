
$(document).ready(function () {
    var papelUsuarioLogado = $(".qDificil").attr("id");

    if(papelUsuarioLogado !== "adm") {
        $("#btnADM").hide();
    }

    // ENVIANDO MENSAGEM
    $("#btnEnviar").on('click', function () {
        alert("Sua mensagem foi enviada à nossa equipe! (mentira)");
        $("input").val("");
        $("textarea").val("");
        location.reload();
    });

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


