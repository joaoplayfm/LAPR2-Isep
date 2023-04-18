package app.domain.model;

import app.domain.shared.Constants;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class GeneratePassword {
    private GeneratePassword() {
    }

    public static String getPassword() {
        return number()+letter()+uppeLetter();
    }

    public static String number(){
        return RandomStringUtils.randomNumeric(2);
    }

    public static String letter(){
        return RandomStringUtils.randomAlphabetic(2).toLowerCase();
    }

    public static String uppeLetter(){
        return RandomStringUtils.randomAlphabetic(3).toUpperCase();
    }
}
