package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); //указываю путь к драйверу на пк, так как автоматом не подгружается

        if(app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "firefox"));

    }

    public static String randomString(int n) {
        Random rnd = new Random();
        String result = "";
        for(int i=0; i<n; i++) {
            result += (char) ('a' + rnd.nextInt(26));
        }
        return result;
    }

    public static String randomDayOfMonth() {
        return Integer.toString(new Random().nextInt(0, 32));
    }

    public static String randomYear() {
        return Integer.toString(new Random().nextInt(1950, 2009));
    }

    public static String randomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September",  "October", "November", "December"};
        Random rnd = new Random();
        return months[rnd.nextInt(months.length)];
    }

    public static String randomPhotoPath() {
        String[] photos = {"C:\\Users\\user\\Pictures\\Screenshots\\Eren_reveals_his_cut_palm.png",
                "C:\\Users\\user\\Pictures\\Screenshots\\Akame.png",
                "C:\\Users\\user\\Pictures\\Screenshots\\Esdeath.png"};
        Random rnd = new Random();
        return photos[rnd.nextInt(photos.length)];
    }
}
