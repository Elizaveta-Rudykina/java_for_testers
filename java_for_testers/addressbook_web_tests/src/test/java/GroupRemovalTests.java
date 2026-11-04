import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GroupRemovalTests {
  private WebDriver driver;

  @BeforeEach
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

    driver = new FirefoxDriver();
    driver.get("http://localhost/addressbook/");
    driver.manage().window().setSize(new Dimension(1203, 696));
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
  }

  @AfterEach
  public void tearDown() {
    driver.findElement(By.linkText("Logout")).click();
    driver.quit();
  }

  private boolean isElementPresent(By locator) {
    try{
      driver.findElement(locator);
      return true;
    } catch(NoSuchElementException exception){
      return false;
    }
  }

  @Test
  public void canRemoveGroup() {
    if (!isElementPresent(By.name("new"))) {
      driver.findElement(By.linkText("groups")).click();
    }
    if (!isElementPresent(By.name("selected[]"))) {
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
    driver.findElement(By.name("selected[]")).click();
    driver.findElement(By.name("delete")).click();
    driver.findElement(By.linkText("groups")).click();
  }
}
