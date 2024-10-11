package ru.kolpakovee.querydsldemoproject.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import ru.kolpakovee.querydsldemoproject.entity.Employee;
import ru.kolpakovee.querydsldemoproject.record.SearchCriteria;

@RequiredArgsConstructor
public class EmployeePredicate {

    private final SearchCriteria criteria;

    public BooleanExpression getPredicate() {
        PathBuilder<Employee> entityPath = new PathBuilder<>(Employee.class, "employee");

        if (StringUtils.isNumeric(criteria.value().toString())) {
            NumberPath<Integer> path = entityPath.getNumber(criteria.key(), Integer.class);
            int value = Integer.parseInt(criteria.value().toString());
            switch (criteria.operation()) {
                case ":":
                    return path.eq(value);
                case ">":
                    return path.goe(value);
                case "<":
                    return path.loe(value);
            }
        } else {
            StringPath path = entityPath.getString(criteria.key());
            if (criteria.operation().equalsIgnoreCase(":")) {
                return path.containsIgnoreCase(criteria.value().toString());
            }
        }
        return null;
    }
}
