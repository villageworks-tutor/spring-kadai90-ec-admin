-- カテゴリーテーブルデータ
INSERT INTO categories (name) VALUES ('本');
INSERT INTO categories (name) VALUES ('DVD');
INSERT INTO categories (name) VALUES ('ゲーム');

-- 商品テーブルデータ
INSERT INTO items (category_id, name, price) VALUES (1, 'Javaの基本', 2500);
INSERT INTO items (category_id, name, price) VALUES (1, 'MLB Fun', 980);
INSERT INTO items (category_id, name, price) VALUES (1, '料理BOOK', 1200);

INSERT INTO items (category_id, name, price) VALUES (2, 'なつかしのアニメシリーズ', 2000);
INSERT INTO items (category_id, name, price) VALUES (2, 'The Racer', 1000);
INSERT INTO items (category_id, name, price) VALUES (2, 'Space Wars 3', 1800);

INSERT INTO items (category_id, name, price) VALUES (3, 'パズルゲーム', 780);
INSERT INTO items (category_id, name, price) VALUES (3, 'Invader Fighter', 3400);
INSERT INTO items (category_id, name, price) VALUES (3, 'Play the BasketBall', 2200);

-- 顧客テーブルData：：
INSERT INTO customers (name, address, tel, email) VALUES('田中太郎', '東京', '090-1111-1111', 'tanaka@aaa.com');
INSERT INTO customers (name, address, tel, email) VALUES('鈴木一郎', '大阪', '090-2222-222', 'suzuki@aaa.com');
