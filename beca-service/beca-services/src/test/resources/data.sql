INSERT INTO users (id, ds_name, ds_lastname, age)
VALUES
(1, 'User 1', 'Ln', 4),
(2, 'User 2', 'Ln', 4),
(3, 'User 3', 'Ln', 4),
(4, 'User 4', 'Ln', 4),
(5, 'User 5', 'Ln', 4),
(6, 'User 6', 'Ln', 4),
(7, 'User 7', 'Ln', 4);

commit;
select count(*) from users;
alter sequence users_id_seq restart with 10;