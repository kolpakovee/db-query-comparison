package ru.kolpakovee.querydsldemoproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kolpakovee.querydsldemoproject.entity.Employee;
import ru.kolpakovee.querydsldemoproject.service.SearchService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
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
