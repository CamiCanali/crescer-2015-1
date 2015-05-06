--1
select count(distinct situacao) 
from Produto

--2
select idcliente, nome, razaoSocial
from Cliente
where nome like '%LTDA%'
		or razaoSocial like '%LTDA%'

---UPPER MAIÚSCULO E LOWER MINÚSCULO

--3
INSERT into Produto(Nome, PrecoCusto, PrecoVenda, Situacao)
values ('Galocha Maragato', 35.67, 77.95, 'a')
select * from Produto
order by nome

--4
select idproduto, nome
from produto
where not exists (select 1
					from PedidoItem
					where PedidoItem.IDProduto = Produto.IDProduto)

create index IX_PedidoItem_Produto on PedidoItem(IDProduto)
--OUTRA OPÇÃO

select p.idproduto, p.nome
from Produto p
	left join PedidoItem item on item.idproduto = p.IDProduto
where item.idpedido is null

---5
create view vwEstados as
select cid.uf, count(1) as totalClientes
from Cidade cid
inner join cliente c on c.IDCidade = cid.idcidade
group by cid.uf

select * from vwEstados
where totalClientes = (select min (totalClientes) from vwEstados)
or totalClientes = (select max(totalClientes) from vwEstados)

--6
select count(distinct nome) totalCidades
from Cidade
where exists (select 1
				from Cliente cli
				inner join pedido p on p.idcliente = cli.idcliente
				where cli.idcidade = cidade.IDCidade)

select COUNT(distinct cid.nome) as totalCidades
from Cidade cid
inner join Cliente cli on cli.idcidade = cid.IDCidade
inner join pedido p on p.idcliente = cli.idcliente

--7
select p.IDProduto, p.Nome
from Produto p
where not exists(select 1
			from ProdutoMaterial pm
			where pm.IDProduto = p.IDProduto)

--8
select idproduto,
		nome,
		precocusto,
		dbo busca_precocusto_material(idproduto) as valordecusto

create function busca_precoCusto_Material (@idProduto int)
return decimal (9,2) as
begin
declare @precoCusto decimal(9,2)

select @precocusto = sum (ma.precoCusto * ISNULL(pm.quantidade, 1))
from ProdutoMaterial pm
inner join Material m on m.IDMaterial = pm.IDMaterial
where pm.idproduto = @idProduto
return @precoCusto
end

--9
