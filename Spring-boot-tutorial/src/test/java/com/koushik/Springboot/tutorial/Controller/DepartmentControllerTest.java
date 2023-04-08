package com.koushik.Springboot.tutorial.Controller;

import com.koushik.Springboot.tutorial.entity.Department;
import com.koushik.Springboot.tutorial.error.DepartmentNotFoundException;
import com.koushik.Springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService; //Mocking service layer
    private Department department; //Mocking department
    @BeforeEach
    void setUp() {
        department = Department.builder().departmentName("UMASS").departmentAddress("CT").departmentCode("Boston").departmentId(1L).build(); // use this obj in test cases down
    }

    @Test
    void saveDepartment() throws Exception { // no Id for inputDepartment
        Department inputDepartment = Department.builder().departmentName("UMASS").departmentAddress("CT").departmentCode("Boston").build(); // use this obj in test cases down
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        //call end point
        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON) //Alt+Enter static
                .content("{\n" +
                        "     \"departmentName\":\"UMASS\",\n" +
                        "    \"departmentAddress\":\"CT\",\n" +
                        "    \"departmentCode\":\"Boston\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);

        //get operation
        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status()
                .isOk()).andExpect(jsonPath("$.departmentName")
                .value(department.getDepartmentName()));
    }
}