create database x;

drop database x;

use x;

create table tesouro(
 id_tesouro	int primary key,
 titulo varchar(200),
 opcaoA varchar(200),
 opcaoB varchar(200), 
 opcaoC varchar(200),
 resposta int, 
 escolha int,
 id_usuario int);
 
create table usuario_simples(
id_usuario int not null primary key auto_increment,
nome varchar(200));
 
create table resposta_tesouro(
id_resposta_tesouro int not null primary key auto_increment,
id_pergunta int,
resposta int,
id_usuario int,
foreign key(id_usuario) references usuario_simples(id_usuario)); 

create table resultado_tesouro(
id_resultado_tesouro int not null primary key auto_increment,
total_corretas int,
nome varchar(200),
id_usuario int,
foreign key(id_usuario) references usuario_simples(id_usuario));


insert into tesouro(id_tesouro, titulo, opcaoA, opcaoB, opcaoC, resposta, escolha, id_usuario)
values(
	1, 
	'Quais são títulos públicos que possuem cobertura do Fundo Garantidor de Crédito (FGC)?',  
	'Tesouro Prefixado (LTN)',
	'Tesouro Prefixado com Juros Semestrais (NTN-F) e Tesouro IPCA+ (NTN-B Principal)',
	'Títulos públicos não possuem FGC',
	3,
	-1,
    -1);

insert into tesouro(id_tesouro, titulo, opcaoA, opcaoB, opcaoC, resposta, escolha, id_usuario)
values(
	2, 
	'Uma aplicação pelo prazo de 360 dias corridos, recolherá imposto de renda sobre o rendimento à alíquota de?',  
	'27,5%',
	'20%',
	'15%',
	2,
	-1,
    -1);
  
insert into tesouro(id_tesouro, titulo, opcaoA, opcaoB, opcaoC, resposta, escolha, id_usuario)
values(
	3, 
	'Em aplicações com prazo inferior de 30 dias corridos. Qual será a tributação no resgate?',  
	'IR e IOF',
	'IR',
	'Nenhum tributação incide',
	1,
	-1,
    -1);

insert into tesouro(id_tesouro, titulo, opcaoA, opcaoB, opcaoC, resposta, escolha, id_usuario)
values(
	4, 
	'Qual título abaixo é pós-fixado?',  
	'Letra Financeira do Tesouro (LFT)',
	'Letras do Tesouro Nacional(LTN)',
	'Tesouro IPCA+ (NTN-B Principal)',
	1,
	-1,
    -1);
    
    
insert into tesouro(id_tesouro, titulo, opcaoA, opcaoB, opcaoC, resposta, escolha, id_usuario)
values(
	5, 
	'A Letra Financeira do Tesouro (LFT) remunera os investidores com juros',  
	'No vencimento, com base na Taxa DI',
	'Semestrais, com base na Taxa Selic',
	'No vencimento, com base na Taxa Selic',
	3,
	-1,
    -1);
        
select * from tesouro;

select * from usuario_simples;

select * from resposta_tesouro;

select * from resultado_tesouro;

