/* VIEW */
-- SELECT 쿼리문을 저장한 객체로 가상테이블이라고 불린다.
-- 실질적인 데이터를 물리적으로 저장하고 있지 않음.
-- 테이블을 사용하는 것과 동일하게 사용할 수 있다.

-- VIEW 생성
CREATE VIEW HANSIK AS
    SELECT 
        MENU_CODE,
        MENU_NAME,
        MENU_PRICE,
        CATEGORY_CODE,
        ORDERABLE_STATUS
    FROM
        TBL_MENU
    WHERE
        CATEGORY_CODE = 4;

SELECT 
    *
FROM
    HANSIK;

-- 베이스 테이블의 정보가 변경되면 view 결과도 같이 변경된다.
INSERT INTO TBL_MENU VALUES (NULL, '식혜맛국밥', 5500, 4, 'Y');

-- view를 통한 dml
-- 1) INSERT
INSERT INTO HANSIK VALUES (99, '수정과맛 국밥', 5500, 4, 'Y');

-- 2) UPDATE
UPDATE HANSIK 
SET 
    MENU_NAME = '버터맛국밥',
    MENU_PRICE = 5700
WHERE
    MENU_CODE = 99;

SELECT 
    *
FROM
    TBL_MENU;
    
-- 3) DELETE
DELETE FROM HANSIK 
WHERE
    MENU_CODE = 99;
    
SELECT 
    *
FROM
    HANSIK;
SELECT 
    *
FROM
    TBL_MENU;
    
-- VIEW 삭제
DROP VIEW HANSIK;
