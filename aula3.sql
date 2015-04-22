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
 select SUBSTRING(nome, 0, CHARINDEX(' ', nome)) as primeiroNome
 from Associado;
 --2
 select nome, DATEDIFF(YEAR, dataNascimento, GETDATE()) as idade
 from associado;
--3
 select nomeEmpregado,
		DATEDIFF(MONTH, dataAdmissao, CONVERT(DATETIME, '31/12/2000', 103)) as mesesTrabalhados,
		dataAdmissao
 from Empregado
 where dataAdmissao between CONVERT(DATETIME, '01/05/1980', 103)
					 and  CONVERT(DATETIME, '20/01/1982', 103);
 --4
 select top 1 cargo as MaiorCargo
 from Empregado;
 --5
 select top 1 nome as maiorNome
 from Associado
 order by len(nome) desc;
--6
select nome,
		DATEADD(year, 50, DataNascimento) AS Cinquenta_anos_em,
		DATE(DATEADD(YEAR, 50, dataNascimento))as Dia_da_semana
from Associado
--7
select COUNT(Nome),
		uf
FROM Cidade
group by UF;
--8
Select nome, UF
from Cidade
group by nome, UF
having count(nome) >1 and count(uf) > 1;
--9
select max(idassociado)+1
from Associado;
