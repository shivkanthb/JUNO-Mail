CREATE TABLE USERLOGIN
(
USID VARCHAR(40) NOT NULL,
PWD VARCHAR(20),
PRIMARy KEY(USID)
);

insert into userlogin values('shiv@gmail.com','shiv');
insert into userlogin values('suresh@gmail.com','suresh');
insert into userlogin values('sri@gmail.com','sri');
insert into userlogin values('Shiv','shivu');
insert into userlogin values('sri','sri');
insert into userlogin values('suresh','sur');
insert into userlogin values('Admin','admin');


CREATE TABLE USERDETAILS
(
USID VARCHAR(40) NOT NULL,
EMAIL VARCHAR(30),
UNAME VARCHAR(20),
PASS VARCHAR(20),
RPASS VARCHAR(20),
PRIMARY KEY(USID),
FOREIGN KEY (USID) REFERENCES USERLOGIN(USID) ON DELETE CASCADE
);

CREATE TABLE COMPOSE
(
SENDER VARCHAR(40) NOT NULL,
RECEPIENT VARCHAR(40) NOT NULL,
SUBJECT VARCHAR(20),
MESSAGE VARCHAR(40),
MSID VARCHAR(10)
);

insert into compose values('graceboy','suresh','hello','boss','1');
insert into compose values('graceboy','suresh','hi','dude','2');
insert into compose values('suresh','sachin','wazzup','buddy','3');



