package be.baropkamp.authentication.domain;

import com.github.f4b6a3.ulid.Ulid;
import org.jmolecules.ddd.types.Identifier;

public record UserId(Ulid value) implements Identifier {
}
