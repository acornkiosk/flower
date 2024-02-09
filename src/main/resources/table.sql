
--키오스크 관리 DB 생성
CREATE SEQUENCE seq_kiosk_id;
CREATE TABLE kiosk(
	id NUMBER CONSTRAINT kiosk_id_pk PRIMARY KEY, -- 키오스크 아이디
	location VARCHAR2(50) CONSTRAINT kiosk_location_nn NOT NULL, -- 키오스크 위치
	is_using VARCHAR2(10) CONSTRAINT kiosk_is_using_nn NOT NULL
);

----- 메뉴관리 DB 용(시작) -----

CREATE SEQUENCE menu_seq;

CREATE TABLE menu( -- 테이블 title 수정
 id NUMBER PRIMARY KEY NOT NULL,
 name VARCHAR2(50) NOT NULL,
 price NUMBER NOT NULL,
 summary VARCHAR2(100),  -- 컬럼수정
 description VARCHAR2(300),
 img_url VARCHAR2(2000),  
 is_sold VARCHAR2(50) NOT NULL,
 category VARCHAR2(50)); -- not null 해제
 
 DROP sequence menu_seq;
 DROP table menu;
 
 CREATE SEQUENCE category_seq;
 
 CREATE TABLE category( -- 테이블 title 수정
 id NUMBER PRIMARY KEY NOT NULL,
 name VARCHAR2(50) NOT NULL); --컬럼수정
 
 
 DROP sequence category_seq;
 DROP table category;
 
 
 
----- 메뉴관리 DB 용(끝) -----
 

-- 사용자 관리 DB 생성
CREATE SEQUENCE seq_user_id;
CREATE TABLE users (
    id VARCHAR2(100) CONSTRAINT users_id_pk PRIMARY KEY, -- 사용자 아이디
    password VARCHAR2(100) CONSTRAINT users_password_nn NOT NULL, -- 사용자 비밀번호
    rank varchar2(50) CONSTRAINT login_tb_user_rank_ch check (rank in('super','owner','emp'))  -- 역할
);

DROP TABLE users;

-- 주문 관리 DB 생성
CREATE SEQUENCE seq_order_id;
CREATE TABLE orders(
 id NUMBER CONSTRAINT order_id_nn NOT NULL, -- 주문 번호
 menu_id NUMBER CONSTRAINT order_menu_id_nn NOT NULL, -- 메뉴 항목,
 menu_count NUMBER CONSTRAINT order_menu_count_ch CHECK (menu_count > 0),--메뉴 갯수
 kiosk_id NUMBER CONSTRAINT kiosk_id_NN NOT NULL, -- 주문한 키오스크 id
 is_completed VARCHAR2(5) CONSTRAINT kiosk_is_completed_ch CHECK (is_completed IN ('true','false')),
 regdate DATE --주문시간
);

