package ru.kolpakovee.querydsldemoproject.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import ru.kolpakovee.querydsldemoproject.entity.BaseSearchEntity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchUtils<T extends BaseSearchEntity> {

    public BooleanExpression splitSearchQuery(Class<T> entityClass, String search) {
        PredicateBuilder<T> builder = new PredicateBuilder<>(entityClass);

        Pattern pattern = Pattern.compile("(\\w+?)([=:<>])(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");

        while (matcher.find()) {
            builder = builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        return builder.build();
    }
}
