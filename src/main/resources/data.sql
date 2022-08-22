INSERT INTO role(name) VALUES('ADMIN');
INSERT INTO role(name) VALUES('EMPLOYEE');
INSERT INTO role(name) VALUES('CLIENT');

INSERT INTO "user"(user_name, password) VALUES('admin', 'password1');
INSERT INTO "user"(user_name, password) VALUES('employee', 'password2');
INSERT INTO "user"(user_name, password) VALUES('client', 'password3');

INSERT INTO user_role(user_id, role_id) VALUES(1, 1);
INSERT INTO user_role(user_id, role_id) VALUES(2, 2);
INSERT INTO user_role(user_id, role_id) VALUES(3, 3);
