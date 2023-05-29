-- 向 movie 表插入示例数据
INSERT INTO movie (id, title, genre, director, show_status, image_url, introduction, release_date)
VALUES
(1, '肖申克的救赎', '剧情', '弗兰克·德拉邦特', 1, 'https://example.com/shawshank_redemption.jpg', '两个被囚禁的男人在数年间建立了深厚的友谊，并通过共同的正直行为找到了慰藉和最终的救赎。', '1994-10-14'),
(2, '教父', '犯罪、剧情', '弗朗西斯·福特·科波拉', 1, 'https://example.com/godfather.jpg', '一位年迈的黑手党家族领袖将他秘密的帝国的控制权转交给他不情愿的儿子。', '1972-03-24'),
(3, '低俗小说', '犯罪、剧情', '昆汀·塔伦蒂诺', 1, 'https://example.com/pulp_fiction.jpg', '两个黑帮杀手、一个拳击手、一个黑帮头目的妻子以及两个餐馆抢劫犯的生活，在暴力和救赎的四个故事中交织在一起。', '1994-10-14'),
(4, '楚门的世界', '剧情、科幻', '彼得·威尔', 1, 'https://example.com/the_truman_show.jpg', '一个男人在不知情的情况下成为一个全球电视节目的主角，而他的生活实际上是被监视的。', '1998-06-05'),
(5, '星际穿越', '剧情、科幻', '克里斯托弗·诺兰', 1, 'https://example.com/interstellar.jpg', '一群探险家通过虫洞进入宇宙的深处，以寻找人类可居住的星球来拯救人类。', '2014-11-07'),
(6, '泰坦尼克号', '剧情、爱情', '詹姆斯·卡梅隆', 1, 'https://example.com/titanic.jpg', '在豪华客轮泰坦尼克号的首次航行中，一位贫穷的艺术家与一位富家女子之间发生了一段不可磨灭的爱情故事。', '1997-12-19'),
(7, '狮子王', '动画、冒险、剧情', '罗杰·阿勒斯', 1, 'https://example.com/lion_king.jpg', '一只年轻的狮子王子在成长的过程中面临着艰难的选择和困境，最终回归他的王国并接受自己的使命。', '1994-06-15'),
(8, '放牛班的春天', '剧情、音乐', '克里斯托夫·巴拉蒂', 1, 'https://example.com/les_choristes.jpg', '一位音乐家成为一所男子寄宿学校的教师，通过音乐改变了学生们的生活。', '2004-03-17'),
(9, '阿甘正传', '剧情、爱情', '罗伯特·泽米吉斯', 1, 'https://example.com/forrest_gump.jpg', '一个智商低下的男子通过坚强的意志和纯真的心灵在生活中取得了非凡的成就。', '1994-07-06'),
(10, '美丽人生', '剧情、喜剧、爱情', '罗伯托·贝尼尼', 1, 'https://example.com/life_is_beautiful.jpg', '在二战期间，一位犹太人父亲为了保护自己的儿子，将困境变成了一场充满幽默和爱的游戏。', '1997-12-20'),
(11, '指环王：护戒使者', '动作、冒险、剧情', '彼得·杰克逊', 1, 'https://example.com/lotr_fellowship.jpg', '一群不同种族的伙伴踏上了一段艰险的旅程，以摧毁邪恶的魔戒并拯救中土世界。', '2001-12-19'),
(12, '盗梦空间', '剧情、科幻、动作', '克里斯托弗·诺兰', 1, 'https://example.com/inception.jpg', '一位潜入者进入人们的梦境，以盗取机密信息或植入想法，但这次任务却变成了一场更加复杂和危险的挑战。', '2010-07-16'),
(13, '当幸福来敲门', '剧情、传记', '加布里尔·穆奇诺', 1, 'https://example.com/the_pursuit_of_happyness.jpg', '一个失业的父亲为了给儿子创造更好的生活，奋斗不息并追求幸福的真正含义。', '2006-12-15'),
(14, '黑客帝国', '动作、科幻', '莉莉·沃卓斯基、拉娜·沃卓斯基', 1, 'https://example.com/the_matrix.jpg', '一名普通程序员发现自己生活在一个虚拟现实中，并加入了一场对抗机器人统治的抵抗运动。', '1999-03-31'),
(15, '寻梦环游记', '动画、冒险、剧情', '李·昂克里奇', 1, 'https://example.com/coco.jpg', '一位年轻的男孩通过音乐和亡灵的世界，寻找他已故的祖先并揭开家族秘密的故事。', '2017-10-27'),
(16, '美女与野兽', '爱情、奇幻、音乐', '比尔·康顿', 1, 'https://example.com/beauty_and_the_beast.jpg', '一个年轻的女孩被困在一个魔法城堡中，并与被诅咒成野兽的王子展开了一段不同寻常的爱情故事。', '2017-03-17'),
(17, '哈利·波特与魔法石', '奇幻、冒险', '克里斯·哥伦布', 1, 'https://example.com/harry_potter_sorcerers_stone.jpg', '一个普通男孩发现自己是魔法世界中一个著名的巫师，并加入霍格华茨魔法学校的冒险故事。', '2001-11-16'),
(18, '无间道', '犯罪、剧情、惊悚', '刘伟强、麦兆辉', 1, 'https://example.com/infernal_affairs.jpg', '一名卧底警察和一名卧底黑帮分别试图揭露对方的身份，并在互相追踪中陷入危险的境地。', '2002-12-12'),
(19, '让子弹飞', '喜剧、动作、西部', '姜文', 1, 'https://example.com/let_the_bullets_fly.jpg', '在乱世中，一个冒充官员的阴谋家与一个悍匪领导的团队展开了一场互相较量的故事。', '2010-12-16'),
(20, '千与千寻', '动画、奇幻、冒险', '宫崎骏', 1, 'https://example.com/spirited_away.jpg', '一个年轻的女孩进入了一个神秘的灵界，她必须通过勇气和坚持来拯救她的父母并找到回家的方法。', '2001-07-20');

