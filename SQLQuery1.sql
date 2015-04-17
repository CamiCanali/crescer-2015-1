Create table Client
(
	IDCliente int IDENTITY NOT NULL,
	Nome varchar(30) NOT NULL,
	Endereço varchar(35),
	Bairro varchar(35),
	IDCidade int
);

INSERT INTO Client
	(Nome,
	Endereço,
	Bairro)
VALUES
	('Maria',
	'Rua Bento Gonçalves, 123',
	'Centro');

select * from Client

INSERT INTO Cidade VALUES (2, 'Novo Hamburgo', 'RS');

INSERT INTO Client
VALUES
(100,
'Maria',
'Rua Bento Gonçalves, 123',
'Centro', 
10);

drop table Cidade;
Create table Cidade
(
IDCidade int NOT NULL,
Nome varchar(30) NOT NULL,
UF varchar(2) NOT NULL,
	constraint PK_Cidade Primary Key (IDCidade),
	constraint UK_Cidade_Nome Unique(Nome)
);

select * from Cidade

Create table Empregado
(
IDEmpregado int NOT NULL,
Nome varchar(50) NOT NULL,
Sexo char(1) NOT NULL,
	constraint PK_Empregado Primary Key(IDEmpregado),
	constraint CC_Empregado_Sexo Check (Sexo in('F', 'M')),
	constraint FK_Empregado_Cidade Foreign Key (IDCidade)
		references Cidade (IDCidade)
);