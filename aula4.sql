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

--remover o '*' dos nomes
begin transaction
go
update Cidade
set Nome = replace(nome, '*', '')
where nome like '*%'

commit
select *from Cidade	

---3
select	count(1) as NomeCidade,
		c.uf as UF
		from Cidade c
		where not exists(select 1
						from associado
						where associado.idcidade = c.idcidade)
		group by c.UF
		
--4

select a.nome as nomeAssociado, 
	   c.nome as NomeCidade, 
	   c.uf,
	   case when c.uf in ('sc', 'pr', 'rs') then '***'
	   else null
	   end as regiao_sul
	   from Associado a
	   left join Cidade c
	   on c.IDCidade = a.IDCidade

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