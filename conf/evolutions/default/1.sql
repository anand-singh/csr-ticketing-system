# --- First database schema

# --- !Ups

SET ignorecase TRUE;

CREATE TABLE users (
  id          BIGINT       NOT NULL AUTO_INCREMENT,
  name        VARCHAR(255) NOT NULL,
  designation VARCHAR(255) NOT NULL,
  email       VARCHAR(100) NOT NULL,
  password    VARCHAR(100) NOT NULL,
  is_admin    BOOLEAN               DEFAULT FALSE,
  CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE customers (
  id      BIGINT        NOT NULL AUTO_INCREMENT,
  name    VARCHAR(255)  NOT NULL,
  email   VARCHAR(100)  NOT NULL,
  address VARCHAR(1000) NOT NULL,
  contact VARCHAR(55)   NOT NULL,
  CONSTRAINT pk_customers PRIMARY KEY (id)
);

CREATE TABLE tickets (
  id          BIGINT        NOT NULL AUTO_INCREMENT,
  description VARCHAR(1000) NOT NULL,
  status      VARCHAR(55)   NOT NULL,
  area        VARCHAR(255)  NOT NULL,
  created_at  TIMESTAMP              DEFAULT NOW(),
  updated_at  TIMESTAMP              DEFAULT NOW(),
  customer_id BIGINT        NOT NULL,
  created_by  BIGINT        NOT NULL,
  assigned_to BIGINT        NOT NULL,
  CONSTRAINT pk_tickets PRIMARY KEY (id),
  CONSTRAINT fk_tickets_created_by FOREIGN KEY (created_by) REFERENCES users (id),
  CONSTRAINT fk_tickets_assigned_to FOREIGN KEY (assigned_to) REFERENCES users (id),
  CONSTRAINT fk_tickets_customer_id FOREIGN KEY (customer_id) REFERENCES customers (id)
);

CREATE TABLE comments (
  id         BIGINT        NOT NULL AUTO_INCREMENT,
  user_id    BIGINT        NOT NULL,
  ticket_id  BIGINT        NOT NULL,
  comment    VARCHAR(1000) NOT NULL,
  created_at TIMESTAMP              DEFAULT NOW(),
  CONSTRAINT pk_comments PRIMARY KEY (id),
  CONSTRAINT fk_comments_user FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT fk_comments_ticket FOREIGN KEY (user_id) REFERENCES tickets (id)
);

# --- !Downs

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS comments;