-- 向 room 表插入示例数据
INSERT INTO room (id, name)
VALUES (1, 'Room 1'),
       (2, 'Room 2'),
       (3, 'Room 3');

-- 向 user 表插入示例数据
INSERT INTO cinema.user (id, username, password) VALUES (1, 'user1', 'password1');
INSERT INTO cinema.user (id, username, password) VALUES (2, 'user2', 'password2');
INSERT INTO cinema.user (id, username, password) VALUES (3, 'user3', 'password3');
INSERT INTO cinema.user (id, username, password) VALUES (111, '张三', '123456');
INSERT INTO cinema.user (id, username, password) VALUES (888, '888', '888');


-- 向 session 表插入示例数据
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (1, '2023-01-01 10:00:00', 1, 1, 100);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (2, '2023-02-01 14:00:00', 2, 2, 120);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (3, '2023-03-01 18:00:00', 3, 3, 80);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (4, '2023-05-24 18:30:00', 4, 2, 65);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (5, '2023-05-25 19:15:00', 5, 3, 70);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (6, '2023-05-25 21:30:00', 6, 3, 75);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (7, '2023-05-26 16:45:00', 7, 1, 50);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (8, '2023-05-26 19:00:00', 8, 1, 60);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (9, '2023-05-27 20:30:00', 9, 2, 55);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (10, '2023-05-27 22:45:00', 10, 2, 65);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (11, '2023-05-28 17:30:00', 11, 3, 70);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (12, '2023-05-28 20:00:00', 12, 3, 75);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (13, '2023-05-29 14:15:00', 13, 1, 50);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (14, '2023-05-29 17:00:00', 14, 1, 60);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (15, '2023-05-30 19:45:00', 15, 2, 55);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (16, '2023-05-30 22:00:00', 16, 2, 65);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (17, '2023-05-31 16:30:00', 17, 3, 70);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (18, '2023-05-31 19:15:00', 18, 3, 75);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (19, '2023-06-01 15:45:00', 19, 1, 50);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (20, '2023-06-01 18:30:00', 20, 1, 60);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (21, '2023-06-02 19:30:00', 1, 2, 55);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (22, '2023-06-02 22:00:00', 1, 3, 60);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (23, '2023-06-03 15:30:00', 2, 1, 50);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (24, '2023-06-03 18:00:00', 2, 3, 65);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (25, '2023-06-04 20:15:00', 3, 2, 60);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (26, '2023-06-04 22:30:00', 3, 3, 65);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (27, '2023-06-05 16:45:00', 4, 1, 55);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (28, '2023-06-05 19:15:00', 4, 2, 60);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (29, '2023-06-06 20:30:00', 5, 1, 50);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (30, '2023-06-06 22:45:00', 5, 2, 55);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (31, '2023-06-07 17:15:00', 6, 2, 60);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (32, '2023-06-07 20:00:00', 6, 3, 65);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (33, '2023-06-08 14:30:00', 7, 1, 50);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (34, '2023-06-08 17:00:00', 7, 3, 65);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (35, '2023-06-09 19:45:00', 8, 2, 55);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (36, '2023-06-09 22:15:00', 8, 3, 60);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (37, '2023-06-10 16:30:00', 9, 1, 50);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (38, '2023-06-10 19:00:00', 9, 2, 55);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (39, '2023-06-11 20:45:00', 10, 1, 50);
INSERT INTO cinema.session (id, start_time, movie_id, room_id, price) VALUES (40, '2023-06-11 23:00:00', 10, 2, 55);


