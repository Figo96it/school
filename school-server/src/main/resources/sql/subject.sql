CREATE TABLE school.subject (
  id_subject INT NOT NULL AUTO_INCREMENT,
  subject_name VARCHAR(45) NOT NULL,
  id_plan INT NOT NULL,
  PRIMARY KEY (id_subject),
  UNIQUE INDEX id_subject_UNIQUE (id_subject ASC));