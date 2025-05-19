package be.baropkamp.authentication;

import be.baropkamp.shared.validation.Notification;
import org.springframework.stereotype.Component;

@Component
public class AdminLoginUseCase {

    private final LoginFactory loginFactory;

    public AdminLoginUseCase(LoginFactory loginFactory) {
        this.loginFactory = loginFactory;
    }

    public Notification execute(AdminLoginRequest request) {
        var loginCreation = loginFactory.create(request);

        if (loginCreation.getNotification().hasErrors()) {
            return loginCreation.getNotification();
        }

        var login = loginCreation.getValue();

        // Validate hash the password
        // Check the password against the database record

        return Notification.ok();
    }
}
