
#1 Stworz tabele z uzyciem constraintow
create table SODA (
          ID_SODA int PRIMARY KEY,
          NAME VARCHAR(50) DEFAULT NULL,
          CODE VARCHAR(50) DEFAULT NULL,
          PRICE VARCHAR(10) DEFAULT NULL
);

#2 dodaj nowa kolumne do tabeli
ALTER TABLE SODA add color varchar(20);

#5 wykonaj update dla dowolnej wartosci. Wklej rekord przed zmiana i po
UPDATE SODA set color='black' where code='PEPSI';

#3 wypelnij tabele danymi i sprawdz czy mozna dodac wartosc sprzeczna z zalozonym constraintem
INSERT INTO Soda VALUES(1, 'Budweiser','BUDWEISER',10);
INSERT INTO Soda VALUES(2, 'Cola-Cola','COCACOLA',8);
INSERT INTO Soda VALUES(3, 'Pepsi','PEPSI',9);
INSERT INTO Soda VALUES(4, 'Pepsi lemonm','PEPSI',9);
INSERT INTO Soda VALUES(5, 'Cola-Cola Light','COCACOLA',18);
INSERT INTO Soda VALUES(6, 'Pepsi Max','PEPSI',12);

#4 wyszukaj wszystkie elementy i posortuj je w kolejnosci alfabetycznej po nazwie. Wynik wklej do pliku ze skryptem
SELECT * FROM SODA ORDER BY name ASC;

CREATE VIEW soda_view AS SELECT name, code, color from soda;

#6 Usun wybrana kolumne
ALTER TABLE Soda DROP COLUMN color CASCADE;

SELECT name, code from soda where CODE like '%EPS%' group by code, name;

#7 Wyczysc tabele
DELETE from soda;

#8 Usun tabele
drop table soda;
