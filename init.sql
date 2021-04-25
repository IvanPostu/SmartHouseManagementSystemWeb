DROP DATABASE IF EXISTS smarthouse_db;
CREATE DATABASE smarthouse_db;


-- DROP USER IF EXISTS app_user;
-- CREATE USER 'app_user'@'%' IDENTIFIED WITH mysql_native_password BY 'qwerty';
GRANT USAGE ON *.* TO 'app_user'@'%';
GRANT ALL PRIVILEGES ON smarthouse_db . * TO 'app_user'@'%';
FLUSH PRIVILEGES;