import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> role = getCustomerRole("sharif");
        role.ifPresent(r -> System.out.println("Found " + r));

        Optional<String> role1 = getCustomerRole("john");

        String roleName = role1.orElse("Guest");

        System.out.println("roleName " + roleName);

    }

    public static Optional<String> getCustomerRole(String name) {
        if (name.equals("sharif")) {
            return Optional.of("Admin");
        } else if (name.equals("john")) {
            return Optional.of("User");
        } else {
            return Optional.empty();
        }
    }
}
