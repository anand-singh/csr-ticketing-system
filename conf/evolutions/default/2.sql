# --- Sample dataset

# --- !Ups

INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (1, 'Sai Premalatha', 'Manager', 'premalatha@redmart.com', 'password', TRUE);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (2, 'Anand Kumar Singh', 'Software Engineer', 'imanandksingh@gmail.com', 'password', FALSE);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (3, 'Jyoti Singh', 'Testing Engineer', 'jyoti@gmail.com', 'password', FALSE);

INSERT INTO customers (id, name, address, contact)
VALUES (1, 'Anuj Raj', 'Mayur Vihar Phase-1', '011-22751903');
INSERT INTO customers (id, name, address, contact)
VALUES (2, 'Vipin Kumar', 'New Delhi', '011-22751903');
INSERT INTO customers (id, name, address, contact)
VALUES (3, 'Amit', 'Karol Bag', '011-22751903');

# --- !Downs

DELETE FROM users;
DELETE FROM customers;
