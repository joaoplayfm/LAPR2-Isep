package app.domain.model;

import app.domain.shared.Constants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class that represents the email that should be sent to the user when he is registered.
 * It will not be implemented any external API
 */
public class Email {
    private Email() {
    }

    /**
     * writes the user's email and the password in a file defined in the constants class
     * @param name name of the user
     * @param email email of the user
     * @param password password of the user
     */
    public static void sendPasswordNotification(String name, String email, String password) {
        File passFile = new File(Constants.FILE);
        try (FileWriter writer = new FileWriter(passFile)) {
            writer.write("MR/MS " + name + " you were registered with the email " + email + " and your password is " + password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
