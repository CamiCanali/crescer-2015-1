--1
begin
declare @idproduto integer,
		@nome varchar(100),
		@total_itens integer
select TOP 1 WITH ties
		@idproduto = PEDIDOITEM.idproduto, 
		@nome = Produto.Nome,
		@total_itens = sum(quantidade)
from PedidoItem
inner join produto on produto.IDProduto = PedidoItem.IDProduto
group by PedidoItem.IDProduto,
			produto.Nome
order by sum(quantidade) desc;
print 'Produto: ' + @nome + ' - Total vendido: ' + cast(@total_itens as varchar (10))
end

--2
begin
declare listaCidade cursor local fast_forward
	for select nome,
				uf
		from cidade
		group by Nome, uf
		having count (1) > 1 
	declare @nome varchar(50),
			@uf varchar(2),
			@total integer
	open listaCidade
	fetch next from listaCidade into @nome, @uf

	while(@@FETCH_STATUS = 0)begin
		select @total = count(1)
		from cliente cli
		where exists (select 1
						from cidade
						where cidade.IDCidade = cli.idcidade
						and cidade.nome = @nome
						and cidade.uf = @uf);
		if @total > 0
		print @nome + '/'+ @uf + 'total de clientes: ' + cast(@total as varchar (10));
		fetch next from listacidade into @nome, @uf
	end

	close listacidade
	deallocate listaCidade

end


--3

select count(distinct ped.IDPedido) total_pedidos,
count(1) total_itens
from pedido ped
	inner join PedidoItem item on item.IDPedido = ped.IDPedido
where exists (select 1
				from ProdutoMaterial pm
				where pm.IDProduto = item.IDProduto
				and pm.IDMaterial in (select IDMaterial from vmMateriais_mais_utilizados));


create view vmMateriais_mais_utilizados as
select top 1 with ties
		ma.IDMaterial, 
		ma.Descricao, 
		count(distinct pm.IDProduto) total_produto_distintos
from material ma
inner join ProdutoMaterial pm on pm.IDMaterial = ma.IDMaterial
inner join produto pr on pr.IDProduto = pm.IDProduto
group by ma.IDMaterial, ma.Descricao
order by total_produto_distintos desc
 
select ped.IDPedido, item.IDPedidoItem, pro.IDProduto, pro.Nome, item.Quantidade
from pedido ped
inner join PedidoItem item on item.IDPedido = ped.IDPedido
inner join Produto pro on pro.IDProduto = item.IDProduto
inner join ProdutoMaterial pm on pm.IDProduto = pro.IDProduto
where ped.DataPedido between DATEADD(DAY, -60, GETDATE()) and GETDATE();

create index IX_Pedido_datapedido on pedido(datapedido);