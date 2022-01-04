DROP DATABASE IF EXISTS attackerlab;
CREATE database attackerlab;
USE attackerlab;
CREATE TABLE attackerlab.passwords(
	password char(16) NOT NULL,
	result varchar(16) NOT NULL,
	PRIMARY KEY(password)
);
INSERT INTO attackerlab.passwords(password, result) VALUES ('Wq6mn^zZBFtM@QPL', 'YOU GOT IT');
