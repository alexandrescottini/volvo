PARA RODAR O PROJETO:
1 - Instale o Mysql no seu computador.
2 - Instale o Postman para faze as requisições REST
3 - importe o projeto para o eclipse e rode a classe ProvaApplication.java

##-------------------##

----------------------------------------------------------------------------------------
Abra o Postman siga as intruções abaixo para salvar, listar, buscar, atualizar e excluir.
----------------------------------------------------------------------------------------
SALVAR:
Para salvar usuario -> selecione o metodo POST no postman e cole o corpo do json abaixo 
url -> localhost/usuarios
{
"nome": "josé",
    "descricao": "asdf asdf",
    "idDpto": 1,
    "idPermissao": 1
}


ATUALIZAR:
Para atulizar -> selecione o metodo PUT no postman e modifique algum valor do json abaixo
url -> localhost/usuarios/{codigo do usuario no banco}
ex: localhost/usuarios/1
{
"nome": "josé",
    "descricao": "asdf asdf",
    "idDpto": 1,
    "idPermissao": 1
}


LISTAR:
para listar todos usuarios -> selecioine o metho GET no postman
url -> localhost/usuarios


BUSCAR POR ID:
para buscar por id -> selecioine o metho GET no postman
url -> localhost/usuarios/{codigo do usuario no banco}
ex: localhost/usuarios/1


EXCLUIR
para excluir usuario -> selecione o methodo DELETE no postman
url -> localhost/usuarios/{codigo do usuario no banco}
ex: localhost/usuarios/1


------------------------------------------------------------------------
caso o hibernate não crie as tabelas automaticamente crie manualmente no mysql com o script abaixo
------------------------------------------------------------------------

CREATE TABLE `permissao` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(100) NOT NULL,
	`descricao` VARCHAR(200) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;

insert into permissao(nome,descricao) values('admin','administrador do sistema');
insert into permissao(nome,descricao) values('funcionário','empregado da empresa');


CREATE TABLE `departamento` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(100) NOT NULL,
	`descricao` VARCHAR(200) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;

insert into departamento(nome,descricao) values('administrativo','setor administrativo');
insert into departamento(nome,descricao) values('operacional','setor geral de operações');




CREATE TABLE `usuario` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(100) NOT NULL,
	`descricao` VARCHAR(200) NULL DEFAULT NULL,
	`id_departamento` BIGINT(20) NULL DEFAULT NULL,
	`id_permissao` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_usuario_departamento` (`id_departamento`),
	INDEX `FK_usuario_permissao` (`id_permissao`),
	CONSTRAINT `FK_usuario_departamento` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`),
	CONSTRAINT `FK_usuario_permissao` FOREIGN KEY (`id_permissao`) REFERENCES `permissao` (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;

insert into usuario(nome,descricao,id_departamento,id_permissao) values('josé','teste 1',1,1);

---------------------------
fazendo a primeira consulta
---------------------------

localhost:8080/usuarios/1

----------------------------------------------------------------------------------------------------------------------------
o resulta deve ser o JSON abaixo, para atualizar/salvar mude os valores lembrando que você deve 
colocar os valores dos atributos "idDpto" e "idPermissao" conforme o id do departamento e permissão que você gravou no banco
----------------------------------------------------------------------------------------------------------------------------

{
    "id": 1,
    "nome": "josé",
    "descricao": "teste 1",
    "idDpto": 1,
    "idPermissao": 1
}







