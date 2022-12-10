INSERT INTO users(id, email, password, entitlements)
SELECT CAST("id" AS INT), "email", "password", "entitlements"
FROM CSVREAD('input/users.csv', 'id, email, password, entitlements', NULL);


INSERT INTO fields_Of_Study(id, name)
SELECT CAST("id" AS INT), "name"
FROM CSVREAD('input/fieldsOfStudy.csv', 'id, name', NULL);

INSERT INTO faculties(id, name, address)
SELECT CAST("id" AS INT), "name", "address"
FROM CSVREAD('input/faculties.csv', 'id, name, address', NULL);

INSERT INTO degrees(id, name)
SELECT CAST("id" AS INT), "name"
FROM CSVREAD('input/degrees.csv', 'id, name', NULL);

INSERT INTO teachers(id, name, surname, gender, age, email, faculty_id)
SELECT CAST("id" AS INT), "name", "surname", "gender", CAST("age" AS INT), "email", CAST("faculty_id" AS INT)
FROM CSVREAD('input/teachers.csv', 'id, name, surname, gender, age, email, faculty_id', NULL);


INSERT INTO majors(id, field_Of_Study_id, degree_id, faculty_id)
SELECT CAST("id" AS INT), CAST("field_Of_Study_id" AS INT), CAST("degree_id" AS INT), CAST("faculty_id" AS INT)
FROM CSVREAD('input/majors.csv', 'id, field_Of_Study_id, degree_id, faculty_id', NULL);

INSERT INTO students(id, name, surname, gender, age, email, major_id)
SELECT CAST("id" AS INT), "name", "surname", "gender", CAST("age" AS INT), "email", CAST("major_id" AS INT)
FROM CSVREAD('input/students.csv', 'id, name, surname, gender, age, email, major_id', NULL);


select majors.id, fields_of_study.name, degrees.name, faculties.name, faculties.address
from majors
join fields_of_study on majors.field_of_study_id=fields_of_study.id
join degrees on majors.degree_id=degrees.id
join faculties on majors.faculty_id=faculties.id;

select * from fields_of_study;
select * from majors;