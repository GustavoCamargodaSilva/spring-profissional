INSERT INTO tb_categoria(id,descricao) VALUES (1,'Curso');
INSERT INTO tb_categoria(id,descricao) VALUES (2,'Oficina');
INSERT INTO tb_categoria(id,descricao) VALUES (3,'Atividade Complementar');

//-------CATEGORIA----------//

INSERT INTO tb_participante(id,nome,email) VALUES (1,'José Silva','jose@gmail.com');
INSERT INTO tb_participante(id,nome,email) VALUES (2,'Tiago Faria','tiago@gmail.com');
INSERT INTO tb_participante(id,nome,email) VALUES (3,'Maria do Rosario','maria@gmail.com');
INSERT INTO tb_participante(id,nome,email) VALUES (4,'Teresa Silva','teresa@gmail.com');

//------Participante--------//

INSERT INTO tb_atividade(id,nome,descricao,preco,categoria_id) VALUES (1,'CURSO DE HTML','APRENDA HTML DE FORMA PRATICA',80,1);
INSERT INTO tb_atividade(id,nome,descricao,preco,categoria_id) VALUES (2,'OFICINA DE GIT HUB','CONTROLE DE VERSOES DE SEUS PROJETOS',50,2);
INSERT INTO tb_atividade(id,nome,descricao,preco,categoria_id) VALUES (3,'ATIVIDADE COMPLEMENTAR DE JAVA','REFORÇO DE ALGORITMOS',30,3);


INSERT INTO tb_bloco(id,inicio,fim,atividade_id) VALUES (1,TIMESTAMP WITH TIME ZONE '2017-09-25T08:00:00-3',TIMESTAMP WITH TIME ZONE '2017-09-25T11:00:00-3',1);





