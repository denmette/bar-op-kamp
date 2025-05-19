package be.baropkamp.authentication;

import be.baropkamp.shared.validation.Creation;
import be.baropkamp.shared.validation.Notification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AdminLoginUseCaseTest {

    @Mock
    private LoginFactory loginFactory;
    @InjectMocks
    private AdminLoginUseCase useCase;

    @AfterEach
    void verifyNoMoreInteractions() {
        Mockito.verifyNoMoreInteractions(loginFactory);
    }

    @Test
    void givenValidRequest_whenLogin_returnsEmptyNotification() {
        var request = new AdminLoginRequest("test@baropkamp.be", "password");
        var login = new Login(request);

        doReturn(Creation.of(login, Notification.ok()))
                .when(loginFactory)
                .create(request);

        var notification = useCase.execute(request);

        assertThat(notification).isEqualTo(Notification.ok());

        verify(loginFactory).create(request);
    }
}