-- 向 seat 表插入示例数据
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (1, 'A', 1, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (2, 'A', 2, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (3, 'A', 3, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (4, 'A', 4, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (5, 'B', 1, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (6, 'B', 2, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (7, 'B', 3, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (8, 'B', 4, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (9, 'C', 1, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (10, 'C', 2, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (11, 'C', 3, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (12, 'C', 4, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (13, 'D', 1, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (14, 'D', 2, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (15, 'D', 3, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (16, 'D', 4, 1);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (17, 'A', 1, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (18, 'A', 2, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (19, 'A', 3, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (20, 'A', 4, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (21, 'B', 1, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (22, 'B', 2, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (23, 'B', 3, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (24, 'B', 4, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (25, 'C', 1, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (26, 'C', 2, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (27, 'C', 3, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (28, 'C', 4, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (29, 'D', 1, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (30, 'D', 2, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (31, 'D', 3, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (32, 'D', 4, 2);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (33, 'A', 1, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (34, 'A', 2, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (35, 'A', 3, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (36, 'A', 4, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (37, 'B', 1, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (38, 'B', 2, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (39, 'B', 3, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (40, 'B', 4, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (41, 'C', 1, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (42, 'C', 2, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (43, 'C', 3, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (44, 'C', 4, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (45, 'D', 1, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (46, 'D', 2, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (47, 'D', 3, 3);
INSERT INTO cinema.seat (id, seat_row, seat_col, room_id) VALUES (48, 'D', 4, 3);


-- 向 ticket 表插入示例数据
INSERT INTO cinema.ticket (id, session_id, seat_id) VALUES (1, 1, 1);
INSERT INTO cinema.ticket (id, session_id, seat_id) VALUES (2, 2, 3);
INSERT INTO cinema.ticket (id, session_id, seat_id) VALUES (3, 3, 6);
INSERT INTO cinema.ticket (id, session_id, seat_id) VALUES (4, 15, 17);
INSERT INTO cinema.ticket (id, session_id, seat_id) VALUES (5, 15, 18);
INSERT INTO cinema.ticket (id, session_id, seat_id) VALUES (6, 15, 19);
INSERT INTO cinema.ticket (id, session_id, seat_id) VALUES (7, 15, 20);


-- 向 indent 表插入示例数据
INSERT INTO cinema.indent (id, purchase_time, ticket_id, user_id) VALUES (1, '2023-01-01 09:30:00', 1, 1);
INSERT INTO cinema.indent (id, purchase_time, ticket_id, user_id) VALUES (2, '2023-02-01 13:45:00', 2, 2);
INSERT INTO cinema.indent (id, purchase_time, ticket_id, user_id) VALUES (3, '2023-03-01 17:30:00', 3, 3);
INSERT INTO cinema.indent (id, purchase_time, ticket_id, user_id) VALUES (4, '2023-05-28 17:22:10', 4, 111);
INSERT INTO cinema.indent (id, purchase_time, ticket_id, user_id) VALUES (5, '2023-05-28 18:22:10', 5, 111);
INSERT INTO cinema.indent (id, purchase_time, ticket_id, user_id) VALUES (6, '2023-05-28 19:22:10', 6, 111);
INSERT INTO cinema.indent (id, purchase_time, ticket_id, user_id) VALUES (7, '2023-05-28 17:22:10', 7, 111);
