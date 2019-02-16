/* Populate tables */
INSERT INTO clientes (id_cli,nom_cli,ape_cli,email_cli,tel_cli,dir_cli) VALUES(1,'Kimba','Blasich','kim@lala.com','123456','sanma 1274');
INSERT INTO clientes (id_cli,nom_cli,ape_cli,email_cli,tel_cli,dir_cli) VALUES(2,'Caro','Blasich','caro@lala.com','456123','ayacucho 1274');
INSERT INTO clientes (id_cli,nom_cli,ape_cli,email_cli,tel_cli,dir_cli) VALUES(3,'Claudio','Riquelme','clau@lala.com','123456','aya 944');
INSERT INTO clientes (id_cli,nom_cli,ape_cli,email_cli,tel_cli,dir_cli) VALUES(4,'Patri','Lala','patri@lala.com','456123','ayacucho 944');

INSERT INTO materias_prima (id_mp, nom_mp, marca_mp, uni_med_mp, cal_uni_med_mp, hdc_uni_med_mp, fib_uni_med_mp) VALUES(1, 'Harina de trigo', 'Andes', 'gramo', 5, 7, 14);
INSERT INTO materias_prima (id_mp, nom_mp, marca_mp, uni_med_mp, cal_uni_med_mp, hdc_uni_med_mp, fib_uni_med_mp) VALUES(2, 'Dulce de leche', 'San Ignacio', 'gramo', 10, 20, 25);
INSERT INTO materias_prima (id_mp, nom_mp, marca_mp, uni_med_mp, cal_uni_med_mp, hdc_uni_med_mp, fib_uni_med_mp) VALUES(3, 'Chocolate repostero', 'Aguila', 'gramo', 15, 30, 30);

INSERT INTO productos (id_pro,tipo_pro,nom_pro,dsc_pro,can_por_pro,cal_porc_pro,hdc_porc_pro,fib_porc_pro,pre_pro, imagen) VALUES (1,'Tradicional','Pastafrola','Descripción del Producto 1',8,1,1,1,10.5, '');
INSERT INTO productos (id_pro,tipo_pro,nom_pro,dsc_pro,can_por_pro,cal_porc_pro,hdc_porc_pro,fib_porc_pro,pre_pro, imagen) VALUES (2,'Saludable','Empanadas','Descripción del Producto 2',12,1,1,1,11.5, '');

/* Usuarios con sus roles */
INSERT INTO usuarios (username, password, enabled) VALUES ('user','$2a$10$4nRLGo/n84lB9ebfS64xz.Nwo1Dy74/VkKmeldo8GUhIG8Z5hq4Ua',1);
INSERT INTO usuarios (username, password, enabled) VALUES ('admin','$2a$10$WywtLWRiN8UUcT2RRBlX9edi5B.8C1IKYHxqIvCzppe/C1YihJpNW',1);
INSERT INTO usuarios (username, password, enabled) VALUES ('prueba@prueba.com','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);


INSERT INTO roles (usuario_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO roles (usuario_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO roles (usuario_id, authority) VALUES (2,'ROLE_USER');
INSERT INTO roles (usuario_id, authority) VALUES (3,'ROLE_ADMIN');