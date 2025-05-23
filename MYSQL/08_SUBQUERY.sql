/* SUBQUERY */
/*
다른 쿼리 내에서 실행되는 쿼리이다.
SUBQUERY의 결과를 활용해서 복잡한 MAINQUERY를 작성해 한번에 여러 작업을 수행할 수 있다.
*/

-- 서브쿼리
-- 민트 미역국 카테고리 번호 조회
SELECT 
    CATEGORY_CODE
FROM
    TBL_MENU
WHERE
    MENU_NAME = '민트미역국';
    
-- 메인 쿼리
-- 다중열 결과 조회
SELECT 
    MENU_CODE,
    MENU_NAME,
    MENU_PRICE,
    CATEGORY_CODE,
    ORDERABLE_STATUS
FROM
    TBL_MENU;
    
-- 서브 쿼리를 활용한 메인 쿼리
-- 민트 미역국과 같은 카테고리 메뉴 조회
SELECT 
    MENU_CODE,
    MENU_NAME,
    MENU_PRICE,
    CATEGORY_CODE,
    ORDERABLE_STATUS
FROM
    TBL_MENU
WHERE
    CATEGORY_CODE = (SELECT 
            CATEGORY_CODE
        FROM
            TBL_MENU
        WHERE
            MENU_NAME = '민트 미역국');

-- 서브쿼리
SELECT 
    COUNT(*) AS 'count'
FROM
    TBL_MENU
GROUP BY CATEGORY_CODE;

-- 서브쿼리를 활용한 메인쿼리
SELECT 
    MAX(count)
FROM
    (SELECT 
        COUNT(*) AS 'count'
    FROM
        TBL_MENU
    GROUP BY CATEGORY_CODE) AS countmenu;

-- 서브쿼리
SELECT
AVG(MENU_PRICE)
FROM TBL_MENU;

-- 전체 메뉴 평균가격보다 높은 가격의 메뉴 전체 조회
SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS
FROM TBL_MENU
WHERE MENU_PRICE > (SELECT
AVG(MENU_PRICE)
FROM TBL_MENU);