package be.baropkamp.authentication.infrastructure;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class TokenPincodeAuthenticationToken extends AbstractAuthenticationToken {
    private final String token;
    private final String pincode;

    public TokenPincodeAuthenticationToken(String token, String pincode) {
        super(null);
        this.token = token;
        this.pincode = pincode;
        setAuthenticated(false);
    }

    // for successful authentication
    public TokenPincodeAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.token = null;
        this.pincode = null;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return pincode;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }
}
