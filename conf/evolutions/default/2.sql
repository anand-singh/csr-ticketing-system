# --- Sample dataset

# --- !Ups

INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (1, 'Sai Premalatha', 'Manager', 'premalatha@gmail.com', 'password', true);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (2, 'Anand Kumar Singh', 'Software Engineer', 'imanandksingh@gmail.com', 'password', false);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (3, 'Jyoti Singh', 'Testing Engineer', 'jyoti@gmail.com', 'password', false);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (4, 'Amit Singh', 'Product Engineer', 'amit@gmail.com', 'password', false);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (5, 'Prem Kumar', 'Manager', 'prem.kumar@gmail.com', 'password', true);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (6, 'Avinash Singh', 'Developer', 'avinash@gmail.com', 'password', false);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (7, 'Satendra Yadav', 'Testing Engineer', 'satendra@gmail.com', 'password', false);
INSERT INTO users (id, name, designation, email, password, is_admin)
VALUES (8, 'Anuradha Singh', 'Product Engineer', 'anuradha@gmail.com', 'password', false);

INSERT INTO customers (id, name, email, address, contact)
VALUES (1, 'Anuj Raj', 'anuj@gmail.com', 'Mayur Vihar Phase-1', '011-22751903');
INSERT INTO customers (id, name, email, address, contact)
VALUES (2, 'Vipin Kumar', 'vipin@gmail.com', 'New Delhi', '011-22751903');
INSERT INTO customers (id, name, email, address, contact)
VALUES (3, 'Amit Yadav', 'amit@gmail.com', 'Karol Bag', '011-22751903');

INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (1, 'Delay in delivery: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'Open', 'East Delhi', 1, 1, 2);
INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (2, 'Defect in product: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'New', 'East Delhi', 2, 2, 2);
INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (3, 'Wrong product delivery: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'Closed', 'East Delhi', 3, 2, 2);
INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (4, 'Wrong product delivery: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'New', 'East Delhi', 1, 1, 1);
INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (5, 'Missing product: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'New', 'West Delhi', 2, 3, 3);
INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (6, 'Missing product: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'Open', 'West Delhi', 3, 1, 2);
INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (7, 'Missing product: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'Closed', 'North Delhi', 1, 2, 2);
INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (8, 'Wrong product delivery: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'Open', 'North Delhi', 1, 1, 1);
INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (9, 'Wrong product delivery: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'Closed', 'South Delhi', 2, 2, 2);
INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (10, 'Wrong product delivery: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'Open', 'South Delhi', 3, 3, 3);
INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (11, 'Defect in product: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'Open', 'South Delhi', 3, 3, 3);
INSERT INTO tickets (id, description, status, area, customer_id, created_by, assigned_to)
VALUES (12, 'Defect in product: A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.', 'New', 'South Delhi', 2, 2, 2);

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

