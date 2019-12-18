package com.epam.finalkafka.dto;

import java.util.regex.Pattern;

/**
 * Class contains constants for string validation with regexp.
 */
public class ValidationExpressions {
    public static final String EMAIL_REGEX =
            "^(?:[a-zA-Z0-9_'^&\\+-])+(?:\\.(?:[a-zA-Z0-9_'^&\\+-])+)"
                    + "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)"
                    + "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)"
                    + "+(?:[a-zA-Z]){2,}\\.?)$";
    public static final String USER_FIRST_NAME_REGEX = "^[\\w+-]{2,20}$";
    public static final String PHONE_NUMBER_REGEX =
            "/^(\\+\\d)*\\s*(\\(\\d{3}\\)\\s*)*\\d{3}"
                    + "(-{0,1}|\\s{0,1})\\d{2}(-{0,1}|\\s{0,1})\\d{2}$/";
    public static final String USER_LAST_NAME_REGEX = "^[\\w+-]{2,35}$";
    //TODO: CHECK LEVEL REGEX
    public static final String LEVEL_NAME_REGEX = "\\d+";
    public static final String OBJECT_ID_REGEX = "[a-fA-F\\d]{24}";
    public static final Pattern OBJECT_ID_PATTERN = Pattern.compile(OBJECT_ID_REGEX);

    /**
     * Creation of instances restricted.
     */
    private ValidationExpressions() {
        throw new IllegalStateException("This class is utility class");
    }
}
