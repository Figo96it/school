CREATE SCHEMA IF NOT EXISTS SZKOLA;

CREATE TABLE IF NOT EXISTS school (
  id      INT          NOT NULL AUTO_INCREMENT,
  name    VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS class (
  id            INT         NOT NULL AUTO_INCREMENT,
  id_school     INT         NOT NULL,
  class_name    VARCHAR(45) NOT NULL,
  class_year    YEAR,
  id_form_tutor INT         NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE class
  ADD FOREIGN KEY (id_school) REFERENCES school (id)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS employee (
  id         INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45)  DEFAULT NULL,
  last_name  VARCHAR(45)  DEFAULT NULL,
  position   VARCHAR(45)  DEFAULT NULL,
  id_class   INT          DEFAULT NULL,

  PRIMARY KEY (id)
);

ALTER TABLE class
  ADD FOREIGN KEY (id_form_tutor) REFERENCES employee (id)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS plan (
  id       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  id_class INT NOT NULL
);

ALTER TABLE plan
  ADD FOREIGN KEY (id_class) REFERENCES class (id)
  ON DELETE NO ACTION;

CREATE TABLE school_subject (
  id           INT         NOT NULL AUTO_INCREMENT,
  subject_name VARCHAR(45) NOT NULL,
  id_plan      INT         NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE school_subject
  ADD FOREIGN KEY (id_plan) REFERENCES plan (id)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS grade (
  id               INT PRIMARY KEY AUTO_INCREMENT,
  id_subject       INT NOT NULL,
  id_student_grade INT NOT NULL,
  grade            INT(1)
);


ALTER TABLE grade
  ADD FOREIGN KEY (id_subject) REFERENCES school_subject (id)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS student_grade (
  id         INT PRIMARY KEY AUTO_INCREMENT,
  id_student INT NOT NULL,
  id_grade   INT NOT NULL,
  grade      INT
);

ALTER TABLE grade
  ADD FOREIGN KEY (id_student_grade) REFERENCES student_grade (id)
  ON DELETE NO ACTION;

CREATE TABLE student (
  id         INT AUTO_INCREMENT,
  id_class   INT         NOT NULL,
  first_name VARCHAR(20) NOT NULL,
  last_name  VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE student_grade
  ADD FOREIGN KEY (id_student) REFERENCES student (id)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS parent (
  id           INT AUTO_INCREMENT PRIMARY KEY,
  first_name   VARCHAR(20),
  surname      VARCHAR(20) NOT NULL,
  id_student   INT         NOT NULL,
  tell_number  VARCHAR(9),
  mobile_phone VARCHAR(9),
  mail         VARCHAR(30)
);

ALTER TABLE parent
  ADD FOREIGN KEY (id_student) REFERENCES student (id)
  ON DELETE NO ACTION;

ALTER TABLE student
  ADD FOREIGN KEY (id_class) REFERENCES class (id)
  ON DELETE NO ACTION;

