DROP DATABASE IF EXISTS attackerlab;
CREATE database attackerlab;
CREATE TABLE attackerlab.users(
	username varchar(16) NOT NULL,
	password varchar(16) NOT NULL,
	applenum varchar(16),
	banananum varchar(16),
	PRIMARY KEY(username)
);

CREATE TABLE attackerlab.produce(
	name varchar(16) NOT NULL,
	remain varchar(16) NOT NULL,
	price varchar(16) NOT NULL,
	PRIMARY KEY(name)
);

INSERT INTO attackerlab.users(username, password, applenum, banananum) VALUES ('alex', 'password', 0, 0),('bob', 'password', 0, 0);
INSERT INTO attackerlab.produce(name, remain, price) VALUES ('apple', 10, 2), ('banana', 20, 1);


