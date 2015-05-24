var urlInicio = 'http://karatekid.instaweb.com.br:4567';

function recebeResposta(dados){
  $('#nome').text(dados.nome);
  $('#mensagem').text(dados.mensagem);
  var urlTarefas = urlInicio + '/tarefas?nome=' + dados.nome;
  $.get(urlTarefas, function(atividades){
    executaTarefa(atividades.atividades, dados.nome);
  });
}

function apresentar(){
  $.ajax({
  url: urlInicio + '/apresentar?nome=Camila',
  type: 'post',
  dataType: 'json',
  data: '{"nome":"Camila"}',
  success: recebeResposta
  });
}

apresentar();

function executaTarefa(tarefas, nome){
  var atividades = [];
    for (var x = 0; x < tarefas.length; x++) {
      atividades.push($.post(urlInicio + tarefas[x].atividade + '?nome=' + nome));
    }
    $.when.apply(undefined, atividades).then(function(){
      finalizarTarefa(nome);
    });
}

function finalizarTarefa(nome){
  $.post(urlInicio + '/acabei' + '?nome=' + nome);
}
