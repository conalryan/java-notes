/* delete tables if they exist already - ensuring a clean db*/
DROP TABLE IF EXISTS people_stocks CASCADE;
DROP TABLE IF EXISTS people CASCADE;
DROP TABLE IF EXISTS stocks CASCADE;
DROP TABLE IF EXISTS quotes CASCADE;

/** creates a table to store a list of people */
CREATE TABLE people
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL,
  birth_date DATETIME NOT NULL
);

/** creates a table to store a list of stocks */
CREATE TABLE stocks
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  company_name VARCHAR(256) NOT NULL,
  ticker_symbol VARCHAR(256) NOT NULL,
  exchange VARCHAR(256) NOT NULL
);

/** A list of people and their stocks */
CREATE TABLE people_stocks
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  stock_id INT NOT NULL,
  FOREIGN KEY (person_id) REFERENCES people (ID),
  FOREIGN KEY (stock_id) REFERENCES stocks (ID)
);

/** create a table to store stock quotes */
CREATE TABLE quotes(
  id INT NOT NULL AUTO_INCREMENT,
  symbol VARCHAR(4) NOT NULL,
  time DATETIME NOT NULL,
  price DECIMAL NOT NULL,
  PRIMARY KEY ( id )
);

INSERT INTO people (first_name,last_name,birth_date) VALUES ('Conal','Ryan','1980/12/25');
INSERT INTO people (first_name,last_name,birth_date) VALUES ('Lisa','Ryan','1981/09/19');
INSERT INTO people (first_name,last_name,birth_date) VALUES ('Monty','Smith','1964/04/29');

INSERT INTO stocks (company_name,ticker_symbol,exchange) VALUES ('Apple','AAPL','Nasdaq');
INSERT INTO stocks (company_name,ticker_symbol,exchange) VALUES ('Google','GOOG','Nasdaq');
INSERT INTO stocks (company_name,ticker_symbol,exchange) VALUES ('Intel','INTC','Nasdaq');

INSERT INTO people_stocks (person_id, stock_id) VALUES (1,1);
INSERT INTO people_stocks (person_id, stock_id) VALUES (1,2);
INSERT INTO people_stocks (person_id, stock_id) VALUES (1,3);
INSERT INTO people_stocks (person_id, stock_id) VALUES (2,2);
INSERT INTO people_stocks (person_id, stock_id) VALUES (3,2);
INSERT INTO people_stocks (person_id, stock_id) VALUES (3,3);

INSERT INTO quotes (symbol,time,price) VALUES ('AAPL','2015-02-28 16:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('AAPL','2005-02-02 02:02:01','202.02');
INSERT INTO quotes (symbol,time,price) VALUES ('AAPL','1995-01-01 01:01:01','101.01');

INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2015-02-27 16:00:01','558.40');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2015-02-24 13:30:01','534.88');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2013-12-03 00:00:01','527.35');

INSERT INTO quotes (symbol,time,price) VALUES ('INTC','2015-02-27 16:00:01','33.25');
INSERT INTO quotes (symbol,time,price) VALUES ('INTC','2015-02-27 10:30:01','33.52');
INSERT INTO quotes (symbol,time,price) VALUES ('INTC','2015-02-26 12:00:01','33.60');