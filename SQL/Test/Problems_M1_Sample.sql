CREATE TABLE employees (
  emp_id int PRIMARY KEY,
  emp_name VARCHAR,
  dept_id int,
  salary int
);

INSERT INTO employees VALUES (1, 'Raj', 10, 50000);
INSERT INTO employees VALUES (2, 'Sita', 20, 65000);
INSERT INTO employees VALUES (3, 'Amit', 10, 48000);
INSERT INTO employees VALUES (4, 'Neha', 30, 70000);

❓Problem
Show employee name, old salary, and new salary after 10% hike.
