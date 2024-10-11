package ru.kolpakovee.querydsldemoproject.controller;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kolpakovee.querydsldemoproject.entity.Employee;
import ru.kolpakovee.querydsldemoproject.repository.EmployeeRepository;
import ru.kolpakovee.querydsldemoproject.search.EmployeePredicateBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeeRepository repository;

    @GetMapping("/get")
    public Iterable<Employee> getEmployees() {
        EmployeePredicateBuilder builder = new EmployeePredicateBuilder()
                .with("name", "Egor", ":")
                .with("age", 25, ">");

        BooleanExpression expression = builder.build();
        System.out.println(expression);

        return repository.findAll(expression);
    }

}
