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
  `imagem_post` mediumblob,
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

insert into usuario values (1 ,'pedro', '123', 'pedro@reno.com', 'adm');

select * from usuario;

insert into categoria (nome_categoria) values('taekwondo');
insert into categoria (nome_categoria) values('brucelee');
insert into categoria (nome_categoria) values('filmes');
insert into categoria (nome_categoria) values('esporte');

select * from categoria;

select * from post;

select * from categoriapost;



