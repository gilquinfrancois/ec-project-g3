CREATE TABLE IF NOT EXISTS products  (
                            id SERIAL,
                            productName varchar(32),
                            price int,
                            category varchar(32),
                            description varchar(254)
);