Controller:
1.Get mapping 
  url: localhost:8080/employees
  purpose: get all users
  return code 200/404

2.Get mapping
  url: localhost:8080/employees/{id}
  purpose: get user by id
  return code 200/404
  
3.Post mapping
  url: localhost:8080/employees
  purpose: create new user
  return code 201/400
  
4.Put mapping
  url: localhost:8080/employees
  purpose: update user
  return code: 204/400
  
5.Get mapping
  url: localhost:8080/employees/departments/{departmentId}
  purpose: get the list of user in the department with id
  return code: 200/404

Repository:
EmployRepositry implemented by CrudRepository
Implemented findById/findAll/save/findByIdWithDepartment/findByEmail
EmployRepositryEntityManager implemented by entityManager.

Service:
EmployeeService 
implemented findById/findAllEmployees/saveEmployee/updateEmployee/findEmployeeWithDepartmentId

