DROP TABLE IF EXISTS dish;

CREATE TABLE dish(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR (100) NOT NULL,
  description TEXT NOT NUll,
  rating INT NOT NULL,
  PRIMARY KEY (id)
);