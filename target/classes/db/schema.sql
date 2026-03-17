CREATE TABLE IF NOT EXISTS measurements (
  id INT AUTO_INCREMENT PRIMARY KEY,
  operation VARCHAR(50),
  operand1 VARCHAR(255),
  operand2 VARCHAR(255),
  result VARCHAR(255)
);