select distinct e.employee_id
from Employees e
left join Salaries s on e.employee_id = s.employee_id
where e.name is null or s.salary is null

union 

select distinct s.employee_id 
from Salaries s
left join Employees e on s.employee_id = e.employee_id 
where e.employee_id is null
order by employee_id;