package ru.kolpakovee.querydsldemoproject.record;

public record SearchCriteria(
        String key,
        Object value,
        String operation) {
}
