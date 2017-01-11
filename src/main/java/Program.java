import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Date;

public class Program {

    public static final String FILE_NAME = "user.ser";

    public static void main(String[] args){

        User user = new User();
        user.setUsername("theman@hotmail.com");
        user.setRegistrationDate(new Date());

        //javaNative(user);

        jacksonXML(user);
    }

    private static void jacksonXML(User user) {
        XmlSerializer xmlSerializer = new XmlSerializer();
        try {
            xmlSerializer.serialize(user, FILE_NAME);
            System.out.println("User Object\n\t".concat(user.toString()).concat("\nserialized to ").concat(FILE_NAME).concat("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            User userFromFile = xmlSerializer.deserialize(FILE_NAME, new TypeReference<User>() {});
            System.out.println("User Object\n\t".concat(userFromFile.toString()).concat("\nread from file ").concat(FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void javaNative(User user) {
        JavaSerializer ser = new JavaSerializer();
        try {
            ser.serialize(user, FILE_NAME);
            System.out.println("User Object\n\t".concat(user.toString()).concat("\nserialized to ").concat(FILE_NAME).concat("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Object userFromFile = ser.deserialize(FILE_NAME);
            System.out.println("User Object\n\t".concat(userFromFile.toString()).concat("\nread from file ").concat(FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
