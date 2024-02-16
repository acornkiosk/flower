
--키오스크 관리 DB 생성
CREATE SEQUENCE seq_kiosk_id;
CREATE TABLE kiosk(
	id NUMBER CONSTRAINT kiosk_id_pk PRIMARY KEY, -- 키오스크 아이디
	location VARCHAR2(50) CONSTRAINT kiosk_location_nn NOT NULL, -- 키오스크 위치
	is_using VARCHAR2(10) CONSTRAINT kiosk_is_using_nn NOT NULL
);

----- 메뉴관리 DB 용(시작) -----

CREATE SEQUENCE menu_seq;

CREATE TABLE menu( 
 id NUMBER PRIMARY KEY NOT NULL,
 name VARCHAR2(50) NOT NULL,
 price NUMBER NOT NULL,
 summary VARCHAR2(100),  
 description VARCHAR2(300),
 img_url VARCHAR2(2000),  
 is_sold VARCHAR2(50) NOT NULL,
 category VARCHAR2(50)); 
 
 DROP sequence menu_seq;
 DROP table menu;
 


 CREATE SEQUENCE category_seq;

 CREATE TABLE category( -- 테이블 title 수정
 id NUMBER PRIMARY KEY NOT NULL,
 name VARCHAR2(50) NOT NULL); 
 
 DROP sequence category_seq;
 DROP table category;

--matchs
 CREATE SEQUENCE seq_matchs;
 
 CREATE TABLE matchs(
 id NUMBER PRIMARY KEY,
 category_id NUMBER NOT NULL,
 option_id NUMBER NOT NULL,
 CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE,
 CONSTRAINT fk_option_id2 FOREIGN KEY (option_id) REFERENCES options(id) ON DELETE CASCADE
 );
 
 DROP SEQUENCE seq_matchs;
 DROP TABLE matchs;


--options
 CREATE SEQUENCE options_seq;

 CREATE TABLE options(
 id NUMBER PRIMARY KEY,
 name VARCHAR2(50) NOT NULL
 ); 
 
 DROP SEQUENCE options_seq;
 DROP TABLE options;
 
 --option_details 
 CREATE SEQUENCE options_details_seq;
 
 CREATE TABLE option_details(
 option_id NUMBER,
 id NUMBER PRIMARY KEY NOT NULL,
 name VARCHAR2(50) NOT NULL,
 price NUMBER NOT NULL,
 img_url VARCHAR2(2000),
 CONSTRAINT fk_option_id FOREIGN KEY (option_id) REFERENCES options(id) ON DELETE CASCADE
 ); 
 

 
 DROP SEQUENCE options_details_seq;
 DROP TABLE option_details;

 

 
 --menu_set
 CREATE SEQUENCE menu_set_seq;
  
 CREATE TABLE menu_set(
 set_id NUMBER,
 menu_id NUMBER NOT NULL
 );
 
 
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
 menu_id VARCHAR2(50) CONSTRAINT order_menu_id_nn NOT NULL, -- 메뉴 항목,
 menu_count NUMBER CONSTRAINT order_menu_count_ch CHECK (menu_count > 0),--메뉴 갯수
 kiosk_id NUMBER CONSTRAINT kiosk_id_NN NOT NULL, -- 주문한 키오스크 id
 is_completed VARCHAR2(5) CONSTRAINT kiosk_is_completed_ch CHECK (is_completed IN ('true','false')),
 regdate DATE --주문시간
);



--자동 로그인 토큰 저장하기위한 테이블--
CREATE TABLE persistent_logins
(
    username   VARCHAR2(38) NOT NULL,  --사용자 id
    series     VARCHAR2(64) NOT NULL,  --브라우저 쿠키를 구별하는 고유 값
    token      VARCHAR2(64) NOT NULL, --﻿브라우저 가지고있는 쿠키의 값 인증값
    last_used  TIMESTAMP   NOT NULL --최근 로그인 시간
);