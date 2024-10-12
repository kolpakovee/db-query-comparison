package ru.kolpakovee.querydsldemoproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kolpakovee.querydsldemoproject.entity.Employee;
import ru.kolpakovee.querydsldemoproject.service.SearchService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeesController {

    private final SearchService service;

    @GetMapping("/get")
    public Iterable<Employee> getEmployees(
            @RequestParam(value = "employeeSearch", required = false) String employeeSearch,
            @RequestParam(value = "companySearch", required = false) String companySearch,
            @RequestParam(value = "positionSearch", required = false) String positionSearch,
            @RequestParam(value = "salarySearch", required = false) String salarySearch) {

        return service.getEmployees(employeeSearch, companySearch, positionSearch, salarySearch);
    }
}
