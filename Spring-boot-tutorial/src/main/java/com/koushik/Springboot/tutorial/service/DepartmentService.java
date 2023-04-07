package com.koushik.Springboot.tutorial.service;

import com.koushik.Springboot.tutorial.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getAllDepartments();

    public Department getDepartmentById(Long departmentId);

    public void deleteDepartmentById(Long departmentId);
}
