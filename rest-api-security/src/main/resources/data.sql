INSERT INTO persons (id, name, surname, birthday) values (1, 'Pavel', 'Bui', '1980-09-27');
INSERT INTO persons (id, name, surname, birthday) values (2, 'Anna', 'Bui', '1983-09-11');
INSERT INTO persons (id, name, surname, birthday) values (3, 'Uliana', 'Bui', '2009-08-14');
INSERT INTO persons (id, name, surname, birthday) values (4, 'Serafima', 'Bui', '2012-11-08');
INSERT INTO persons (id, name, surname, birthday) values (5, 'Antony', 'Bui', '2016-01-31');
INSERT INTO persons (id, name, surname, birthday) values (6, 'Elisha', 'Bui', '2022-06-22');

INSERT INTO subscriptions (id, person_id, start_date) values (1, (SELECT id FROM persons where name = 'Pavel'), '2023-03-01');
INSERT INTO subscriptions (id, person_id, start_date) values (2, (SELECT id FROM persons where name = 'Anna'), '2023-03-02');
INSERT INTO subscriptions (id, person_id, start_date) values (3, (SELECT id FROM persons where name = 'Uliana'), '2023-03-03');
INSERT INTO subscriptions (id, person_id, start_date) values (4, (SELECT id FROM persons where name = 'Serafima'), '2023-03-04');
INSERT INTO subscriptions (id, person_id, start_date) values (5, (SELECT id FROM persons where name = 'Antony'), '2023-03-05');
INSERT INTO subscriptions (id, person_id, start_date) values (6, (SELECT id FROM persons where name = 'Elisha'), '2023-03-06');

INSERT INTO users (username, password, failed_login, enabled)
values ('user@email.com', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', 0, true);
INSERT INTO users (username, password, failed_login, enabled)
values ('worker@email.com', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', 0, true);
INSERT INTO users (username, password, failed_login, enabled)
values ('admin@email.com', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', 0, true);

INSERT INTO authorities (id, username, authority)
values (1, 'user@email.com', 'ROLE_VIEW_PERSON');
INSERT INTO authorities (id, username, authority)
values (2, 'worker@email.com', 'ROLE_VIEW_PERSON');
INSERT INTO authorities (id, username, authority)
values (3, 'worker@email.com', 'ROLE_VIEW_SUBSCRIPTION');
INSERT INTO authorities (id, username, authority)
values (4, 'worker@email.com', 'ROLE_VIEW_INFO');
INSERT INTO authorities (id, username, authority)
values (5, 'admin@email.com', 'ROLE_VIEW_PERSON');
INSERT INTO authorities (id, username, authority)
values (6, 'admin@email.com', 'ROLE_VIEW_SUBSCRIPTION');
INSERT INTO authorities (id, username, authority)
values (7, 'admin@email.com', 'ROLE_VIEW_INFO');
INSERT INTO authorities (id, username, authority)
values (8, 'admin@email.com', 'ROLE_VIEW_ADMIN');

