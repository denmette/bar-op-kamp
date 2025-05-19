package be.baropkamp.authentication.domain;

import com.github.f4b6a3.ulid.Ulid;
import org.jmolecules.ddd.types.AggregateRoot;

public class User implements AggregateRoot<User, UserId> {

    private final UserId id;
    private final Email email;

    public User(Ulid id, Email email) {
        this.id = new UserId(id);
        this.email = email;
    }

    @Override
    public UserId getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }
}
