--1
Begin 
	declare @produto integer
	select @produto = max(quantidade)
	from PedidoItem
	print @produto
end


--2
begin
declare listaCidade cursor
	local
	fast_forward
	for select cidade.Nome, uf
	from cidade
	inner join cliente c on c.IDCidade = Cidade.IDCidade
	group by cidade.nome, uf 
	having count(1)>1
	declare @nome varchar(50),
			@uf varchar(2)
	open listaCidade
	fetch next from listaCidade into @nome, @uf

	while(@@FETCH_STATUS = 0)begin
		print @nome + '/'+ @uf
		fetch next from listacidade into @nome, @uf
	end

	close listacidade
	deallocate listaCidade

end

--3
create view vwMateriais as
	select count(1) 