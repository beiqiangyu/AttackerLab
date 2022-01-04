DROP DATABASE IF EXISTS attackerlab;
CREATE database attackerlab;
USE attackerlab;


CREATE TABLE attackerlab.passwords(
	password char(16) NOT NULL,
	result varchar(16) NOT NULL,
	PRIMARY KEY(password)
);

CREATE TABLE attackerlab.users
		(
		username varchar(20) NOT NULL,
		password varchar(20) NOT NULL,
		result varchar(20) NOT NULL
		);

CREATE TABLE attackerlab.uagents
		(
		uagent varchar(256) NOT NULL,
		ip_address varchar(35) NOT NULL,
		username varchar(20) NOT NULL
		);

INSERT INTO attackerlab.users(username, password, result) VALUES ('admin', 'password', 'YOU ARE IN');
INSERT INTO attackerlab.passwords(password, result) VALUES ('oNOhL09n9Db4GjTS', 'YOU GOT IT');
