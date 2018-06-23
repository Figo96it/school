CREATE TABLE employee (
  id_employee int(11) unsigned NOT NULL AUTO_INCREMENT,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  position varchar(45) DEFAULT NULL,
  id_class varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_employee)
) ENGINE=InnoDB DEFAULT CHARSET=utf8