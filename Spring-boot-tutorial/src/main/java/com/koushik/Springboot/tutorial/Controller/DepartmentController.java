package com.koushik.Springboot.tutorial.Controller;

import com.koushik.Springboot.tutorial.entity.Department;
import com.koushik.Springboot.tutorial.error.DepartmentNotFoundException;
import com.koushik.Springboot.tutorial.service.DepartmentService;
import com.koushik.Springboot.tutorial.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        LOGGER.info("Inside getAllDepartment of DepartmentController");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
   public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
   }

   @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department has been deleted successfully";
   }

   @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}
