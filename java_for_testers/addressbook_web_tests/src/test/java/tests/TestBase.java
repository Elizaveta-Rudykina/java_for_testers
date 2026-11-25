package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.Paths;
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

    public static String randomPath(String dir) {
        var fileNames = new File(dir).list(); //метод list возвращ массив имён файлов в заданной директории
        Random rnd = new Random();
        int index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }
}
