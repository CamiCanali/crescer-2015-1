
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

var soma = 0;

function somarNacional(i){
	soma = soma + i.titulos[0].qtd;
}
//ordenada por nacionais-
clubes.sort(function (a,b){
	return a.titulos[0].qtd < b.titulos[0].qtd});
//ordenada por continentais
clubes.sort(function (a,b){
	return a.titulos[1].qtd < b.titulos[1].qtd});
//ordenada por mundiais
clubes.sort(function (a,b){
	return a.titulos[2].qtd < b.titulos[2].qtd});	
	
//somar por nacionais
clubes.map(somar())
