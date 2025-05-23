/* DDL(Data Definition Language) */
-- 데이터베이스의 스키마를 정의하거나 수정하는데 사용되는 SQL의 한 부분이다.

/* CREATE */
-- 테이블 생성을 위한 구문
-- IF NOT EXISTS를 적용하면 기존에 존재하는 테이블이라도 에러가 발생하지 않는다.

-- tb1 생성
CREATE TABLE IF NOT EXISTS TB1(
	PK INT PRIMARY KEY, -- PRIMARY KEY이기 때문에 NULL이 들어갈 수 없다.
    FK INT,
    COL1 VARCHAR(255),
    CHECK(COL1 IN('Y', 'N')) -- COL1에는 y나 n 만 들어간다.
)ENGINE = INNODB;

-- 테이블 구조 확인
DESCRIBE TB1;

INSERT INTO TB1 VALUES(1, 10, 'Y');

SELECT 
    *
FROM
    TB1;

/* AUTO INCREMENT */
-- INSERT 시 PRIMARY KEY에 해당하는 컬럼에 자동으로 번호를 발생(중복되지 않게)시켜 저장할 수 있다.
CREATE TABLE IF NOT EXISTS TB2 (
    PK INT AUTO_INCREMENT PRIMARY KEY,
    FK INT,
    COL1 VARCHAR(255),
    CHECK (COL1 IN ('Y' , 'N'))
)  ENGINE=INNODB;

DESCRIBE TB2;

INSERT INTO TB2 VALUES(NULL, 10, 'Y');
INSERT INTO TB2 VALUES(NULL, 20, 'Y');

SELECT 
    *
FROM
    TB2;

/* ALTER */
-- 테이블에 추가, 변경, 수정, 삭제하는 모든 것은 ALTER 명령를 사용해 적용한다.

-- 열 추가
ALTER TABLE TB2
ADD COL2 INT NOT NULL;

DESCRIBE TB2;

-- 열 삭제
ALTER TABLE TB2
DROP COLUMN COL2;

-- 열 이름 및 데이터 형식 변경
ALTER TABLE TB2
CHANGE COLUMN FK CHANGE_FK INT NOT NULL;

-- 열 제약 조건 추가 및 삭제
-- TB2 테이블의 PRIMARY KEY 제약 조건 삭제
-- MODIFY로 정의한 뒤 DROP을 해줘야한다.

-- MODIFY로 컬럼의 정의 바꾸기
ALTER TABLE TB2
MODIFY PK INT;

ALTER TABLE TB2
DROP PRIMARY KEY;

-- 다시 PK 제약조건 추가
ALTER TABLE TB2
ADD PRIMARY KEY(PK);

DESCRIBE TB2;

/* DROP */
-- 테이블을 삭제하기 위한 구문
-- IF EXISTS 적용하면 존재하지 않는 테이블 삭제 구문이라도 에러가 발생하지 않는다.

CREATE TABLE IF NOT EXISTS TB3(
	PK INT AUTO_INCREMENT PRIMARY KEY,
    FK INT,
    COL1 VARCHAR(255)
) ENGINE = INNODB;

DROP TABLE IF EXISTS TB3;
DROP TABLE IF EXISTS TB1, TB2;

/* TRUNCATE */
-- 논리적으로는 WHERE절이 없는 DELETE구문과 큰 차이가 없어 보인다.
-- 하지만 어차피 데이터를 다 삭제할 경우 행마다 하나씩 지워지는 DELETE보다
-- DROP 이후 바로 테이블을 재생성 해주는 TRUNCATE가 훨씬 효율적으로 한번에 테이블을 초기화시켜준다.
-- 또한 AUTO_INCREMENT컬럼이 있는 경우 시작 값을 0으로 초기화가 된다.

CREATE TABLE IF NOT EXISTS TB4(
	PK INT AUTO_INCREMENT PRIMARY KEY,
    FK INT,
    COL1 VARCHAR(255),
    CHECK(COL1 IN ('Y', 'N'))
) ENGINE = INNODB;

DESCRIBE TB4;

INSERT INTO TB4 VALUES(NULL, 10, 'Y');
INSERT INTO TB4 VALUES(NULL, 20, 'Y');
INSERT INTO TB4 VALUES(NULL, 30, 'Y');
INSERT INTO TB4 VALUES(NULL, 40, 'Y');

SELECT * FROM TB4;

-- 테이블 초기화 하기
-- 두 가지 방법이 있다.
TRUNCATE TB4;
TRUNCATE TABLE TB4;

