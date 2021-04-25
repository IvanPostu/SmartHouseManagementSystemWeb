CREATE TABLE users (
    id              INTEGER NOT NULL AUTO_INCREMENT,
    email	          VARCHAR(256),
    first_name      VARCHAR(128),
    last_name       VARCHAR(128),
    password        VARCHAR(256),
    hash_algorithm  VARCHAR(64),

    PRIMARY KEY(id)
);


CREATE UNIQUE INDEX idx_users_emails
ON users (email);

ALTER TABLE users MODIFY email VARCHAR(256) NOT NULL;
