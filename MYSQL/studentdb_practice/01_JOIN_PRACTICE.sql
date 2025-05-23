-- 1.수강한 학생들만 표시
SELECT DISTINCT
    *
FROM
    STUDENT 
JOIN
    COURSE USING (STUDENT_ID);

-- 2. 모든 학생이 나오고, 과목이 없는 경우엔 NULL
SELECT
	S.STUDENT_NAME, C.COURSE_NAME
FROM 
	STUDENT S
LEFT JOIN
	COURSE C USING (STUDENT_ID);
    
-- 3. 모든 수강 과목이 나오고, 수강자 정보가 없으면 NULL (현재는 항상 있음)
SELECT
	S.STUDENT_NAME, C.COURSE_NAME
FROM
	STUDENT S
RIGHT JOIN
	COURSE C USING (STUDENT_ID);
    
-- 4. 같은 전공을 가진 다른 학생 찾기
SELECT 
	A.STUDENT_NAME, B.STUDENT_NAME
FROM
	STUDENT A
JOIN STUDENT B USING (MAJOR)
WHERE A.STUDENT_NAME != B.STUDENT_NAME;

-- 5. 모든 경우의 수
SELECT
	S.STUDENT_NAME, C.COURSE_NAME
FROM 
	STUDENT S 
CROSS JOIN
	COURSE C;
