CREATE DATABASE prj2;

USE prj2;


CREATE TABLE board
(
    id INT PRIMARY KEY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL ,
    content VARCHAR(3000) NOT NULL,
    inserted DATETIME NOT NULL DEFAULT NOW()
);

DROP TABLE board;

SELECT *
FROM board;

SELECT COUNT(*)
FROM board;

INSERT INTO board
(title, content)
SELECT title, content
FROM board;