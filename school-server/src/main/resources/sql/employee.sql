CREATE TABLE employee (
  id_employee INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name  VARCHAR(45)               DEFAULT NULL,
  last_name   VARCHAR(45)               DEFAULT NULL,
  position    VARCHAR(45)               DEFAULT NULL,
  hired_date  DATE                      DEFAULT NULL,
  id_class    VARCHAR(45)               DEFAULT NULL,
  PRIMARY KEY (id_employee)
)