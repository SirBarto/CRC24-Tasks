CREATE TABLE library
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255),
    address_id BIGINT,
    CONSTRAINT pk_library PRIMARY KEY (id)
);

ALTER TABLE library
    ADD CONSTRAINT uc_library_address UNIQUE (address_id);

ALTER TABLE library
    ADD CONSTRAINT FK_LIBRARY_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);