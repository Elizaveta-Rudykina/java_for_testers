package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); //указываю путь к драйверу на пк, так как автоматом не подгружается

        if(app == null) {
            app = new ApplicationManager();
        }
        app.init();

    }
}
