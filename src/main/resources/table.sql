
--키오스크 관리 DB 생성
CREATE SEQUENCE seq_kiosk_id;
CREATE TABLE kiosk(
	id NUMBER CONSTRAINT kiosk_id_pk PRIMARY KEY, -- 키오스크 아이디
	location VARCHAR2(50) CONSTRAINT kiosk_location_nn NOT NULL, -- 키오스크 위치
	is_using VARCHAR2(10) CONSTRAINT kiosk_is_using_nn NOT NULL
);

----- 메뉴관리 DB 용(시작) -----

CREATE SEQUENCE menu_seq;

CREATE TABLE menu_info(
 id NUMBER PRIMARY KEY NOT NULL,
 name VARCHAR2(50) NOT NULL,
 price NUMBER NOT NULL,
 one_sentence VARCHAR2(100),
 description VARCHAR2(300),
 img_url VARCHAR2(2000),
 is_sold VARCHAR2(50) NOT NULL,
 category VARCHAR2(50) NOT NULL);
 
 DROP sequence menu_seq;
 DROP table menu_info;
 
 CREATE SEQUENCE category_seq;
 
 CREATE TABLE category_info(
 id NUMBER PRIMARY KEY NOT NULL,
 category VARCHAR2(50) NOT NULL);
 
 
 DROP sequence category_seq;
 DROP table category_info;
 
 
 
----- 메뉴관리 DB 용(끝) -----
 

-- 사용자 관리 DB 생성
CREATE SEQUENCE seq_user_id;
CREATE TABLE users (
    id VARCHAR2(100) CONSTRAINT users_id_pk PRIMARY KEY, -- 사용자 아이디
    password VARCHAR2(100) CONSTRAINT users_password_nn NOT NULL, -- 사용자 비밀번호
    role VARCHAR2(50) CONSTRAINT users_role_nn NOT NULL -- 역할
);

DROP TABLE users;

SELECT * from kiosk;



-- 로그인 관리 DB 생성
CREATE TABLE login_tb(
user_id varchar2(100) CONSTRAINT login_tb_user_id_pk primary key, 
user_pwd varchar2(100) CONSTRAINT login_tb_user_pwd_nn NOT NULL,
rank varchar2(50) CONSTRAINT login_tb_user_rank check (rank in('super','ceo','emp')) 
);

drop table login_tb;

--insert into login_tb values('testsuper', '1234', 'super');       //테스트용 계정 만들기
--insert into login_tb values('testceo', '1234', 'ceo');
--insert into login_tb values('testemp', '1234', 'emp');

