CREATE TABLE IF NOT EXISTS parent
(
  id           INT AUTO_INCREMENT PRIMARY KEY,
  first_name   VARCHAR(20),
  surname      VARCHAR(20) NOT NULL,
  student_id   INT         NOT NULL,
  tell_number  VARCHAR(9),
  mobile_phone VARCHAR(9),
  mail         VARCHAR(30)
)
