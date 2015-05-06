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
<<<<<<< HEAD

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

=======
	
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
>>>>>>> 713a7bf864ee7d6831277792a92b64ab87cdca4d
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