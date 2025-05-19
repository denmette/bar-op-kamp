package be.baropkamp.authentication.infrastructure;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenPincodeAuthenticationProvider implements AuthenticationProvider {

    private final TokenService tokenService; // your own service to validate token & pincode

    public TokenPincodeAuthenticationProvider(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String) authentication.getPrincipal();
        String pincode = (String) authentication.getCredentials();

        UserDetails user = tokenService.validateTokenAndPincode(token, pincode);
        if (user == null) {
            throw new BadCredentialsException("Invalid token or pincode");
        }

        return new TokenPincodeAuthenticationToken(user, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenPincodeAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
