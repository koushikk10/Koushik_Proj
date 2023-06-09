package com.koushik.Springboot.tutorial.service;

import com.koushik.Springboot.tutorial.entity.Department;
import com.koushik.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("IT").departmentAddress("Boston").departmentCode("Kous").departmentId(1L).build();
        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
    }
    @Test
    @DisplayName("Get data based on valid department name")
    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){
        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}