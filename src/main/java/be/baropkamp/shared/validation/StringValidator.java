package be.baropkamp.shared.validation;

import org.apache.commons.lang3.StringUtils;

public final class StringValidator {
    private StringValidator() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void notBlank(String field, String value, Notification notification) {
        if (StringUtils.isBlank(value)) {
            notification.addError(String.format("Field '%s' should not be blank", field));
        }
    }
}