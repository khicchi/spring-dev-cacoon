CREATE OR REPLACE  PROCEDURE  update_department(emp_id int)
    language plpgsql
as
$$
declare
begin
    update employees set department = 'Toys' where employee_id=emp_id;
    commit ;
end
$$;

call update_department(1);

select * from employees where employee_id=1;





--test
CREATE OR REPLACE  PROCEDURE  transfer(
    sender int,
    receiver int,
    amount dec)
    language plpgsql
as
$$
declare
begin

    update employees
    set salary = salary - amount
    where employee_id=sender;

    update employees
    set salary = salary + amount
    where employee_id=receiver;

    commit;

end
$$;

call transfer(1,2,44000);

select * from employees order by employee_id;

