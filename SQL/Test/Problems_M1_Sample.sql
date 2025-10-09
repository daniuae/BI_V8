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
---------------------------------------------------------------
CREATE TABLE departments (
  dept_id NUMBER PRIMARY KEY,
  dept_name VARCHAR2(50)
);

INSERT INTO departments VALUES (10, 'IT');
INSERT INTO departments VALUES (20, 'HR');
INSERT INTO departments VALUES (30, 'Finance');
COMMIT;


❓Problem
Find average salary per department.
  ---------------------------------------------------------------

🧩 3️⃣ Highest Paid Employee per Department
❓Problem
Show each department’s highest-paid employee.

📊 Output
EMP_NAME	SALARY	DEPT_NAME
Sita	65000	HR
Neha	70000	Finance
Raj	50000	IT
