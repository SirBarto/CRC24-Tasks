package tech.iam.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Objects;

public class UsersDto {

    @Schema(name = "User name", example = "ab12cd", required = true)
    private final String username;
    @Schema(name = "User roles", example = "[admin, user, ...]", required = true)
    private final List<String> roles;
    @Schema(name = "User related pcodes", example = "[P00001, P00002, ...]", required = true)
    private final List<String> pCodes;

    public UsersDto(String username, List<String> roles, List<String> pcodes) {
        this.username = username;
        this.roles = roles;
        this.pCodes =pcodes;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public List<String> getpCodes() {
        return pCodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersDto)) return false;
        UsersDto usersDto = (UsersDto) o;
        return Objects.equals(username, usersDto.username) && Objects.equals(roles, usersDto.roles) && Objects.equals(pCodes, usersDto.pCodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, roles, pCodes);
    }
}
