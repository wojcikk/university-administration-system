INSERT INTO users(id, login, password, entitlements)
SELECT CAST("id" AS INT), "login", "password", "entitlements"
FROM CSVREAD('input/users.csv', 'id, login, password, entitlements', NULL);

--INSERT INTO teachers(id, email, faculty)
--SELECT CAST("id" AS INT), "email", "faculty"
--FROM CSVREAD('input/teachers.csv', 'id, email, faculty', NULL);

INSERT INTO fields_Of_Study(id, name)
SELECT CAST("id" AS INT), "name"
FROM CSVREAD('input/fieldsOfStudy.csv', 'id, name', NULL);

INSERT INTO faculties(id, name, address)
SELECT CAST("id" AS INT), "name", "address"
FROM CSVREAD('input/faculties.csv', 'id, name, address', NULL);

INSERT INTO degrees(id, name)
SELECT CAST("id" AS INT), "name"
FROM CSVREAD('input/degrees.csv', 'id, name', NULL);