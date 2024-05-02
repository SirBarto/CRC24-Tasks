create table users(
                      username varchar(50) not null primary key,
                      password varchar(500) not null,
                      enabled boolean not null
);

create table authorities (
                             username varchar(50) not null,
                             authority varchar(50) not null,
                             constraint fk_authorities_users foreign key(username) references users(username)
);

insert into users (username, password, enabled) values ('admin', '$2a$10$ghXUEa5blDOhLq0Kl2mtoecJP.L5BSmWlNrZOY6foV3vALF8K9KwW', true);
insert into users (username, password, enabled) values ('user1', '$2a$10$ghXUEa5blDOhLq0Kl2mtoecJP.L5BSmWlNrZOY6foV3vALF8K9KwW', true);
insert into authorities(username, authority) values ('admin', 'admin');
insert into authorities(username, authority) values ('user1', 'user');

insert into users (username, password, enabled) values ('auditor', '$2a$10$ghXUEa5blDOhLq0Kl2mtoecJP.L5BSmWlNrZOY6foV3vALF8K9KwW', true);
insert into authorities(username, authority) values ('auditor', 'role_viewer');
commit;