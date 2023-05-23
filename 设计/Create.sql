CREATE TABLE movie (
    id INT PRIMARY KEY,
    title VARCHAR(50),
    genre VARCHAR(50),
    director VARCHAR(50),
    show_status INT,
    image_url VARCHAR(200),
    introduction VARCHAR(500),
    release_date DATETIME
);

CREATE TABLE room (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE user (
    id INT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);


CREATE TABLE session (
    id INT PRIMARY KEY,
    start_time DATETIME,
    movie_id INT,
    room_id INT,
    price INT,
    FOREIGN KEY (movie_id) REFERENCES movie(id),
    FOREIGN KEY (room_id) REFERENCES room(id)
);

CREATE TABLE seat (
    id INT PRIMARY KEY,
    seat_row CHAR(1),
    seat_col INT,
    room_id INT,
    FOREIGN KEY (room_id) REFERENCES room(id)
);

CREATE TABLE ticket (
    id BIGINT PRIMARY KEY,
    session_id INT,
    seat_id INT,
    FOREIGN KEY (session_id) REFERENCES session(id),
    FOREIGN KEY (seat_id) REFERENCES seat(id)
);

CREATE TABLE indent (
    id BIGINT PRIMARY KEY,
    purchase_time DATETIME,
    ticket_id BIGINT,
    user_id INT,
    FOREIGN KEY (ticket_id) REFERENCES ticket(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

