create table SODA (
          ID_SODA int PRIMARY KEY,
          NAME VARCHAR(50) DEFAULT NULL,
          CODE VARCHAR(50) DEFAULT NULL,
          PRICE VARCHAR(10) DEFAULT NULL
);

INSERT INTO Soda VALUES(1, 'Budweiser','BUDWEISER',10);
INSERT INTO Soda VALUES(2, 'Cola-Cola','COCACOLA',8);
INSERT INTO Soda VALUES(3, 'Pepsi','PEPSI',9);
INSERT INTO Soda VALUES(4, 'Pepsi lemonm','PEPSI',9);
INSERT INTO Soda VALUES(5, 'Cola-Cola Light','COCACOLA',18);
INSERT INTO Soda VALUES(6, 'Pepsi Max','PEPSI',12);

ALTER TABLE SODA add color varchar(20);
UPDATE SODA set color='black' where code='PEPSI';

CREATE VIEW soda_view AS SELECT name, code, color from soda;
