package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {


    // display all depart in the furniture depart

    List<Department>findByDepartment(String department);

    // display all depart in the health division

    List<Department>findByDivision(String division);
    List<Department>findByDivisionIs(String division);
    List<Department>findByDivisionEquals(String division);

    //Display all departments with division name ends with 'ics'
    List<Department>findByDivisionEndsWith(String pattern);

    //Display top 3 departments with division name includes 'Hea' without duplicates
    List<Department>findDistinctTop3ByDivisionContaining(String pattern);


}
