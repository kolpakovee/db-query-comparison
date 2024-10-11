package ru.kolpakovee.querydsldemoproject.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CriteriaOperation {

    EQUALS("="),
    GREATER(">"),
    LESS("<"),
    CONTAINS(":");

    private final String operationChar;

    public static CriteriaOperation getCriteriaOperation(String operationChar) {
        return switch (operationChar) {
            case "=" -> EQUALS;
            case ">" -> GREATER;
            case "<" -> LESS;
            case ":" -> CONTAINS;
            default -> throw new RuntimeException();
        };
    }
}
