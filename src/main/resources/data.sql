INSERT INTO persons (person_id, person_name, person_surname, person_birthday) values (1, 'Pavel', 'Bui', '1980-09-27');
INSERT INTO persons (person_id, person_name, person_surname, person_birthday) values (2, 'Anna', 'Bui', '1983-09-11');
INSERT INTO persons (person_id, person_name, person_surname, person_birthday) values (3, 'Uliana', 'Bui', '2009-08-14');
INSERT INTO persons (person_id, person_name, person_surname, person_birthday) values (4, 'Serafima', 'Bui', '2012-11-08');
INSERT INTO persons (person_id, person_name, person_surname, person_birthday) values (5, 'Antony', 'Bui', '2016-01-31');
INSERT INTO persons (person_id, person_name, person_surname, person_birthday) values (6, 'Elisha', 'Bui', '2022-06-22');

INSERT INTO subscriptions (subscription_id, person_id, subscription_start_date) values (1, (SELECT person_id FROM persons where person_name = 'Pavel'), '2023-03-01');
INSERT INTO subscriptions (subscription_id, person_id, subscription_start_date) values (2, (SELECT person_id FROM persons where person_name = 'Anna'), '2023-03-02');
INSERT INTO subscriptions (subscription_id, person_id, subscription_start_date) values (3, (SELECT person_id FROM persons where person_name = 'Uliana'), '2023-03-03');
INSERT INTO subscriptions (subscription_id, person_id, subscription_start_date) values (4, (SELECT person_id FROM persons where person_name = 'Serafima'), '2023-03-04');
INSERT INTO subscriptions (subscription_id, person_id, subscription_start_date) values (5, (SELECT person_id FROM persons where person_name = 'Antony'), '2023-03-05');
INSERT INTO subscriptions (subscription_id, person_id, subscription_start_date) values (6, (SELECT person_id FROM persons where person_name = 'Elisha'), '2023-03-06');

INSERT INTO users (username, password, email, failed_login, enabled)
values ('user', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', 'user@email.com', 0, true);
INSERT INTO users (username, password, email, failed_login, enabled)
values ('worker', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', 'worker@email.com', 0, true);
INSERT INTO users (username, password, email, failed_login, enabled)
values ('admin', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', 'admin@email.com', 0, true);

INSERT INTO authorities (username, authority)
values ('user', 'ROLE_VIEW_PERSON');
INSERT INTO authorities (username, authority)
values ('worker', 'ROLE_VIEW_PERSON');
INSERT INTO authorities (username, authority)
values ('worker', 'ROLE_VIEW_SUBSCRIPTION');
INSERT INTO authorities (username, authority)
values ('worker', 'ROLE_VIEW_INFO');
INSERT INTO authorities (username, authority)
values ('admin', 'ROLE_VIEW_PERSON');
INSERT INTO authorities (username, authority)
values ('admin', 'ROLE_VIEW_SUBSCRIPTION');
INSERT INTO authorities (username, authority)
values ('admin', 'ROLE_VIEW_INFO');
INSERT INTO authorities (username, authority)
values ('admin', 'ROLE_VIEW_ADMIN');

