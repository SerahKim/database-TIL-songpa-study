-- 1. 각 학생이 수강한 과목 수를 구하시오. (수강 안 한 학생은 제외)

SELECT 
    S.STUDENT_NAME, COUNT(C.COURSE_ID)
FROM
    STUDENT S
LEFT JOIN
    COURSE C USING (STUDENT_ID)
WHERE
    C.COURSE_NAME IS NOT NULL
GROUP BY S.STUDENT_NAME;

-- 2.수강한 과목이 2개 이상인 학생의 이름과 과목 수를 구하시오.
SELECT 
    S.STUDENT_NAME, COUNT(C.COURSE_ID) 과목수
FROM
    STUDENT S
LEFT JOIN
    COURSE C USING (STUDENT_ID)
GROUP BY S.STUDENT_NAME
HAVING COUNT(C.COURSE_ID) >= 2;
	
-- 3. 가장 수강 과목 수가 많은 학생의 이름을 구하시오.
SELECT 
    S.STUDENT_NAME
FROM
    STUDENT S
LEFT JOIN
    COURSE C USING (STUDENT_ID);

SELECT 
    S.STUDENT_NAME
FROM
    STUDENT S
LEFT JOIN
    COURSE C USING (STUDENT_ID)
GROUP BY S.STUDENT_NAME
ORDER BY  COUNT(C.COURSE_ID) DESC
LIMIT 1;

-- 4. 컴퓨터 공학 전공 학생들이 수강한 전공 과목명만 중복 없이 조회하시오.
SELECT 
	C.COURSE_NAME
FROM
    STUDENT S
LEFT JOIN
     COURSE C USING (STUDENT_ID)
WHERE
   S.MAJOR = '컴퓨터공학';
