INSERT INTO role(name) VALUES('ADMIN');
INSERT INTO role(name) VALUES('EMPLOYEE');
INSERT INTO role(name) VALUES('CLIENT');

INSERT INTO "user"(name, password) VALUES('admin', '$2a$10$ad6pCGmytSr3lgPMGoPj1eLsBtNPqKx2D/LaHm4JRxEdrqoF5soMy');
INSERT INTO "user"(name, password) VALUES('employee', '$2a$10$vuR/XIsuuibjlZu6AOP.QOJnfGByJRAzHfjCIUmltDnzASSeT0cVK');
INSERT INTO "user"(name, password) VALUES('client', '$2a$10$ua5aHFUM6Td9sV19TbQE2OjEC1PTqOce6PuVB0H8FVvaWvRsP1scK');

INSERT INTO user_role(user_id, role_id) VALUES(1, 1);
INSERT INTO user_role(user_id, role_id) VALUES(2, 2);
INSERT INTO user_role(user_id, role_id) VALUES(3, 3);
