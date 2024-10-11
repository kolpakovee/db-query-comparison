package ru.kolpakovee.querydsldemoproject.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import ru.kolpakovee.querydsldemoproject.enums.CriteriaOperation;
import ru.kolpakovee.querydsldemoproject.record.SearchCriteria;

@RequiredArgsConstructor
public class Predicate<T> {

    private final SearchCriteria criteria;
    private final Class<T> entityClass;

    public BooleanExpression getPredicate() {
        PathBuilder<T> entityPath = new PathBuilder<>(entityClass, entityClass.getSimpleName().toLowerCase());

        if (StringUtils.isNumeric(criteria.value().toString())) {
            NumberPath<Integer> path = entityPath.getNumber(criteria.key(), Integer.class);
            int value = Integer.parseInt(criteria.value().toString());
            CriteriaOperation operation = CriteriaOperation.getCriteriaOperation(criteria.operation());
            switch (operation) {
                case CriteriaOperation.EQUALS:
                    return path.eq(value);
                case CriteriaOperation.GREATER:
                    return path.goe(value);
                case CriteriaOperation.LESS:
                    return path.loe(value);
            }
        } else {
            StringPath path = entityPath.getString(criteria.key());
            if (criteria.operation().equalsIgnoreCase(CriteriaOperation.CONTAINS.getOperationChar())) {
                return path.containsIgnoreCase(criteria.value().toString());
            }
        }
        return null;
    }
}

