CREATE TABLE IF NOT EXISTS messages
(
    id   VARCHAR(60) DEFAULT UUID() PRIMARY KEY,
    text VARCHAR(100) NOT NULL
);