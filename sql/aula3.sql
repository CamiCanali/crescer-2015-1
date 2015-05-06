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

--10

truncate table CopiaCidade
<<<<<<< HEAD
begin transaction
go
=======

>>>>>>> 713a7bf864ee7d6831277792a92b64ab87cdca4d
insert into CopiaCidade
		(IDCidade, Nome, UF)
SELECT MIN(IDCIDADE) Menor_idcidade,
		Nome,
		Uf
FROM Cidade
GROUP BY Nome, UF;

select * from CopiaCidade
<<<<<<< HEAD
commit
=======

>>>>>>> 713a7bf864ee7d6831277792a92b64ab87cdca4d
update Associado
set IDCidade = NULL
DELETE Cidade

--11
begin transaction
go
update Cidade
set Nome = '* ' + Nome
where nome in (Select nome
			from Cidade
			group by nome
			having count(1) >1);
--teste			
			rollback
select * from cidade order by Nome;
COMMIT

--12
select nome, 
		CASE sexo
		when 'm' then 'Masculino'
		when 'f' then 'Feminino'
		else 'outro'
		End Genero
from Associado;

--13
select nomeEmpregado, 
	   salario,
	   Case when Salario between 1164.01 and 2326 then (Salario*0.15)
			when Salario > 2326 then (Salario*0.275)
			else 0
	   End Desconto_IR
From Empregado

---14
Begin Transaction
go
delete from cidade
where idcidade in (select MAX(IDCidade)
					from Cidade
					group by Nome, UF
					having count (1)>1)
<<<<<<< HEAD
commit
=======
>>>>>>> 713a7bf864ee7d6831277792a92b64ab87cdca4d

select MAX(IDCidade) maior_IDCidade_Duplicada
from Cidade
Group by nome, uf
having count (1)>1;

select nome, uf
from cidade
group by nome, uf
having count (1)>1
rollback
commit
select * from Cidade order by Nome

--15
alter table cidade
	add constraint UK_Cidade_nomeUF
	unique(nome, uf);