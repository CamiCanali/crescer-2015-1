<html>
<script>
var chelsea = {
  nome: 'Chelsea Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 5 },
    { desc: 'Continentais', qtd: 1 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var arsenal = {
  nome: 'Arsenal Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 13 },
    { desc: 'Continentais', qtd: 1 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var liverpool= {
  nome: 'Liverpool Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 18 },
    { desc: 'Continentais', qtd: 3},
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var manchester= {
  nome: 'Manchester United Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 20 },
    { desc: 'Continentais', qtd: 3},
    { desc: 'Mundiais', qtd: 2}
  ]
};

var clubes = [chelsea, arsenal, liverpool, manchester];

//ordena clubes por titulos e por índice
function ordenaTitulos(array, i){
  return(array.sort(function (a,b){
    return a.titulos[i].qtd < b.titulos[i].qtd;
  }));
}

//ordena array de clubes por nacionais
var ordenaPorNacionais = function (clubes){
  return ordenaTitulos(clubes, 0);
}
//ordena array de clubes por continentais
var ordenaPorContinentais = function (clubes){
  return ordenaTitulos(clubes, 1);
}
//ordena array de clubes por nacionais
var ordenaPorMundiais = function (clubes){
  return ordenaTitulos(clubes, 0);
}

//soma titulos dos clubes por índice
function somarTitulos(array, i){
  var soma = 0;
  array.map(function(a){
    soma = soma + a.titulos[i].qtd;
  });
  return soma;
}
//soma os titulos de todos os clubes por nacionais
var somaNacional = function(clubes){
  return somarTitulos(clubes,0);
}
//soma os titulos de todos os clubes por continentais
var somaContinental = function(clubes){
  return somarTitulos(clubes,1);
}
//soma os titulos de todos os clubes por mundiais
var somaTodos = function(clubes){
  return somarTitulos(clubes,0) + somarTitulos(clubes,1) + somarTitulos(clubes,2);
}
//função que percorre o arrray de clubes
//e retorna os que possuem título nacional >18
function filtroMais18(array){
  return array.titulos[0].qtd > 18;
}
//chama o filtroMais18
var apenasOsMelhores = function(array){
  return array.filter(function (a){
    return filtroMais18(a);
  });
}
//retorna tipo JSON JavaScript Object Notation
var apenasOsMelhoresParaJSON = function (array){
  return JSON.stringify(apenasOsMelhores(array));
}
var apenasOsMelhoresRecebdnoJSON = function(String){
  return JSON.parse(String);
}
</script>
</html>
