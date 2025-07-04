INSERT INTO `user` (`nickname`, `gender`, `birthday`)
VALUES ('Alice', 2, '1995-04-12'),
       ('Bob', 1, '1992-08-23'),
       ('Charlie', 1, '1990-11-05'),
       ('Diana', 2, '1998-02-17'),
       ('Ethan', 1, '1996-07-30'),
       ('Fiona', 2, '1993-12-01'),
       ('George', 1, '1994-03-15'),
       ('Hannah', 2, '1997-09-09'),
       ('Ivan', 1, '1991-06-21'),
       ('Julia', 2, '1999-01-25'),
       ('Kevin', 1, '1993-10-10'),
       ('Linda', 2, '1995-05-18'),
       ('Mike', 1, '1997-12-28'),
       ('Nina', 2, '1994-08-14'),
       ('Oscar', 1, '1992-03-03'),
       ('Paula', 2, '1996-11-19'),
       ('Quentin', 1, '1998-06-06'),
       ('Rachel', 2, '1991-09-27'),
       ('Sam', 1, '1995-02-02'),
       ('Tina', 2, '1993-07-22');

INSERT INTO `user_score` (`user_id`, `score`)
VALUES (1, 1200),
       (2, 1150),
       (3, 980),
       (4, 1300),
       (5, 1100),
       (6, 1250),
       (7, 1050),
       (8, 1190),
       (9, 990),
       (10, 1280),
       (11, 1020),
       (12, 1170),
       (13, 1080),
       (14, 1230),
       (15, 1120),
       (16, 1210),
       (17, 1090),
       (18, 1270),
       (19, 1010),
       (20, 1240);

INSERT INTO `user_game_record` (`user_id`, `game_id`, `members`, `result`, `score_change`, `create_time`)
VALUES (1, 1001, '["Alice","Bob"]', 1, 30, '2023-08-12 14:23:11'),
       (1, 1002, '["Alice","Charlie"]', 0, -20, '2023-09-05 19:10:45'),
       (1, 1003, '["Alice","Diana","Ethan"]', 2, 0, '2023-11-21 16:05:33'),

       (2, 1004, '["Bob","Fiona"]', 1, 25, '2023-07-18 13:12:09'),
       (2, 1005, '["Bob","George"]', 0, -15, '2023-10-02 20:45:22'),
       (2, 1006, '["Bob","Alice"]', 0, -10, '2023-12-01 11:30:00'),

       (3, 1007, '["Charlie","Diana"]', 1, 35, '2023-06-15 09:22:18'),
       (3, 1008, '["Charlie","Ethan"]', 2, 0, '2023-08-27 17:40:55'),

       (4, 1009, '["Diana","Fiona"]', 1, 40, '2023-09-10 15:10:10'),
       (4, 1010, '["Diana","Alice"]', 0, -20, '2023-10-12 18:22:33'),
       (4, 1011, '["Diana","George","Bob"]', 2, 0, '2023-12-05 20:15:44'),

       (5, 1012, '["Ethan","Fiona"]', 1, 28, '2023-07-21 12:11:09'),
       (5, 1013, '["Ethan","Charlie"]', 0, -18, '2023-09-14 16:33:21'),

       (6, 1014, '["Fiona","George"]', 1, 32, '2023-08-03 14:55:12'),
       (6, 1015, '["Fiona","Diana"]', 0, -22, '2023-10-19 19:44:08'),
       (6, 1016, '["Fiona","Alice"]', 2, 0, '2023-11-30 21:10:10'),

       (7, 1017, '["George","Hannah"]', 1, 27, '2023-06-28 13:20:00'),
       (7, 1018, '["George","Ivan"]', 0, -16, '2023-09-22 17:55:33'),

       (8, 1019, '["Hannah","Julia"]', 1, 34, '2023-07-15 10:10:10'),
       (8, 1020, '["Hannah","Kevin"]', 0, -19, '2023-10-25 18:30:00'),

       (9, 1021, '["Ivan","Linda"]', 1, 29, '2023-08-09 15:45:22'),
       (9, 1022, '["Ivan","Mike"]', 0, -14, '2023-11-11 20:20:20'),

       (10, 1023, '["Julia","Nina"]', 1, 31, '2023-09-01 11:11:11'),
       (10, 1024, '["Julia","Oscar"]', 0, -17, '2023-12-12 22:22:22'),

       (11, 1025, '["Kevin","Paula"]', 1, 26, '2023-07-19 14:14:14'),
       (11, 1026, '["Kevin","Quentin"]', 0, -13, '2023-10-29 19:19:19'),

       (12, 1027, '["Linda","Rachel"]', 1, 33, '2023-08-25 16:16:16'),
       (12, 1028, '["Linda","Sam"]', 0, -21, '2023-11-15 21:21:21'),

       (13, 1029, '["Mike","Tina"]', 1, 30, '2023-09-05 12:12:12'),
       (13, 1030, '["Mike","Alice"]', 0, -12, '2023-12-20 23:23:23'),

       (14, 1031, '["Nina","Bob"]', 1, 24, '2023-07-30 13:13:13'),
       (14, 1032, '["Nina","Charlie"]', 0, -18, '2023-10-10 18:18:18'),

       (15, 1033, '["Oscar","Diana"]', 1, 29, '2023-08-18 15:15:15'),
       (15, 1034, '["Oscar","Ethan"]', 0, -15, '2023-11-25 20:20:20'),

       (16, 1035, '["Paula","Fiona"]', 1, 27, '2023-09-12 14:14:14'),
       (16, 1036, '["Paula","George"]', 0, -19, '2023-12-18 21:21:21'),

       (17, 1037, '["Quentin","Ivan"]', 1, 28, '2023-08-22 13:30:00'),
       (17, 1038, '["Quentin","Julia"]', 0, -16, '2023-10-28 17:45:00'),
       (17, 1039, '["Quentin","Linda","Mike"]', 2, 0, '2023-12-03 19:10:00'),

       (18, 1040, '["Rachel","Nina"]', 1, 32, '2023-07-27 11:20:00'),
       (18, 1041, '["Rachel","Oscar"]', 0, -20, '2023-09-30 16:55:00'),
       (18, 1042, '["Rachel","Paula"]', 1, 25, '2023-11-14 20:40:00'),

       (19, 1043, '["Sam","Quentin"]', 1, 26, '2023-08-10 12:10:00'),
       (19, 1044, '["Sam","Rachel"]', 0, -14, '2023-10-15 18:25:00'),
       (19, 1045, '["Sam","Tina"]', 2, 0, '2023-12-09 21:30:00'),

       (20, 1046, '["Tina","Alice"]', 1, 30, '2023-09-08 14:50:00'),
       (20, 1047, '["Tina","Bob"]', 0, -18, '2023-11-22 19:15:00'),
       (20, 1048, '["Tina","Charlie","Diana"]', 2, 0, '2023-12-28 22:05:00');