create database balanceblog;

use balanceBlog;

CREATE TABLE usuario (
  id_usuario int(11) NOT NULL AUTO_INCREMENT,
  nome_usuario varchar(150) NOT NULL,
  senha_usuario varchar(150) NOT NULL,
  email_usuario varchar(100) NOT NULL,
  papel_usuario varchar(45) NOT NULL,
  PRIMARY KEY (id_usuario),
  UNIQUE KEY id_usuario_UNIQUE (id_usuario),
  UNIQUE KEY nome_usuario_UNIQUE (nome_usuario)
);

CREATE TABLE `post` (
  `id_post` int(11) NOT NULL AUTO_INCREMENT,
  `imagem_post` varchar(500) NOT NULL,
  `titulo_post` varchar(50) NOT NULL,
  `texto_post` longtext NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_post`),
  UNIQUE KEY `id_post_UNIQUE` (`id_post`),
  UNIQUE KEY `titulo_post_UNIQUE` (`titulo_post`),
  KEY `id_usuario_idx` (`id_usuario`),
  CONSTRAINT `id_usuario_foreign` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(100) NOT NULL,
  PRIMARY KEY (`id_categoria`),
  UNIQUE KEY `id_categoria_UNIQUE` (`id_categoria`),
  UNIQUE KEY `nome_categoria_UNIQUE` (`nome_categoria`)
);

CREATE TABLE `categoriapost` (
  `id_post` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_post`,`id_categoria`),
  KEY `id_categoria_foreign_idx` (`id_categoria`),
  CONSTRAINT `id_categoria_foreign` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_post_foreign` FOREIGN KEY (`id_post`) REFERENCES `post` (`id_post`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE comentario (
  id_comentario int(11) NOT NULL AUTO_INCREMENT,
  id_post int(11) NOT NULL,
  id_usuario int(11) NOT NULL,
  texto_comentario mediumtext NOT NULL,
  PRIMARY KEY (id_comentario),
  UNIQUE KEY id_comentario_UNIQUE (id_comentario),
  KEY id_post_idx (id_post),
  KEY id_usuario_idx (id_usuario),
  CONSTRAINT id_post FOREIGN KEY (id_post) REFERENCES post (id_post) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into usuario values (1, 'pedro', '123', 'pedro@reno.com', 'adm');
insert into usuario values(6, 'teste', '123', 'teste@teste', 'user');
insert into usuario (nome_usuario, senha_usuario, email_usuario, papel_usuario) values ('robertin', '123', 'teste@teste', 'user');


insert into categoria (nome_categoria) values('taekwondo');
insert into categoria (nome_categoria) values('brucelee');
insert into categoria (nome_categoria) values('filmes');
insert into categoria (nome_categoria) values('esporte');

select * from usuario;

select * from categoria;

select * from post;

select * from categoriapost;

select * from comentario;

DELETE FROM post WHERE id_post BETWEEN 0 AND 100;

delete from post where id_post between 0 and 100;

insert into comentario (id_post, id_usuario, texto_comentario) values (23, 1, 'Cara que divertido adorei!');
insert into comentario (id_post, id_usuario, texto_comentario) values (23, 6, 'Mas que belo lixo!');
insert into comentario (id_post, id_usuario, texto_comentario) values (23, 7, 'Conteúdo impecável! Realmente ta de parabens');

SELECT * FROM comentario WHERE id_comentario = 23;


