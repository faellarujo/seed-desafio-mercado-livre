-- Password: password
INSERT INTO USERS (username, password) VALUES ('username', '$2a$10$GiseHkdvwOFr7A9KRWbeiOmg/PYPhWVjdm42puLfOzR/gIAQrsAGy');
INSERT INTO USERS (username, password) VALUES ('raphael',  '$2a$12$H831gAdSJ7W598XNq25iBu8Ocj2XCRW45UfMKSXgJHtlqOut4R2ia');
INSERT INTO USERS (username, password) VALUES ('joao',  '$2a$12$H831gAdSJ7W598XNq25iBu8Ocj2XCRW45UfMKSXgJHtlqOut4R2ia');
INSERT INTO USERS (username, password) VALUES ('maria',  '$2a$12$H831gAdSJ7W598XNq25iBu8Ocj2XCRW45UfMKSXgJHtlqOut4R2ia');
INSERT INTO USERS (username, password) VALUES ('admin',  '$2a$12$H831gAdSJ7W598XNq25iBu8Ocj2XCRW45UfMKSXgJHtlqOut4R2ia');
INSERT INTO USERS (username, password) VALUES ('user',  '$2a$12$H831gAdSJ7W598XNq25iBu8Ocj2XCRW45UfMKSXgJHtlqOut4R2ia');

INSERT INTO categoria (nome) VALUES ('Instrumentos musical');
INSERT INTO categoria (nome) VALUES ('Casa e decoração');
INSERT INTO categoria (nome) VALUES ('Jardinagem');
INSERT INTO categoria (nome) VALUES ('Telefonia');
INSERT INTO categoria (nome) VALUES ('Material de escritório');

INSERT INTO caracteristica (peso, cor, tamanho) VALUES (1.5, 'Preto', 'G');
INSERT INTO caracteristica (peso, cor, tamanho) VALUES (2.5, 'Amarelo', 'M');
INSERT INTO caracteristica (peso, cor, tamanho) VALUES (3.5, 'Azul', 'GG');
INSERT INTO caracteristica (peso, cor, tamanho) VALUES (3.5, 'Azul', 'P');
INSERT INTO caracteristica (peso, cor, tamanho) VALUES (3.5, 'Azul', 'XG');

INSERT INTO vendedor (email, nome, senha) VALUES ('Raphael', 'raphaelaraujo.ti@gmail.com','123456');
INSERT INTO vendedor (email, nome, senha) VALUES ('Joao', 'joasilva.ti@gmail.com','admin');
INSERT INTO vendedor (email, nome, senha) VALUES ('Maria', 'mariaantunes.ti@gmail.com','123');
INSERT INTO vendedor (email, nome, senha) VALUES ('Tiao', 'tiaogil.ti@gmail.com','admin');
INSERT INTO vendedor (email, nome, senha) VALUES ('Matos', 'matotorres.ti@gmail.com','admin');


INSERT INTO produto (nome, valor,  quantidade, caracteristica_id, descricao, categoria_id, usuario_id) VALUES ('Mesa', 500, 5, 2, 'Mesa de jantar', 2, 2);
INSERT INTO produto (nome, valor,  quantidade, caracteristica_id, descricao, categoria_id, usuario_id) VALUES ('Cadeira', 100, 10, 3, 'Cadeira de jantar', 2, 1);
INSERT INTO produto (nome, valor,  quantidade, caracteristica_id, descricao, categoria_id, usuario_id) VALUES ('Violão', 1000, 2, 1, 'Violão de corda de aço', 1, 3);
INSERT INTO produto (nome, valor,  quantidade, caracteristica_id, descricao, categoria_id, usuario_id) VALUES ('Guitarra', 1500, 1, 4, 'Guitarra de corda de aço', 1, 4);
INSERT INTO produto (nome, valor,  quantidade, caracteristica_id, descricao, categoria_id, usuario_id) VALUES ('Cama', 800, 3, 5, 'Cama de casal', 2, 5);


INSERT INTO OPINIAO (nota, titulo, descricao, usuario_id, produto_id) VALUES (1, 'Muito', 'Muito bom', 1, 1);
INSERT INTO OPINIAO (nota, titulo, descricao, usuario_id, produto_id) VALUES (2, 'rasoavel', 'Recomendo', 2, 2 );
INSERT INTO OPINIAO (nota, titulo, descricao, usuario_id, produto_id) VALUES (3, 'Meia vida', 'Não recomento', 3,3);
INSERT INTO OPINIAO (nota, titulo, descricao, usuario_id, produto_id) VALUES (4, 'Pessimo', 'Não recomento', 4, 4);
INSERT INTO OPINIAO (nota, titulo, descricao, usuario_id, produto_id) VALUES (5, 'Horrivel', 'Não recomento', 5, 5);


Insert into pergunta (usuario_id, vendedor_id, descricao, titulo) values (1, 1, 'Qual o valor do frete?', 'Frete');
Insert into pergunta (usuario_id, vendedor_id, descricao, titulo) values (2, 2, 'Qual o valor do frete?', 'Frete');
Insert into pergunta (usuario_id, vendedor_id, descricao, titulo) values (3, 3, 'Qual o valor do frete?', 'Frete');
Insert into pergunta (usuario_id, vendedor_id, descricao, titulo) values (4, 4, 'Qual o valor do frete?', 'Frete');
Insert into pergunta (usuario_id, vendedor_id, descricao, titulo) values (5, 5, 'Qual o valor do frete?', 'Frete');