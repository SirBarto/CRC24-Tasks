CREATE TABLE address
(
    id       BIGINT       NOT NULL,
    location VARCHAR(255) NOT NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);