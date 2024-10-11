package ru.kolpakovee.querydsldemoproject.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kolpakovee.querydsldemoproject.entity.Company;
import ru.kolpakovee.querydsldemoproject.entity.Employee;
import ru.kolpakovee.querydsldemoproject.entity.Position;
import ru.kolpakovee.querydsldemoproject.entity.Salary;
import ru.kolpakovee.querydsldemoproject.repository.EmployeeRepository;
import ru.kolpakovee.querydsldemoproject.search.SearchUtils;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final EmployeeRepository repository;

    public Iterable<Employee> getEmployees(String employeeSearch, String companySearch,
                                           String positionSearch, String salarySearch) {

        SearchUtils<Employee> employeeSearchUtils = new SearchUtils<>();
        SearchUtils<Company> companySearchUtils = new SearchUtils<>();
        SearchUtils<Position> positionSearchUtils = new SearchUtils<>();
        SearchUtils<Salary> salarySearchUtils = new SearchUtils<>();

        BooleanExpression expression = employeeSearchUtils.splitSearchQuery(Employee.class, employeeSearch)
                .and(companySearchUtils.splitSearchQuery(Company.class, companySearch))
                .and(positionSearchUtils.splitSearchQuery(Position.class, positionSearch))
                .and(salarySearchUtils.splitSearchQuery(Salary.class, salarySearch));

        System.out.println(expression);

        return repository.findAll(expression);
    }
}
