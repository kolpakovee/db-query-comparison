package ru.kolpakovee.querydsldemoproject.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import ru.kolpakovee.querydsldemoproject.record.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PredicateBuilder<T> {
    private final List<SearchCriteria> params;
    private final Class<T> entityClass;

    public PredicateBuilder(Class<T> entityClass) {
        this.params = new ArrayList<>();
        this.entityClass = entityClass;
    }

    public PredicateBuilder<T> with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, value, operation));
        return this;
    }

    public BooleanExpression build() {
        if (params.isEmpty()) {
            return null;
        }

        List<BooleanExpression> predicates = params.stream()
                .map(param -> {
                    Predicate<T> predicate = new Predicate<>(param, entityClass);
                    return predicate.getPredicate();
                })
                .filter(Objects::nonNull)
                .toList();

        BooleanExpression expression = Expressions.TRUE;

        for (BooleanExpression predicate : predicates) {
            expression = expression.and(predicate);
        }
        return expression;
    }
}

