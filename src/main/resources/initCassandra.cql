CREATE KEYSPACE target WITH replication={'class' : 'SimpleStrategy', 'replication_factor':1};

USE target;

create table productprice (
       productid bigint       
--Price
       ,price float
       ,currency_code text
       ,PRIMARY KEY ( productid)
);



insert into productprice(productid,price,currency_code) values(13860428,21,'USD');

insert into productprice(productid,price,currency_code) values(13860429,44,'USD');