create table my_schema_1.SODA (
          ID_SODA int PRIMARY KEY,
          NAME VARCHAR(50) DEFAULT NULL,
          CODE VARCHAR(50) DEFAULT NULL,
          PRICE VARCHAR(10) DEFAULT NULL
);

INSERT INTO my_schema_1.Soda VALUES(1, 'Budweiser','BUDWEISER',10);
INSERT INTO my_schema_1.Soda VALUES(2, 'Cola-Cola','COCACOLA',8);
INSERT INTO my_schema_1.Soda VALUES(3, 'Pepsi','PEPSI',9);
INSERT INTO my_schema_1.Soda VALUES(4, 'Pepsi lemonm','PEPSI',9);
INSERT INTO Soda VALUES(5, 'Cola-Cola Light','COCACOLA',18);
INSERT INTO Soda VALUES(6, 'Pepsi Max','PEPSI',12);

ALTER TABLE SODA add color varchar(20);
UPDATE SODA set color='black' where code='PEPSI';

CREATE VIEW soda_view AS SELECT name, code, color from soda;
-----------------part II

CREATE USER crc_viewer WITH PASSWORD 'crc123';

ALTER USER crc_viewer_2 with password 'crc123';
--https://www.postgresql.org/docs/8.0/sql-alteruser.html

GRANT SELECT ON SODA to crc_viewer;
GRANT CONNECT on database postgres to crc_viewer;
--GRANT DELETE on database postgres to crc_viewer;

CREATE SCHEMA my_schema_1 AUTHORIZATION crc_viewer;

GRANT SELECT ON ALL TABLES IN SCHEMA my_schema_1 to crc_viewer;

select * from my_schema_1.soda;