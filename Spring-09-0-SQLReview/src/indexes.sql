EXPLAIN ANALYZE
select *
from employees
where last_name='Roberti';

EXPLAIN ANALYZE
select *
from employees
where employee_id=10;


CREATE INDEX idx_towns_name ON employees(last_name);

DROP INDEX IF EXISTS idx_towns_name;

SELECT
    tablename,
    indexname,
    indexdef
FROM
    pg_indexes
WHERE
        schemaname = 'public'
ORDER BY
    tablename,
    indexname;

