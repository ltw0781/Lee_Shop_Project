-- Active: 1763393025352@@127.0.0.1@3306@shopping

SELECT *
FROM board;

-- 게시판 테이블
CREATE TABLE `board` (
    `no` bigint NOT NULL AUTO_INCREMENT,
    `board_type` int NOT NULL,
    `category` varchar(255) NOT NULL,
    `title` varchar(255) NOT NULL,
    `writer` varchar(255) NOT NULL,
    `content` TEXT NOT NULL,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `view_count` int DEFAULT 0,
    PRIMARY KEY (`no`)
) COMMENT = '게시판';

-- 회원 테이블
CREATE TABLE `user` (
    `no` bigint NOT NULL AUTO_INCREMENT,
    `username` varchar(100) NOT NULL,
    `password` varchar(200) NOT NULL,
    `name` varchar(100) NOT NULL,
    `email` varchar(200) DEFAULT NULL,
    `phone` varchar(200) DEFAULT NULL,
    `address` varchar(200) DEFAULT NULL,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `enabled` int DEFAULT 1,
    PRIMARY KEY (`no`)
) COMMENT = '회원';

-- 회원 권한 테이블
CREATE TABLE `user_auth` (
    no bigint NOT NULL AUTO_INCREMENT   -- 권한번호
,   username varchar(100) NOT NULL      -- 아이디
,   auth varchar(100) NOT NULL          -- 권한 (ROLE_USER, ROLE_ADMIN, ...)
,   PRIMARY KEY (no)
);