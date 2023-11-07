create table clientes (

	id_clientes int auto_increment primary key,
    nome varchar(50) not null,
    cpf varchar(11) not null,
    telefone char(19) not null,
    email varchar(50) not null,
    sexo char(1) not null,
    estadoCivil varchar(12) not null,
    dataNascimento date not null,
    endereco int not null

);

ALTER TABLE clientes RENAME COLUMN endereco TO fk_endereco;

create table endereco (

	id_endereco int auto_increment primary key,
	logradouro varchar(150) not null,
    numero smallint not null,
    cidade varchar(50) not null,
    bairro varchar(50) not null,
    complemento varchar(200) default null
    
);



ALTER TABLE clientes
ADD CONSTRAINT endereco
FOREIGN KEY (fk_endereco) REFERENCES endereco(id_endereco);

ALTER TABLE clientes DROP FOREIGN KEY clientes_ibfk_1;

