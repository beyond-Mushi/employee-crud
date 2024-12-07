package com.example.employeecrudmvc.service;

import com.example.employeecrudmvc.dao.EmployeeDao;
import com.example.employeecrudmvc.entity.Employee;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public Employee findEmployeeById(int id){
        return employeeDao.findById(id)
                .orElseThrow(EntityExistsException::new);
    }
    public List<Employee> listAllEmployee(){
        return employeeDao.findAll();
    }
    public void createEmployee(Employee employee){
        employeeDao.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeDao.deleteById(id);
    }

    @Transactional
    public void updateEmployeeV2(Employee employee,int id) {
        Employee oldEmployee=findEmployeeById(id);
        oldEmployee.setId(id);
        oldEmployee.setEmail(employee.getEmail());
        oldEmployee.setDateOfBirth(employee.getDateOfBirth());
        oldEmployee.setFirstName(employee.getFirstName());
        oldEmployee.setLastName(employee.getLastName());
    }

    public void updateEmployee(Employee employee,int id) {
        employee.setId(id);
        employeeDao.save(employee);
    }
}
