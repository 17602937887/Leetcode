# Write your MySQL query statement below
-- 先将每个部门的最高工资找出来  然后内连接一下 当员工信息满足 部门号一致而且工资等于最高工资时 输出
select
    b.name as Department , c.name as Employee , a.salary as Salary
from
    (select departmentid, max(salary) as salary
    from Employee
    group by(departmentid)) as a, department as b, Employee as c
where
    a.departmentid = b.id AND c.salary = a.salary AND c.Departmentid = a.departmentid;

select