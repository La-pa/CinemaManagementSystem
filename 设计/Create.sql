CREATE TABLE movie (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),
    genre VARCHAR(50),
    director VARCHAR(50),
    show_status INT,
    image_url VARCHAR(200),
    introduction VARCHAR(500),
    release_date DATETIME
);

CREATE TABLE room (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50)
);


CREATE TABLE session (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    start_time DATETIME,
    movie_id BIGINT,
    room_id BIGINT,
    price INT,
    FOREIGN KEY (movie_id) REFERENCES movie(id),
    FOREIGN KEY (room_id) REFERENCES room(id)
);

CREATE TABLE seat (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    seat_row CHAR(1),
    seat_col INT,
    room_id BIGINT,
    FOREIGN KEY (room_id) REFERENCES room(id)
);

CREATE TABLE ticket (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    session_id BIGINT,
    seat_id BIGINT,
    FOREIGN KEY (session_id) REFERENCES session(id),
    FOREIGN KEY (seat_id) REFERENCES seat(id)
);

CREATE TABLE indent (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    purchase_time DATETIME,
    ticket_id BIGINT,
    user_id BIGINT,
    FOREIGN KEY (ticket_id) REFERENCES ticket(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);





