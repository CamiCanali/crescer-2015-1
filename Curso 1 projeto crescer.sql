create table Pessoa (
IDPessoa Integer not null,
Nome Varchar2(50) not null,
Data_Nascimento date,
Endereco varchar2(35),
Cidade varchar2(50),
UF varchar2(2),
constraint PK_Pessoa primary key (IDPessoa)
);

create sequence sqPessoa;

Insert into Pessoa (IDPessoa, Nome, Data_Nascimento, Endereco, Cidade, UF)
    Values(sqPessoa.nextval, 
    'Maria Cavalcante', 
    to_date('01/02/1990', 'dd/mm/yyyy'),
    'Rua A, 230', 
    'Taquara', 
    'RS');
    
Insert into Pessoa (IDPessoa, Nome, Data_Nascimento, Endereco, Cidade, UF)
    Values(sqPessoa.nextval, 
    'Pedro de Souza', 
    to_date('21/03/1985', 'dd/mm/yyyy'),
    'Av. Ipiranga, 4200',
    'Porto Alegre', 
    'RS');
    
Insert into Pessoa (IDPessoa, Nome, Data_Nascimento, Endereco, Cidade, UF)
    Values(sqPessoa.nextval, 
    'Gustavo Kuerten',
    to_date('10/09/1976', 'dd/mm/yyyy'),
    'Praia', 
    'Florianópolis', 
    'SC');
Commit;

SELECT * FROM PESSOA;

ROLLBACK;
