CREATE TABLE COMPANY(
   ID INT PRIMARY KEY     NOT NULL,
   NAME           TEXT    NOT NULL,
   AGE            INT     NOT NULL,
   ADDRESS        CHAR(50),
   SALARY         REAL
); 

INSERT INTO company(id, name, age, address, salary)
    VALUES (0, 'Company 0', 0, 'Hua tuo Road', 110),
    (1, 'Company 1', 1, 'Hua tuo Road', 111),
    (2, 'Company 2', 2, 'Hua tuo Road', 112),
    (3, 'Company 3', 3, 'Hua tuo Road', 113),
    (4, 'Company 4', 4, 'Hua tuo Road', 114),
    (5, 'Company 5', 5, 'Hua tuo Road', 115),
    (6, 'Company 6', 6, 'Hua tuo Road', 116),
    (7, 'Company 7', 7, 'Hua tuo Road', 117),
    (8, 'Company 8', 8, 'Hua tuo Road', 118),
    (9, 'Company 9', 9, 'Hua tuo Road', 119),
    (10, 'Company 10', 10, 'Hua tuo Road', 120);
    
