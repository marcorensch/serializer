import java.io.Serializable;
import java.util.Date;

// Serializable interface required by Java
public class MinimalJavaUser implements Serializable {
    // Serializable interface + serialVersionUID required by JavaSerializer
    private static final long serialVersionUID = 1L;

    private final String username;
    private final Date registrationDate;

    // Alternativ könnten auch Setter-Methoden verwendet werden, sind aber für
    // den JavaSerializer nicht notwendig. Die "private" Instanzvariablen werden
    // trotzdem serialisiert, auch ohne Setter und ohne Getter.
    public MinimalJavaUser(String username, Date registrationDate) {
        this.username = username;
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
