
var renderizarFilmes = function(filme) {
    var filmeRender = '<div class="row">' +
            '<div class="col-xs-4">' +
                '<img width="75%" height="75%" src="' + filme.imagem + '" />' +
            '</div>' +
            '<div class="col-xs-8">' +
                '<div class="row">' +
                    '<b>' + filme.nome + '</b>' +
                '</div>' +
                '<div class="row">' +
                    '<span>' + filme.genero + ', ' + filme.ano + '</span>' +
                '</div>' +
            '</div>' +
        '</div>';
    return filmeRender;
};

$.get('/buscarTodos', function(dados){
	var filmesToRender = '';

	for (var x = 0; x < dados.length; x++) {
	    filmesToRender += renderizarFilmes(dados[x]);
	}

	$('#well').html(filmesToRender);
});
