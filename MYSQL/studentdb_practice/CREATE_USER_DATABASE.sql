DROP USER IF EXISTS 'teamproblem'@'%';
DROP USER IF EXISTS 'teamproblem'@'localhost';

CREATE USER 'teamproblem'@'%' IDENTIFIED BY 'teamproblem';
GRANT ALL PRIVILEGES ON studentdb.* TO 'teamproblem'@'%';

USE studentdb;
