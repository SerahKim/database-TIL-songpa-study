/* SELECT */
/* 
SELECT절은 MYSQL의 가장 기본적인 명령어로
특정 테이블에서 원하는 데이터를 조회해서 가져오는데 사용된다.	
*/

-- 소문자/대문자 구분하지 않는다.
SELECT MENU_NAME
  FROM tbl_menu;

SELECT 
    MENU_CODE, MENU_NAME, MENU_PRICE
FROM
    tbl_menu;

-- 테이블 요소 전체 조회
SELECT * FROM tbl_menu;

SELECT 6 + 3;
SELECT 6 * 3;
SELECT 6 % 3;  

SELECT NOW();

-- 컬럼 별칭
SELECT CONCAT('홍', '', '길동') AS name;
