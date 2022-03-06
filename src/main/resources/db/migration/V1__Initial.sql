CREATE TABLE employee (
     employee_uuid uuid NOT NULL,
     first_name text NULL,
     last_name text NULL,
     CONSTRAINT employee_pkey PRIMARY KEY (employee_uuid)
);