package tech.iam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public", catalog = "postgres")
public class Users implements Serializable {
    @Id
    @Size(max = 50)
    @Column(name = "username", nullable = false, length = 50)
    private String username;
//
//    @Size(max = 500)
//    @NotNull
//    @Column(name = "password", nullable = false, length = 500)
//    private String password;

    @NotNull
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = false;

//    @OneToMany(mappedBy = "username")
//    private Set<Authority> authorities = new LinkedHashSet<>();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users that = (Users) o;

        if (enabled != that.enabled) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }
}