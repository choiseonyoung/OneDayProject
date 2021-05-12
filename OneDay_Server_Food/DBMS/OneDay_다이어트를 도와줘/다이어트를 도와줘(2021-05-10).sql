-- CREATE TABLE 할 때 외래키 설정하면 데이터 임포트할 때 문제가 생길 수 있음

CREATE TABLE tbl_foods (
    fd_fcode CHAR(7) PRIMARY KEY,
    fd_name	VARCHAR2(125) NOT NULL,
    fd_year	NUMBER	NOT NULL,
    fd_mcode CHAR(6) NOT NULL,
    fd_ccode CHAR(4) NOT NULL,
    fd_size	NUMBER,
    fd_total NUMBER,
    fd_kcal	NUMBER,
    fd_prot	NUMBER,
    fd_fat	NUMBER,
    fd_carb	NUMBER,
    fd_sugar	NUMBER
);
DROP TABLE tbl_foods;

CREATE TABLE tbl_company (
    cp_code	CHAR(6)	PRIMARY KEY,
    cp_name	VARCHAR2(125) NOT NULL
);
DROP TABLE tbl_company;

CREATE TABLE tbl_items (
    it_code	CHAR(4)	PRIMARY KEY,
    it_name	VARCHAR2(20) NOT NULL
);
DROP TABLE tbl_items;

-- 세개의 table간에 참조무결성 설정
-- 누가 부모이고, 누가 자손인지 파악
-- 자손 : tbl_foods, 부모 : tbl_company, tbl_items
-- FK 설정은 자손 table에 설정하기
-- 외래키 한 개씩 따로따로 설정해야 함
ALTER TABLE tbl_foods
ADD CONSTRAINT fk_company -- 제약조건을 설정할건데 그 이름을 fk_company로 하겠다 (이름은 삭제할때말곤 크게 중요하지 않음)
FOREIGN KEY(fd_mcode)
REFERENCES tbl_company(cp_code);

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_items
FOREIGN KEY(fd_ccode)
REFERENCES tbl_items(it_code);

-- 컬럼 이름이 겹치는 게 하나도 없으면 AS 안 써도 됨
CREATE VIEW view_식품정보 AS
(
    SELECT
    FD.fd_fcode AS 식품코드,
    FD.fd_name AS 식품명,
    FD.fd_year AS 출시연도,
    FD.fd_mcode AS 제조사코드,
    CP.cp_name AS 제조사명,
    FD.fd_ccode AS 분류코드,
    IT.it_name AS 분류명,
    FD.fd_size AS "1회제공량",
    FD.fd_total AS 총내용량,
    FD.fd_kcal AS 에너지,
    FD.fd_prot AS 단백질,
    FD.fd_fat AS 지방,
    FD.fd_carb AS 탄수화물,
    FD.fd_sugar AS 총당류
    FROM tbl_foods FD
        LEFT JOIN tbl_company CP
        ON FD.fd_mcode = CP.cp_code
        LEFT JOIN tbl_items IT
        ON FD.fd_ccode = IT.it_code
);
DROP VIEW view_식품정보;
SELECT * FROM view_식품정보;


CREATE TABLE tbl_myfoods (
    mf_seq NUMBER PRIMARY KEY,
    mf_date	CHAR(10) NOT NULL,
    mf_code	CHAR(7) NOT NULL,
    mf_take	NUMBER NOT NULL
);
DROP TABLE tbl_myfoods;
DELETE tbl_myfoods;

CREATE SEQUENCE mf_seq
START WITH 1
INCREMENT BY 1;
DROP SEQUENCE seq_myfoods;

INSERT INTO tbl_myfoods(mf_seq, mf_date, mf_code, mf_take)
VALUES (0, '2021-05-10', 'PD00017', 1);

CREATE VIEW view_섭취정보 AS
(
    SELECT
    m.mf_seq AS 번호,
    m.mf_date AS 날짜,
    v.식품명,
    m.mf_take AS 섭취량,
    v.총내용량 * m.mf_take AS 총내용량,
    v.에너지 * m.mf_take AS 에너지,
    v.단백질 * m.mf_take AS 단백질,
    v.지방 * m.mf_take AS 지방,
    v.탄수화물 * m.mf_take AS 탄수화물,
    v.총당류 * m.mf_take AS 총당류
    FROM tbl_myfoods m
        LEFT JOIN view_식품정보 v
        ON m.mf_code = v.식품코드
);
DROP VIEW view_섭취정보;
SELECT * FROM view_섭취정보;

SELECT * FROM view_섭취정보
WHERE 날짜 = '2021-05-11';

SELECT * FROM tbl_foods
WHERE fd_name LIKE '%' || '바나나' || '%';

DELETE tbl_myfoods;