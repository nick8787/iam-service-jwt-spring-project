package spring.security.jwt.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@AllArgsConstructor
public enum IamServiceUserRole {
    USER("USER"),
    ADMIN("ADMIN"),
    SUPER_ADMIN("SUPER_ADMIN");

    private final String role;

    public static IamServiceUserRole fromName(String name) {
        for (IamServiceUserRole role : values()) {
            if (role.getRole().equalsIgnoreCase(name)) {
                return role;
            }
        }
        log.error("Invalid role name: {}", name);
        throw new IllegalArgumentException("Invalid role name: " + name);
    }

    public static boolean isAdminRole(String role) {
        return ADMIN.getRole().equals(role) || SUPER_ADMIN.getRole().equals(role);
    }
}
