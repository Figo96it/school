CREATE SCHEMA IF NOT EXISTS SZKOLA;

CREATE TABLE IF NOT EXISTS school (
  id      INT          NOT NULL AUTO_INCREMENT,
  name    VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS class (
  id_class      INT         NOT NULL AUTO_INCREMENT,
  id_school     INT         NOT NULL,
  class_name    VARCHAR(45) NOT NULL,
  class_year    YEAR,
  id_form_tutor INT         NOT NULL,
  PRIMARY KEY (id_class)
);

ALTER TABLE class
  ADD FOREIGN KEY (id_school) REFERENCES school (id)
ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS employee (
  id_employee INT NOT NULL AUTO_INCREMENT,
  first_name  VARCHAR(45)  DEFAULT NULL,
  last_name   VARCHAR(45)  DEFAULT NULL,
  position    VARCHAR(45)  DEFAULT NULL,
  id_class    INT  DEFAULT NULL,
  PRIMARY KEY (id_employee)
);

ALTER TABLE class
  ADD FOREIGN KEY (form_tutor_id) REFERENCES employee (id_employee)
ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS plan (
  id       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  class_id INT NOT NULL
);

ALTER TABLE plan
  ADD FOREIGN KEY (class_id) REFERENCES class (id_class)
ON DELETE NO ACTION;

CREATE TABLE school_subject (
  id_subject   INT         NOT NULL AUTO_INCREMENT,
  subject_name VARCHAR(45) NOT NULL,
  id_plan      INT         NOT NULL,
  PRIMARY KEY (id_subject)
);

ALTER TABLE school_subject
  ADD FOREIGN KEY (id_plan) REFERENCES plan (id)
ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS grade (
  id               INT PRIMARY KEY AUTO_INCREMENT,
  subject_id       INT NOT NULL,
  student_grade_id INT NOT NULL,
  grade            INT(1)
);


ALTER TABLE grade
  ADD FOREIGN KEY (subject_id) REFERENCES school_subject (id_subject)
ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS student_grade (
  id         INT PRIMARY KEY AUTO_INCREMENT,
  id_student INT             NOT NULL,
  id_grade   INT             NOT NULL
);

alter table grade add foreign key (student_grade_id) references student_grade(id)
  on delete no action;

create table student (
  id int auto_increment,
  class_id int not null,
  first_name varchar(20) not null,
  last_name varchar(20) not null,
  primary key (id)
);

alter table student_grade add foreign key (id_student) references student(id)
  on delete no action;

CREATE TABLE IF NOT EXISTS parent(
  id           INT AUTO_INCREMENT PRIMARY KEY,
  first_name   VARCHAR(20),
  surname      VARCHAR(20) NOT NULL,
  student_id   INT         NOT NULL,
  tell_number  VARCHAR(9),
  mobile_phone VARCHAR(9),
  mail         VARCHAR(30)
);

alter table parent add foreign key (student_id) references student(id)
  on delete no action;

alter table student add foreign key (class_id) references class(id_class)
  on delete no action;

