/* JOIN */
/* 
JOIN은 두 개 이상의 테이블을 관련 있는 컬럼을 통해 결합하는데 사용된다. 
두 개 이상 테이블은 반드시 연관 있는 컬럼이 존재하여야 하며 이를 통해 JOIN된 두테이블의 컬럼을 모두 활용할 수 있다.
*/

/* ALIAS */
/* SQL 문의 컬럼 또는 테이블에 별칭을 달아줄 수 있다. 이러한 별칭은 ALIAS 라고 한다.*/
SELECT 
    MENU_CODE AS 'code', MENU_NAME NAME, MENU_PRICE 'price'
FROM
    TBL_MENU
ORDER BY MENU_PRICE;

-- 테이블 별칭
-- 테이블에 별칭을 작성할 수 있으며 어떤 테이블 소속인지를 쉽게 알 수 있게 해준다.
-- 테이블 별칭은 AS를 써도 되고 생략도 가능하다.
SELECT 
    CATEGORY_CODE, MENU_NAME
FROM
    TBL_MENU A
ORDER BY A.CATEGORY_CODE , A.MENU_NAME;

-- INNER JOIN
-- 두 테이블의 교집합을 반환하는 SQL JOIN
-- INNER JOIN INNER 키워드는 생략이 가능하다.
-- ON을 활용한 JOIN : 컬럼명이 같거나 다를 경우 ON으로 서로 연관있는 컬럼에 대한 조건을 작성하여 JOIN
SELECT 
    A.MENU_NAME, B.CATEGORY_NAME
FROM
    TBL_MENU A
        INNER JOIN
    TBL_CATEGORY B ON A.CATEGORY_CODE = B.CATEGORY_CODE;

SELECT 
    *
FROM
    TBL_MENU;
    
SELECT 
    *
FROM
    TBL_CATEGORY;
-- USING 
-- 컬럼명이 같으 경우 USING으로 서로 연관있는 컬럼에 대한 조건을 작성하여 JOIN
SELECT 
    A.MENU_NAME, B.CATEGORY_NAME
FROM
    TBL_MENU A
        INNER JOIN
    TBL_CATEGORY B USING (CATEGORY_CODE);


-- LEFT JOIN
-- 첫 번째(왼쪽) 테이블의 모든 레코드와 두 번째(오른쪽)테이블에서 레코드를 반환하는 JOIN
SELECT 
    A.CATEGORY_CODE, B.MENU_NAME
FROM
    TBL_CATEGORY A
        LEFT JOIN
    TBL_MENU B ON A.CATEGORY_CODE = B.CATEGORY_CODE;
    
SELECT
	CATEGORY_CODE 
    FROM TBL_CATEGORY;

SELECT
	MENU_NAME 
    FROM TBL_MENU;

-- RIGHT JOIN
-- 두 번째(오른쪽) 테이블의 모든 레코드와 첫 번째(오른쪽)테이블에서 레코드를 반환하는 JOIN
SELECT 
    A.CATEGORY_CODE, B.MENU_NAME
FROM
    TBL_CATEGORY A
        RIGHT JOIN
    TBL_MENU B ON A.CATEGORY_CODE = B.CATEGORY_CODE;

-- CROSS JOIN
-- 두 테이블의 모든 가능한 조합을 반환하는 JOIN
SELECT 
    A.CATEGORY_NAME, B.MENU_NAME
FROM
    TBL_CATEGORY A
        CROSS JOIN
    TBL_MENU B;
    
-- SELF JOIN
-- 같은 테이블 내에서 행과 행 사이의 관계를 찾기 위해 사용되는 SQL JOIN 유형
-- 카테고리별 대분류 확인을 위한 SELF JOIN 조회
SELECT 
    A.CATEGORY_NAME, B.CATEGORY_NAME
FROM
    TBL_CATEGORY A
        JOIN
    TBL_CATEGORY B ON A.REF_CATEGORY_CODE = B.CATEGORY_CODE
WHERE
    A.REF_CATEGORY_CODE IS NOT NULL;

SELECT 
    *
FROM
    TBL_CATEGORY;
