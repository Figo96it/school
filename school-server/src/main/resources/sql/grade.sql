CREATE TABLE IF NOT EXISTS grade (
  id               INT PRIMARY KEY AUTO_INCREMENT,
  id_subject       INT NOT NULL,
  grade            INT(1),
  CREATED_DATE     DATE NOT NULL
);