/* SET OPERATORS */
/*
SET 연산자는 두 개 이상의 SELECT문의 결과 집합을 결합하는데 사용한다.
SET 연산자를 통해 결합하는 결과 집합의 칼럼이 동일해야 한다.
*/

/* UNION */
-- 두 개 이상의 SELECT문의 결과를 결합하여 중복된 레코드를 제거한 후 반환하는 연산자
-- AND의 개념이 아님
-- 중복된 레코드는 제거하고 추출
SELECT 
    MENU_CODE,
    MENU_NAME,
    MENU_PRICE,
    CATEGORY_CODE,
    ORDERABLE_STATUS
FROM
    TBL_MENU
WHERE
    CATEGORY_CODE = 10 
UNION SELECT 
    MENU_CODE,
    MENU_NAME,
    MENU_PRICE,
    CATEGORY_CODE,
    ORDERABLE_STATUS
FROM
    TBL_MENU
WHERE
    MENU_PRICE < 9000;
    
/* UNION ALL */
-- 두 개 이상의 SELECT 문의 결과를 결합하여 중복된 레코드를 제거하지 않고 모두 반환
SELECT 
    MENU_CODE,
    MENU_NAME,
    MENU_PRICE,
    CATEGORY_CODE,
    ORDERABLE_STATUS
FROM
    TBL_MENU
WHERE
    CATEGORY_CODE = 10 
UNION ALL SELECT 
    MENU_CODE,
    MENU_NAME,
    MENU_PRICE,
    CATEGORY_CODE,
    ORDERABLE_STATUS
FROM
    TBL_MENU
WHERE
    MENU_PRICE < 9000;

/* INTERSECT */
-- 두 개 SELECT 문의 결과 중 공통되는 레코드만을 반환하는 연산자이다.
-- MYSQL은 INTERSECT를 제공하지 않는다.
-- 하지만 INNER JOIN 또는 IN 연산자 활용해서 구현하는 것은 가능하다.