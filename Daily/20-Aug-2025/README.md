https://www.google.com/search?q=beeline+create+hive+database+and+tables&oq=beeline+create+hive+database+and+tables&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIHCAEQIRigATIHCAIQIRifBTIHCAMQIRifBTIHCAQQIRifBTIHCAUQIRifBdIBCTE4NTkwajBqN6gCALACAA&sourceid=chrome&ie=UTF-8


CREATE TABLE employees (
    emp_id INT,
    name STRING,
    department STRING,
    salary DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;
