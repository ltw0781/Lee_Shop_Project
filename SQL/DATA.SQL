-- Active: 1750141999158@@127.0.0.1@3306@shopping
-- DROP TABLE user;
-- DROP TABLE board;
-- DROP TABLE cart;
-- DROP TABLE product;
-- DROP TABLE user_auth;
-- DROP TABLE persistent_logins;
-- DROP TABLE payment;
-- DROP TABLE orders;
-- DROP TABLE file;

INSERT INTO user ( username, password, name, email )
VALUES ( 'user', '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92', '사용자', 'user@mail.com' );

-- 관리자
INSERT INTO user ( username, password, name, email )
VALUES ( 'admin', '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92', '관리자', 'admin@mail.com' );

-- 테스트
INSERT INTO user ( username, password, name, email )
VALUES ( 'test', '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92', '테스트', 'test@mail.com' );

-- 권한
-- 사용자 
-- * 권한 : ROLE_USER
INSERT INTO user_auth ( username,  auth )
VALUES ( 'user', 'ROLE_USER' );

-- 관리자
-- * 권한 : ROLE_USER, ROLE_ADMIN
INSERT INTO user_auth ( username,  auth )
VALUES ( 'admin', 'ROLE_USER' );

INSERT INTO user_auth ( username,  auth )
VALUES ( 'admin', 'ROLE_ADMIN' );

INSERT INTO user_auth ( username,  auth )
VALUES ( 'test', 'ROLE_USER' );