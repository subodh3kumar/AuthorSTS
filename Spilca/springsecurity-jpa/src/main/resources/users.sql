DROP TABLE USERS PURGE;
CREATE TABLE USERS(ID NUMBER(4) PRIMARY KEY, USERNAME VARCHAR2(20), PASSWORD VARCHAR2(20));
SELECT * FROM USERS;
INSERT INTO USERS VALUES (1001, 'subodh', 'subodh@2020');
INSERT INTO USERS VALUES (1002, 'juli', 'juli@2020');
INSERT INTO USERS VALUES (1003, 'user', 'user@2020');
INSERT INTO USERS VALUES (1004, 'admin', 'admin@2020');
SELECT * FROM USERS;