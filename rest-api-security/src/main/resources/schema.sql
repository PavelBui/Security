CREATE TABLE persons(
                          id          bigint primary key,
                          name        varchar(128)  not null,
                          surname     varchar(128) not null,
                          birthday    date not null
);

CREATE TABLE subscriptions
(
    id          bigint primary key,
    person_id   bigint not null,
    foreign key (person_id) references persons (id),
    start_date  date not null
);

CREATE TABLE users
(
    username        varchar(50) not null primary key,
    password        varchar(500) not null,
    failed_login    int not null,
    enabled         boolean not null
);

CREATE TABLE authorities
(
    id          bigint primary key,
    username    varchar(50) not null,
    authority   varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

CREATE UNIQUE INDEX ix_auth_username on authorities (username, authority);