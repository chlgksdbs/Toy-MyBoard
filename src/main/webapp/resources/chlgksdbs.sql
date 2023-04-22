DROP DATABASE IF EXISTS chlgksdbs;

CREATE DATABASE chlgksdbs;

USE chlgksdbs;

CREATE TABLE user_tb
(
	user_id		VARCHAR(40) PRIMARY KEY,
    user_pw		VARCHAR(100) NOT NULL,
    user_name	VARCHAR(40) NOT NULL
);

INSERT INTO user_tb
VALUES ("admin", "admin", "admin"),
("chlgksdbs", "1234", "한윤"),
("zosunny", "1234", "해린");


CREATE TABLE board_tb
(
	bno 			INT PRIMARY KEY AUTO_INCREMENT,
    btitle 			VARCHAR(40) NOT NULL,
    bwriter 		VARCHAR(40) NOT NULL,
    bcontent 		VARCHAR(100) NOT NULL,
    bwrite_date 	DATETIME NOT NULL,
    FOREIGN KEY(bwriter) REFERENCES user_tb(user_id) ON UPDATE CASCADE
);

INSERT INTO board_tb (btitle, bwriter, bcontent, bwrite_date)
VALUES ("첫 번째 글", "admin", "첫 번째 내용", now()),
("두 번째 글", "admin", "두 번째 내용", now()),
("세 번째 글", "admin", "세 번째 내용", now());
