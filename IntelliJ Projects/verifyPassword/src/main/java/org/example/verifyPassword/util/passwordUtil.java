package org.example.verifyPassword.util;

public class passwordUtil {

    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG //DEBIL, MEDIA, FUERTE
    }

    public static SecurityLevel assessPassword(String password) {

        if (password.length() <8) {
            return SecurityLevel.WEAK;
        }

        if (password.matches("[a-zA-Z]+")) {
            return SecurityLevel.WEAK;
        }

        if (password.matches("[a-zA-Z0-9]+")) {   //letras de la a z min y mayus, mas de una vez y numeros
            return SecurityLevel.MEDIUM;

        }
        return SecurityLevel.STRONG;
    }
}
