package be.baropkamp.authentication;

import be.baropkamp.shared.validation.Creation;
import org.springframework.stereotype.Component;

@Component
public class LoginFactory {

    public Creation<Login> create(AdminLoginRequest request) {
        var login = new Login(request);
        return Creation.of(login, login.validate());
    }
}
