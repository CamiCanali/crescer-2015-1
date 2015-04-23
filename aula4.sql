---exercicios
----1
select e.nomeEmpregado, d.nomeDepartamento
	From Empregado e
	Inner Join Departamento d
		on e.IDDepartamento = d.IDDepartamento;

---2
select a.nome as NomeAssociado,
	   c.nome as NomeCidade
	from Associado A
	left JOIN Cidade c
	on a.IDCidade= c.IDCidade;
	
---3
select	count(c.nome) as NomeCidade,
		c.uf as UF
		from Cidade c
		left join Associado a
		on a.IDCidade = c.IDCidade
		
		where exists (select null)
		group by c.UF
		
--4
begin transaction
go
select a.nome, 
	   c.nome as NomeCidade
	   from Associado a
	   left join Cidade c
	   on c.IDCidade = a.IDCidade
	   update Cidade
	   set Nome = '*** ' + Nome
	   where UF in ('sc', 'pr', 'rs')
rollback
select * from Cidade order by nome
select * from Associado
---5
select e.nomeEmpregado as NomeEmpregado, 
		d.nomeDepartamento as NomeDepartamento,
		g.nomeEmpregado as NomeGerente
		from Empregado e
		inner join Departamento d
		on e.IDDepartamento = d.IDDepartamento
		INNER JOIN Empregado g on e.IDGerente = g.IDEmpregado
---6
transaction begin

CREATE TABLE CopiaEmpregado
select *
into CopiaEmpregado
from Empregado;

select * from CopiaCidade;