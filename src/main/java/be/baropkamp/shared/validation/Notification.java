package be.baropkamp.shared.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Notification {

    private static final Notification EMPTY_NOTIFICATION = new Notification();
    private final List<String> errors = new ArrayList<>();

    public Notification() {}

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public void addError(String error) {
        this.errors.add(error);
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public String errorMessage() {
        return String.join(", ", errors);
    }

    public static Notification ok() {
        return EMPTY_NOTIFICATION;
    }

    public static Notification of(String error) {
        var notification = new Notification();
        notification.addError(error);
        return notification;
    }

    private static Notification of(List<String> errors) {
        final Notification notification = new Notification();
        errors.forEach(notification::addError);
        return notification;
    }

    @SuppressWarnings("unused") // will be reused later (hopefully)
    public static Notification merge(Notification... notifications) {
        final List<String> errors =
                Arrays.stream(notifications)
                        .map(Notification::getErrors)
                        .flatMap(List::stream)
                        .toList();
        return Notification.of(errors);
    }
}