# --- Sample dataset

# --- !Ups

INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (1, 'Sai Premalatha', 'Manager', 'premalatha@redmart.com', 'password', TRUE);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (2, 'Anand Kumar Singh', 'Software Engineer', 'imanandksingh@gmail.com', 'password', FALSE);

# --- !Downs

DELETE FROM users;
