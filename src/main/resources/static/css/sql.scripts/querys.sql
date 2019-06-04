--Query 1

SELECT  school_admin.teacher.id,
	school_admin.teacher.name,
	school_admin.teacher.birth, 
	school_admin.teacher.active,
        school_admin.school.name as school,
	school_admin.course.name as course
FROM school_admin.teacher 
JOIN school_admin.school ON school_admin.teacher.school_id =school_admin.school.id
JOIN school_admin.course ON school_admin.teacher.course_id =school_admin.course.id
where school_id=3 order by school_admin.teacher.name asc;

--Query 2

select school_admin.course.name as course,
       school_admin.grade.name as grade,
       school_admin.student.name as student,
       school_admin.school.name as school
from school_admin.inscription
join school_admin.student on school_admin.inscription.student_id=school_admin.student.id
join school_admin.grade on school_admin.inscription.grade_id=school_admin.grade.id
join school_admin.course on school_admin.inscription.course_id=school_admin.course.id
join school_admin.school on school_admin.student.school_id=school_admin.school.id
where grade_id=4 order by school_admin.inscription.course_id desc;

--Query 3

select school_admin.course.name as course,
       school_admin.grade.name as grade,
       school_admin.student.name as student,
       school_admin.school.name as school
from school_admin.inscription
join school_admin.student on school_admin.inscription.student_id=school_admin.student.id
join school_admin.grade on school_admin.inscription.grade_id=school_admin.grade.id
join school_admin.course on school_admin.inscription.course_id=school_admin.course.id
join school_admin.school on school_admin.student.school_id=school_admin.school.id
where grade_id=(select MIN(grade_id) from school_admin.inscription);





