CREATE TABLE persons(
                          person_id          bigint primary key,
                          person_name        varchar(128)  not null,
                          person_surname     varchar(128) not null,
                          person_birthday    date not null
);

CREATE TABLE subscriptions
(
    subscription_id    bigint primary key,
    person_id  bigint not null,
    foreign key (person_id) references persons (person_id),
    subscription_start_date  date not null
);

CREATE TABLE users
(
    username varchar(50) not null primary key,
    password varchar(500) not null,
    enabled  boolean not null
);

CREATE TABLE authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

CREATE UNIQUE INDEX ix_auth_username on authorities (username, authority);