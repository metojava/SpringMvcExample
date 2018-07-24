INSERT INTO Employee(id ,name ,contactNo ,emailId ,role) VALUES (1, 'Mamuka', '123456789','mamuka@gmail.com', 'employee');
INSERT INTO Employee(id ,name ,contactNo ,emailId ,role) VALUES (2, 'Amit',   '123422222', 'amit@yahoo.com', 'manager');
INSERT INTO Employee(id ,name ,contactNo ,emailId ,role) VALUES (3, 'Ananda', '123333339','ananda@gmail.com', 'manager');

insert into Account (accNo, accType, accOpeningDT, currBalance) values(1, 'Debit', '2018-06-20', 112.5);
insert into Account (accNo, accType, accOpeningDT, currBalance) values(2, 'Credit', '2016-11-17', 105.5);
insert into Account (accNo, accType, accOpeningDT, currBalance) values(3, 'Assets', '2018-11-20', 312.5);
insert into Account (accNo, accType, accOpeningDT, currBalance) values(4, 'Expense', '2018-12-20', 222.5);

insert into Customer (cid, accNo, cName, contactNo, birthDate, emailId) values(1, 1, 'George', '123445789', DATE '1978-06-20', 'george1978@gmail.com');
insert into Customer (cid, accNo, cName, contactNo, birthDate, emailId) values(2, 3, 'Julie',  '345675430', DATE '1988-06-20', 'Juli_1988@main.com');
insert into Customer (cid, accNo, cName, contactNo, birthDate, emailId) values(3, 2, 'Mike',   '098762343', DATE '1987-06-20', 'Mike_Realman@gmail.com');
insert into Customer (cid, accNo, cName, contactNo, birthDate, emailId) values(4, 4, 'Sumit',  '123445888', DATE '1998-06-20', 'Sumit_Supervisor@gmail.com');
