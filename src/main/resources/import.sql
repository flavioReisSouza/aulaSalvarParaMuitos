INSERT INTO tb_category (name) VALUES ('Livros');
INSERT INTO tb_category (name) VALUES ('Games');
INSERT INTO tb_category (name) VALUES ('Eletrônicos');

INSERT INTO tb_product (name, price) VALUES ('The Lord of the Rings', 90.0);
INSERT INTO tb_product (name, price) VALUES ('Diablo IV', 400.0);
INSERT INTO tb_product (name, price) VALUES ('Smart TV', 2800.0);
INSERT INTO tb_product (name, price) VALUES ('PC Gamer', 5000.0);

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 2);
