package be.baropkamp.shared.validation;

public final class Creation<T extends Validatable> {

    private final T value;
    private final Notification notification;

    private Creation(T value, Notification notification) {
        this.value = value;
        this.notification = notification;
    }

    public static <T extends Validatable> Creation<T> of(T value, Notification notification) {
        return new Creation<>(value, notification);
    }

    public static <T extends Validatable> Creation<T> of(Notification notification) {
        return new Creation<>(null, notification);
    }

    public T getValue() {
        if (notification.hasErrors()) {
            throw new IllegalStateException("Creation has errors");
        }
        return value;
    }

    public Notification getNotification() {
        return notification;
    }
}