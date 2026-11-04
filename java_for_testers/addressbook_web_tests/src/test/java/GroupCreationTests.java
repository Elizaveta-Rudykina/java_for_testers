import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupCreationTests {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); //указываю путь к драйверу на пк, так как автоматом не подгружается

        if(driver == null) { //перед каждым тестом проверяется открыт ли браузер, если да, то заново не открываем
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit)); //после завершения всех тестов закрывает браузер, вместо постусловия

            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1203, 692));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).click();
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }

    }

    private boolean isElementPresent(By locator) { //метод, который проверяет есть ли на странице такой элемент
        try{
            driver.findElement(locator); //ищем элемент по переданному параметру
            return true; //если нашли
        } catch(NoSuchElementException exception){
            return false; //исключение означает, что не нашли
        }
    }

    @Test
    public void canCreateGroup() {
        if(! isElementPresent(By.name("new"))) { //предусл. перед конкретным кейсом: если на странице есть элемент, то нам не нужно переходить на эту вкладку, мы уже на ней
            driver.findElement(By.linkText("groups")).click();
        }
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys("Group name");
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys("Group header");
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys("Group footer");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }


    @Test
  public void canCreateGroupWithEmptyName() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys("");
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys("");
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys("");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }
}
