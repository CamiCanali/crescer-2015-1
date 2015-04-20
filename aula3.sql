select idcidade,
	nome as [cidades]
from cidade


select NomeEmpregado as Nome,
		salario as SalarioMensal,
		(salario*12) as salarioAnual
from Empregado;

Select idcidade, nome, uf
from cidade
order by uf desc, nome asc;

select idcidade, nome, uf
from cidade
where nome like '%a%'

select idempregado, nomeEmpregado
from empregado
where salario >= 1000
	and salario <= 1500

//Exercícios
select nomeEmpregado, dataAdmissao
from empregado
order by dataAdmissao;

select nomeEmpregado, 
		(salario*12) as salarioAnual
from empregado
where cargo = 'atendente'
		or (salario*12) < 18500;

select idCidade
from Cidade
where nome = 'Uberlândia';

select idcidade, nome
from cidade
where uf = 'RS';
// acabou