-- 向 movie 表插入示例数据
INSERT INTO movie (id, title, genre, director, show_status, image_url, introduction, release_date)
VALUES (1, 'Movie A', 'Drama', 'Director A', 1, 'http://example.com/image1.jpg', 'Introduction to Movie A', '2023-01-01'),
       (2, 'Movie B', 'Comedy', 'Director B', 0, 'http://example.com/image2.jpg', 'Introduction to Movie B', '2023-02-01'),
       (3, 'Movie C', 'Action', 'Director C', 1, 'http://example.com/image3.jpg', 'Introduction to Movie C', '2023-03-01');

-- 向 room 表插入示例数据
INSERT INTO room (id, name)
VALUES (1, 'Room 1'),
       (2, 'Room 2'),
       (3, 'Room 3');

-- 向 user 表插入示例数据
INSERT INTO user (id, username, password)
VALUES (1, 'user1', 'password1'),
       (2, 'user2', 'password2'),
       (3, 'user3', 'password3');

-- 向 session 表插入示例数据
INSERT INTO session (id, start_time, movie_id, room_id)
VALUES (1, '2023-01-01 10:00:00', 1, 1),
       (2, '2023-02-01 14:00:00', 2, 2),
       (3, '2023-03-01 18:00:00', 3, 3);

-- 向 seat 表插入示例数据
INSERT INTO seat (id, seat_row, seat_col, room_id)
VALUES (1, 'A', 1, 1),
       (2, 'A', 2, 1),
       (3, 'B', 1, 2),
       (4, 'B', 2, 2),
       (5, 'C', 1, 3),
       (6, 'C', 2, 3);

-- 向 ticket 表插入示例数据
INSERT INTO ticket (id, session_id, seat_id, price)
VALUES (1, 1, 1, 100),
       (2, 2, 3, 120),
       (3, 3, 6, 80);

-- 向 indent 表插入示例数据
INSERT INTO indent (id, purchase_time, ticket_id, user_id)
VALUES (1, '2023-01-01 09:30:00', 1, 1),
       (2, '2023-02-01 13:45:00', 2, 2),
       (3, '2023-03-01 17:30:00', 3, 3);
