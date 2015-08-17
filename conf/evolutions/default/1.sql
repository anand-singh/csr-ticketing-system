# --- First database schema

# --- !Ups

SET ignorecase TRUE;

CREATE TABLE users (
  id          BIGINT                NOT NULL AUTO_INCREMENT,
  name        VARCHAR(255)          NOT NULL,
  designation VARCHAR(255)          NOT NULL,
  email       VARCHAR(100)          NOT NULL,
  password    VARCHAR(100)          NOT NULL,
  is_admin    BOOLEAN DEFAULT FALSE NOT NULL,
  CONSTRAINT pk_users PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE IF EXISTS employee;
