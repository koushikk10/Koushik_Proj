package com.koushik.Springboot.tutorial.repository;

import com.koushik.Springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("CSE").departmentAddress("Seattle").departmentCode("Sean").departmentId(1L).build();
        //data will be deleted when execution is completed
        entityManager.persist(department); //will persist before calling test case
    }
    @Test
    @DisplayName("Find By Id")
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "CSE");

    }
}