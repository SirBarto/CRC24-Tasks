package tech.iam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tech.iam.entity.pk.AuthoritiesPk;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "authorities", schema = "public", catalog = "postgres")
public class Authorities implements Serializable {

    @EmbeddedId
    private AuthoritiesPk id;

    public AuthoritiesPk getId() {
        return id;
    }

    public void setId(AuthoritiesPk id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authorities)) return false;
        Authorities that = (Authorities) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}