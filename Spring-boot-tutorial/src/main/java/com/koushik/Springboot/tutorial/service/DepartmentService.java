package com.koushik.Springboot.tutorial.service;

import com.koushik.Springboot.tutorial.entity.Department;
import com.koushik.Springboot.tutorial.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getAllDepartments();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

    public Department getDepartmentByName(String departmentName);
}
