--DROP TABLE users IF EXISTS;

CREATE TABLE Employee (
  id  INTEGER PRIMARY KEY,
  name VARCHAR(30),
  contactNo VARCHAR(30),
  emailId  VARCHAR(50),
  role VARCHAR(30)
);

CREATE TABLE Account (
  accNo  INTEGER PRIMARY KEY,
  accType VARCHAR(30),
  accOpeningDT DATE,
  currBalance  FLOAT(50)
);

CREATE TABLE Customer (
  cid  INTEGER PRIMARY KEY,
  accNo INTEGER ,
  cName VARCHAR(30),
  contactNo VARCHAR(30),
  birthDate DATE,
  emailId  VARCHAR(50),
  FOREIGN KEY(accNo) references Account(accNo)
);