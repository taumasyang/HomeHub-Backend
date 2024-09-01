DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS alerts;
DROP TABLE IF EXISTS newsletters;
DROP TABLE IF EXISTS policies;

CREATE TABLE users
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(100) NOT NULL,
    enabled  TINYINT      NOT NULL DEFAULT 1
);


CREATE TABLE events
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL UNIQUE,
    content TEXT,
    event_time DATETIME,
    update_time DATETIME,
    publisher_id INT

);

CREATE TABLE alerts
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL UNIQUE,
    content TEXT,
    update_time DATETIME,
    publisher_id INT

);

CREATE TABLE newsletters
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL UNIQUE,
    content TEXT,
    update_time DATETIME,
    publisher_id INT

);

CREATE TABLE policies
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL UNIQUE,
    content TEXT,
    update_time DATETIME,
    publisher_id INT

);
