/* Populate tables */

INSERT INTO clientes (id_cli,nom_cli,ape_cli,email_cli,tel_cli,dir_cli) VALUES(1,'Admin','Admin','admin@admin.com','123456','admin 123');
INSERT INTO clientes (id_cli,nom_cli,ape_cli,email_cli,tel_cli,dir_cli) VALUES(2,'User','User','user@user.com','123456','user 123');
INSERT INTO clientes (id_cli,nom_cli,ape_cli,email_cli,tel_cli,dir_cli) VALUES(3,'Kimba','Blasich','kim@lala.com','123456','sanma 1274');
INSERT INTO clientes (id_cli,nom_cli,ape_cli,email_cli,tel_cli,dir_cli) VALUES(4,'Caro','Blasich','caro@lala.com','456123','ayacucho 1274');
INSERT INTO clientes (id_cli,nom_cli,ape_cli,email_cli,tel_cli,dir_cli) VALUES(5,'Claudio','Riquelme','clau@lala.com','123456','aya 944');
INSERT INTO clientes (id_cli,nom_cli,ape_cli,email_cli,tel_cli,dir_cli) VALUES(6,'Patri','Lala','patri@lala.com','456123','ayacucho 944');



INSERT INTO materias_prima (id_mp, nom_mp, marca_mp, uni_med_mp, cal_uni_med_mp, hdc_uni_med_mp, fib_uni_med_mp) VALUES(1, 'Harina de trigo', 'Andes', 'gramo', 5, 7, 14);
INSERT INTO materias_prima (id_mp, nom_mp, marca_mp, uni_med_mp, cal_uni_med_mp, hdc_uni_med_mp, fib_uni_med_mp) VALUES(2, 'Dulce de leche', 'San Ignacio', 'gramo', 10, 20, 25);
INSERT INTO materias_prima (id_mp, nom_mp, marca_mp, uni_med_mp, cal_uni_med_mp, hdc_uni_med_mp, fib_uni_med_mp) VALUES(3, 'Chocolate repostero', 'Aguila', 'gramo', 15, 30, 30);

INSERT INTO productos (id_pro,tipo_pro,nom_pro,dsc_pro,can_por_pro,cal_porc_pro,hdc_porc_pro,fib_porc_pro,pre_pro, imagen) VALUES (1,'Tradicional','Pastafrola','Pastafrola de membrillo',8,30,35,50,180, '6ca3d0cf-6181-4bc3-809a-91758cacb4f8_pastafrola.jpg');
INSERT INTO productos (id_pro,tipo_pro,nom_pro,dsc_pro,can_por_pro,cal_porc_pro,hdc_porc_pro,fib_porc_pro,pre_pro, imagen) VALUES (2,'Saludable','Empanadas','Empanadas al horno',12,50,60,40,250, '3b0b6893-96b9-4bd3-b88e-c5bf4538ee65_empanadas.jpeg');
INSERT INTO productos (id_pro,tipo_pro,nom_pro,dsc_pro,can_por_pro,cal_porc_pro,hdc_porc_pro,fib_porc_pro,pre_pro, imagen) VALUES (3,'Tradicional','Alfajores','Alfajores con maicena',6,35,30,40,100, '290da5de-8898-4e1c-b63e-3778131b008e_alfajores.jpg');
INSERT INTO productos (id_pro,tipo_pro,nom_pro,dsc_pro,can_por_pro,cal_porc_pro,hdc_porc_pro,fib_porc_pro,pre_pro, imagen) VALUES (4,'Saludable','Flan','Flan con chocolate',4,20,25,32,80, 'ffe48425-3783-41d6-afca-5ba13c6a1423_flan.jpg');

/* Usuarios con sus roles */
INSERT INTO usuarios (username, password, enabled, cliente_id) VALUES ('user','$2a$10$4nRLGo/n84lB9ebfS64xz.Nwo1Dy74/VkKmeldo8GUhIG8Z5hq4Ua',1,2);
INSERT INTO usuarios (username, password, enabled, cliente_id) VALUES ('admin','$2a$10$WywtLWRiN8UUcT2RRBlX9edi5B.8C1IKYHxqIvCzppe/C1YihJpNW',1,1);


INSERT INTO roles (usuario_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO roles (usuario_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO roles (usuario_id, authority) VALUES (2,'ROLE_USER');
INSERT INTO roles (usuario_id, authority) VALUES (3,'ROLE_ADMIN');