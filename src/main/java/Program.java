import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Date;

public class Program {

    private static final String FILE_NAME = "user.ser";

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("theman@hotmail.com");
        user.setRegistrationDate(new Date());

        javaNative(user);

//        jacksonXML(user);
    }

    private static void jacksonXML(User user) {
        try {
            XmlSerializer xmlSerializer = new XmlSerializer();
            xmlSerializer.serialize(user, FILE_NAME);
            print(user, true);

            User userFromFile = xmlSerializer.deserialize(FILE_NAME, new TypeReference<User>() {});
            print(userFromFile, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void javaNative(User user) {
        JavaSerializer javaSerializer = new JavaSerializer();
        try {
            javaSerializer.serialize(user, FILE_NAME);
            print(user, true);

            Object userFromFile = javaSerializer.deserialize(FILE_NAME);
            print(userFromFile, false);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void print(Object userObject, boolean written){
        System.out.println("User Object\n\t"
                .concat(userObject.toString())
                .concat("\n" + (written ? "written to" : "read from") + " file ")
                .concat(FILE_NAME)
                .concat("\n"));
    }
}
