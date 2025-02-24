import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class UserService {
    private String role;

    UserService(String role) {
        this.role = role;
    }

    @RoleAllowed("ADMIN")
    void deleteUser() {
        System.out.println("User deleted!");
    }

    String getRole() {
        return role;
    }
}

public class RoleBasedAccessControlExample {
    public static void main(String[] args) throws Exception {
        UserService adminUser = new UserService("ADMIN");
        UserService nonAdminUser = new UserService("USER");

        executeMethodIfAllowed(adminUser, "deleteUser");
        executeMethodIfAllowed(nonAdminUser, "deleteUser");
    }

    static void executeMethodIfAllowed(UserService userService, String methodName) throws Exception {
        Method method = UserService.class.getMethod(methodName);
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            String allowedRole = roleAllowed.value();
            if (userService.getRole().equals(allowedRole)) {
                method.invoke(userService);
            } else {
                System.out.println("Access Denied!");
            }
        } else {
            method.invoke(userService);
        }
    }
}
