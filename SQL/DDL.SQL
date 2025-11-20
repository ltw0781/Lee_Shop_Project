-- Active: 1752121213398@@127.0.0.1@3306@shopping

-- 자동 로그인 테이블 삭제
DROP TABLE persistent_logins;


SELECT *
FROM board;

DROP TABLE board;
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

DROP TABLE user;
-- 회원 테이블
CREATE TABLE `user` (
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

DROP TABLE user_auth;
-- 회원 권한 테이블
CREATE TABLE `user_auth` (
    no bigint NOT NULL AUTO_INCREMENT   -- 권한번호
,   username varchar(100) NOT NULL      -- 아이디
,   auth varchar(100) NOT NULL          -- 권한 (ROLE_USER, ROLE_ADMIN, ...)
,   PRIMARY KEY (no)
);


DROP TABLE file;
-- 파일 테이블
CREATE TABLE file (
    no INT AUTO_INCREMENT PRIMARY KEY,
    parent_table VARCHAR(100) NOT NULL,
    parent_no INT NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    origin_name VARCHAR(255) NOT NULL,
    file_path VARCHAR(255) NOT NULL,
    file_size BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    file_code VARCHAR(50)
);


DROP TABLE product;
-- 상품 테이블
CREATE TABLE product (
    product_no INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    stock INT DEFAULT 0,
    category VARCHAR(100),
    thumbnail VARCHAR(255),
    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    upd_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


DROP TABLE cart;
-- 장바구니 테이블
CREATE TABLE cart (
    cart_no INT AUTO_INCREMENT PRIMARY KEY,
    member_no INT NOT NULL,
    product_no INT NOT NULL,
    quantity INT DEFAULT 1,
    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_no) REFERENCES user(user_no),
    FOREIGN KEY (product_no) REFERENCES product(product_no)
);


DROP TABLE payment;
-- 결제정보 테이블
CREATE TABLE payment (
    payment_no INT AUTO_INCREMENT PRIMARY KEY,
    member_no INT NOT NULL,
    order_no VARCHAR(100) NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    payment_method VARCHAR(50),
    status VARCHAR(50) DEFAULT 'READY',
    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_no) REFERENCES user(user_no)
);


















