package be.baropkamp.authentication;

import be.baropkamp.shared.validation.Notification;
import be.baropkamp.shared.validation.StringValidator;
import be.baropkamp.shared.validation.Validatable;

public class Login implements Validatable {

    private final String email;
    private final String password;

    Login(AdminLoginRequest adminLoginRequest) {
        this.email = adminLoginRequest.email();
        this.password = adminLoginRequest.password();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public Notification validate() {
        var notification = new Notification();

        StringValidator.notBlank("email", email, notification);
        StringValidator.notBlank("password", password, notification);

        return notification;
    }
}
