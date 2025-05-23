-- 1. 부서코드가 노옹철 사원과 같은 소속의 직원 명단 조회하세요.
SELECT 
    *
FROM
    EMPLOYEE
WHERE
    DEPT_CODE = (
		SELECT 
            DEPT_CODE
        FROM
            EMPLOYEE
        WHERE
            EMP_NAME = '노옹철');

-- 2. 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여를 조회하세요.
SELECT 
    EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM
    EMPLOYEE
WHERE
    SALARY > (
		SELECT 
            AVG(SALARY)
        FROM
            EMPLOYEE);

-- 3. 노옹철 사원의 급여보다 많이 받는 직원의 사번, 이름, 부서코드, 직급코드, 급여를 조회하세요.
SELECT 
    EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM
    EMPLOYEE
WHERE
    SALARY > (
		SELECT 
            SALARY
        FROM
            EMPLOYEE
        WHERE
            EMP_NAME = '노옹철');

-- 4. 가장 적은 급여를 받는 직원의 사번, 이름, 부서코드, 직급코드, 급여, 입사일을 조회하세요.
SELECT 
    EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY, HIRE_DATE
FROM
    EMPLOYEE
ORDER BY SALARY
LIMIT 1;

-- *** 서브쿼리는 SELECT, FROM, WHERE, HAVING, ORDER BY절에도 사용할 수 있다.

-- 5. 부서별 최고 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회하세요.
SELECT 
    E.EMP_NAME, E.JOB_CODE, E.DEPT_CODE, E.SALARY
FROM
    EMPLOYEE E
JOIN MAXSALARY M ON E.DEPT_CODE = M.DEPT_CODE
WHERE E.SALARY = M.MAX;
   
DROP VIEW IF EXISTS MAXSALARY;
CREATE VIEW MAXSALARY AS
SELECT 
    MAX(SALARY) MAX,DEPT_CODE
FROM
    EMPLOYEE 
GROUP BY DEPT_CODE;
-- *** 여기서부터 난이도 극상

-- 6. 관리자에 해당하는 직원에 대한 정보와 관리자가 아닌 직원의 정보를 추출하여 조회하세요.
-- 사번, 이름, 부서명, 직급, '관리자' AS 구분 / '직원' AS 구분
-- HINT!! is not null, union(혹은 then, else), distinct
CREATE VIEW MANAGER AS
SELECT
	*
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL;

CREATE VIEW EMPLOYEE AS
SELECT
	*
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

SELECT 
	M.EMP_ID, M.EMP_NAME, D.DEPT_TITLE, J.JOB_NAME, M.MANAGER_ID
FROM MANAGER M
JOIN JOB J USING (JOB_CODE)
JOIN DEPARTMENT D ON M.DEPT_CODE = D.DEPT_ID
UNION
SELECT 
	E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, J.JOB_NAME, E.MANAGER_ID
FROM EMPLOYEE E
JOIN JOB J USING (JOB_CODE)
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID;

	

-- 7. 자기 직급의 평균 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여를 조회하세요.
-- 단, 급여와 급여 평균은 만원단위로 계산하세요.
-- HINT!! round(컬럼명, -5)
SELECT 
	E.EMP_ID, E.EMP_NAME, E.JOB_CODE, E.SALARY
FROM
    EMPLOYEE E
JOIN AVGJOB A ON E.JOB_CODE = E.JOB_CODE
WHERE E.SALARY = A.AVG;

DROP VIEW IF EXISTS AVGJOB;
CREATE VIEW AVGJOB AS
SELECT 
    ROUND(AVG(SALARY), - 5) 'AVG', JOB_CODE
FROM
    EMPLOYEE
GROUP BY JOB_CODE;


-- 8. 퇴사한 여직원과 같은 부서, 같은 직급에 해당하는 직원의 이름, 직급코드, 부서코드, 입사일을 조회하세요.
SELECT 
    EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM
    EMPLOYEE
WHERE
    DEPT_CODE = (
		SELECT 
            DEPT_CODE
        FROM
            EMPLOYEE
        WHERE
            ENT_YN = 'Y')
        AND JOB_CODE = (
        SELECT 
            JOB_CODE
        FROM
            EMPLOYEE
        WHERE
            ENT_YN = 'Y');


-- 9. 급여 평균 3위 안에 드는 부서의 부서 코드와 부서명, 평균급여를 조회하세요.
-- HINT!! limit

SELECT 
    *
FROM
    AVG3;

DROP VIEW IF EXISTS AVG3;
CREATE VIEW AVG3 AS
    SELECT 
        ROUND(AVG(E.SALARY), -5) 'AVGS', E.DEPT_CODE, D.DEPT_TITLE
    FROM
        EMPLOYEE E
            JOIN
        DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
    GROUP BY DEPT_CODE
    LIMIT 3;

-- 10. 부서별 급여 합계가 전체 급여의 총 합의 20%보다 많은 부서의 부서명과, 부서별 급여 합계를 조회하세요.
SELECT
	E.DEPT_CODE, D.DEPT_TITLE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID;
	