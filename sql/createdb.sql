DROP DATABASE IF EXISTS attackerlab;
CREATE database attackerlab;

CREATE TABLE attackerlab.users(
	uid varchar(16) NOT NULL UNIQUE,
	uname varchar(255) NOT NULL UNIQUE,
	password varchar(255) NOT NULL,
	uphoto varchar(255) ,
	targetsDone varchar(255),
	registerDate date,
	PRIMARY KEY(uid)
	
);

CREATE TABLE attackerlab.targets(
	tid varchar(16) NOT NULL,
	tname varchar(255) NOT NULL,
	tphoto varchar(255),
	briefDesc varchar(255),
	fullDesc varchar(16383 ),
	count int,
	PRIMARY KEY(tid)
);


CREATE TABLE attackerlab.messageBoard(
	mid varchar(16) NOT NULL,
	tittle varchar(255), 
	content varchar(16383),
	editDate date,
	uid varchar(16) NOT NULL,
	tid varchar(16) NOT NULL
);

CREATE TABLE attackerlab.usersFriend(
	uid varchar(16) NOT NULL,
	ufid varchar(16) NOT NULL
);
INSERT INTO attackerlab.users (uid, uname, password, uphoto, targetsDone) VALUES (112233, 'alex', 'alexpass','alex.com', '123,789'), (445566, 'bob', 'bobpass', 'bob.com', '123'), (778899, 'candy', 'candypass', 'candy.com', '123,456,789');

INSERT INTO attackerlab.targets(tid, tname, tphoto, briefDesc, fullDesc, count) VALUES (123, 'sql injection', 'sqli.com', 'this is sql i', 'this is sql injection', '5'), 
(456, 'sql waf injection', 'sqliwaf.com', 'this is sql w i', 'this is sql waf injection', '2'),
(789, 'command injection', 'commandi.com', 'this is command i', 'this is command injection', '9');

INSERT INTO attackerlab.messageBoard(mid, tittle, content, editDate, uid, tid) VALUES (1, "so fuck nice", "sqli xxxxxxxxxxxx", '2022-01-20', 112233, 123), 
(2, "so damn nice", "sql xxxxxxxxxxxx", '2022-01-20', 445566, 456), (3, "so fuck nice", "sqli xxxxxxxxxxxx", '2022-01-20', 778899, 123);

INSERT INTO attackerlab.usersFriend(uid, ufid) VALUES ('112233', '445566'),('112233','778899');
