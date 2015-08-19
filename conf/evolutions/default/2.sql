# --- Sample dataset

# --- !Ups

INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (1, 'Sai Premalatha', 'Manager', 'premalatha@gmail.com', 'password', TRUE);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (2, 'Anand Kumar Singh', 'Software Engineer', 'imanandksingh@gmail.com', 'password', FALSE);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (3, 'Jyoti Singh', 'Testing Engineer', 'jyoti@gmail.com', 'password', FALSE);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (4, 'Amit Singh', 'Product Engineer', 'amit@gmail.com', 'password', FALSE);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (5, 'Premalatha', 'Manager', 'premalatha@gmail.com', 'password', TRUE);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (6, 'Avinash Singh', 'Developer', 'avinash@gmail.com', 'password', FALSE);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (7, 'Satendra Yadav', 'Testing Engineer', 'satendra@gmail.com', 'password', FALSE);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (8, 'Amit Singh', 'Product Engineer', 'amit@gmail.com', 'password', FALSE);

INSERT INTO customers (id, name, address, contact)
VALUES (1, 'Anuj Raj', 'Mayur Vihar Phase-1', '011-22751903');
INSERT INTO customers (id, name, address, contact)
VALUES (2, 'Vipin Kumar', 'New Delhi', '011-22751903');
INSERT INTO customers (id, name, address, contact)
VALUES (3, 'Amit', 'Karol Bag', '011-22751903');

INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (1, 'Delay in delivery', 'Open', 1, 1, 2);
INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (2, 'Defect in product', 'New', 2, 2, 2);
INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (3, 'Wrong product delivery', 'Closed', 3, 2, 2);
INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (4, 'Wrong product delivery', 'New', 1, 1, 1);
INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (5, 'Missing product', 'New', 2, 3, 3);
INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (6, 'Missing product', 'Open', 3, 1, 2);
INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (7, 'Missing product', 'Closed', 1, 2, 2);
INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (8, 'Wrong product delivery', 'Open', 1, 1, 1);
INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (9, 'Wrong product delivery', 'Closed', 2, 2, 2);
INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (10, 'Wrong product delivery', 'Open', 3, 3, 3);
INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (11, 'Defect in product', 'Open', 3, 3, 3);
INSERT INTO tickets (id, description, status, customer_id, created_by, assigned_to)
VALUES (12, 'Defect in product', 'New', 2, 2, 2);

INSERT INTO comments (id, user_id, ticket_id, comment)
VALUES (1, 1, 1, '@Anand: Could you please look into this');
INSERT INTO comments (id, user_id, ticket_id, comment)
VALUES (2, 2, 1, '@Sai: sure, I will try to resolved this issue. Thanks');
INSERT INTO comments (id, user_id, ticket_id, comment)
VALUES (3, 1, 2, '@Anand: Could you please look into this');
INSERT INTO comments (id, user_id, ticket_id, comment)
VALUES (4, 2, 2, '@Sai: sure, I will try to resolved this issue. Thanks');
INSERT INTO comments (id, user_id, ticket_id, comment)
VALUES (5, 1, 3, '@Anand: Could you please look into this');
INSERT INTO comments (id, user_id, ticket_id, comment)
VALUES (6, 2, 3, '@Sai: sure, I will try to resolved this issue. Thanks');
INSERT INTO comments (id, user_id, ticket_id, comment)
VALUES (7, 1, 4, '@Anand: Could you please look into this');
INSERT INTO comments (id, user_id, ticket_id, comment)
VALUES (8, 2, 4, '@Sai: sure, I will try to resolved this issue. Thanks');
INSERT INTO comments (id, user_id, ticket_id, comment)
VALUES (9, 1, 5, '@Anand: Could you please look into this');
INSERT INTO comments (id, user_id, ticket_id, comment)
VALUES (10, 2, 5, '@Sai: sure, I will try to resolved this issue. Thanks');

# --- !Downs

DELETE FROM comments;
DELETE FROM tickets;
DELETE FROM users;
DELETE FROM customers;

