package common;

import java.util.Random;

public class CommonFunctions {
    public static String randomString(int n) {
        Random rnd = new Random();
        String result = "";
        for(int i=0; i<n; i++) {
            result += (char) ('a' + rnd.nextInt(26));
        }
        return result;
    }
}
