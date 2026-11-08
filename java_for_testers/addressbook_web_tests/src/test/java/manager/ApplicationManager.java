package manager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    protected static WebDriver driver;

    public void init() {
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

    public void createGroup(GroupData group) {
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(group.name());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(group.header());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(group.footer());
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }

    public void openGroupPage() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
    }

    public boolean isGroupPresent() {
      return isElementPresent(By.name("selected[]"));
    }

    public boolean isElementPresent(By locator) { //метод, который проверяет есть ли на странице такой элемент
        try{
            driver.findElement(locator); //ищем элемент по переданному параметру
            return true; //если нашли
        } catch(NoSuchElementException exception){
            return false; //исключение означает, что не нашли
        }
    }

    public void removeGroup() {
      driver.findElement(By.name("selected[]")).click();
      driver.findElement(By.name("delete")).click();
      driver.findElement(By.linkText("groups")).click();
    }
}
