package com.example.employeecrudmvc.dao;

import com.example.employeecrudmvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
