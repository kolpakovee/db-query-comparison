package ru.kolpakovee.querydsldemoproject.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import ru.kolpakovee.querydsldemoproject.record.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeePredicateBuilder {
    private final List<SearchCriteria> params;

    public EmployeePredicateBuilder() {
        params = new ArrayList<>();
    }

    public EmployeePredicateBuilder with(
            String key, Object value, String operation) {

        params.add(new SearchCriteria(key, value, operation));
        return this;
    }

    public BooleanExpression build() {
        if (params.isEmpty()) {
            return null;
        }

        List<BooleanExpression> predicates = params.stream()
                .map(param -> {
                    EmployeePredicate predicate = new EmployeePredicate(param);
                    return predicate.getPredicate();
                }).filter(Objects::nonNull)
                .toList();

        BooleanExpression expression = Expressions.TRUE;

        for (BooleanExpression predicate : predicates) {
            expression = expression.and(predicate);
        }
        return expression;
    }
}
