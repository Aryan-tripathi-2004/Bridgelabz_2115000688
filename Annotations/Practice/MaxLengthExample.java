import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    private void validateMaxLength(String input) {
        try {
            Field field = User.class.getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (input.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    String getUsername() {
        return username;
    }
}

public class MaxLengthExample {
    public static void main(String[] args) {
        try {
            User user1 = new User("Bhoovan");
            System.out.println("Valid Username: " + user1.getUsername());

            User user2 = new User("VeryLongUsername");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
