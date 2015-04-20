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

--Exercícios
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
-- acabou

select count(idempregado) from empregado;
select * from empregado;

select count(1) as totalEmpregado,
		count(distinct cargo) as totalcargos
		from empregado;

select distinct cargo, idDepartamento
from empregado;

select idDepartamento,
	sum(salario) as soma,
	max(salario) as maximo,
	min(salario) as minimo
from empregado
group by IDDepartamento;

select nomeEmpregado,
	(salario + comissao) as Total_sal_a,
	(salario + (isnull(comissao,0))) as total_sal_b,
	comissao
from empregado;

--exercícios parte 2
--1
 select SUBSTRING(nome, 1, CHARINDEX(' ', nome) -1) as primeiroNome
 from Associado;
 --2
 select nome, DATEDIFF(YEAR, dataNascimento, GETDATE()) idade
 from associado;
--3
 select nomeEmpregado,
		DATEDIFF(MONTH, dataAdmissao, '31/12/2000') as mesesTrabalhados,
		dataAdmissao
 from Empregado
 where dataAdmissao between '01/05/1980' and '20/01/1982';
 --4
 select top 1 cargo as MaiorCargo
 from Empregado;
 --5
 select top 1 nome as maiorNome
 from Associado
 order by len(nome) desc;
--6
select nome,
		DATEDIFF(WEEKDAY, dataNascimento, '')