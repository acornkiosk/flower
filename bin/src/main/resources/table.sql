
--키오스크 관리 DB 생성
DROP TABLE kiosk CASCADE CONSTRAINTS;
DROP TABLE USERs CASCADE CONSTRAINTS;
DROP SEQUENCE seq_kiosk_id;
DROP SEQUENCE seq_user_id;
CREATE SEQUENCE seq_kiosk_id;
CREATE TABLE kiosk(
	id NUMBER CONSTRAINT kiosk_id_pk PRIMARY KEY, -- 키오스크 아이디
	location VARCHAR2(50) CONSTRAINT kiosk_location_nn NOT NULL, -- 키오스크 위치
	is_using VARCHAR2(10) CONSTRAINT kiosk_is_using_nn NOT NULL
);
<<<<<<< Updated upstream

-- 메뉴 관리 DB 생성
CREATE SEQUENCE menu_seq;

CREATE TABLE menu_info(
 id NUMBER PRIMARY KEY NOT NULL,
 name VARCHAR2(50) NOT NULL,
 price NUMBER NOT NULL,
 description VARCHAR2(300),
 img_url VARCHAR2(2000),
 is_sold VARCHAR2(50) NOT NULL,
 category VARCHAR2(50) NOT NULL);
 
 DROP sequence menu_seq;
 DROP table menu_info;
 
INSERT INTO menu_info
  (ID, NAME, PRICE, DESCRIPTION, IMG_URL, IS_SOLD, CATEGORY) 
VALUES 
  (menu_seq.nextVal, '꽃', 2000, '예쁜 꽃', NULL, '팜', '한송이');

-- 사용자 관리 DB 생성
CREATE SEQUENCE seq_user_id;
CREATE TABLE users (
    id VARCHAR2(100) CONSTRAINT users_id_pk PRIMARY KEY, -- 사용자 아이디
    password VARCHAR2(100) CONSTRAINT users_password_nn NOT NULL, -- 사용자 비밀번호
    role VARCHAR2(50) CONSTRAINT users_role_nn NOT NULL, -- 역할
);


