package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openNewContactPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("nickname"), contact.nickName());
        type(By.name("title"), contact.title());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.homePhone());
        type(By.name("mobile"), contact.mobilePhone());
        type(By.name("work"), contact.workPhone());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("homepage"), contact.homepage());
        dropdownSelect(By.name("bday"), "bday", contact.birthDay());
        dropdownSelect(By.name("bmonth"), "bmonth", contact.birthMonth());
        type(By.name("byear"), contact.birthYear());
        dropdownSelect(By.name("aday"), "aday", contact.anniversaryDay());
        dropdownSelect(By.name("amonth"), "amonth", contact.anniversaryMonth());
        type(By.name("ayear"), contact.anniversaryYear());
        uploadPhoto(contact.photo());
        type(By.name("company"), contact.company());
        dropdownSelect(By.name("new_group"), "new_group", contact.group());
    }

    private void openNewContactPage() {
        if (!manager.isElementPresent(By.name("submit"))) {
            click(By.linkText("add new"));
        }
    }

    public List<ContactData> getList() {
        openHomePage();
        ArrayList<ContactData> contacts = new ArrayList<>();
        var rows = manager.driver.findElements(By.cssSelector("tr[name='entry']"));
        for(var row : rows) {
            var checkbox = row.findElement(By.name("selected[]"));
            String id = checkbox.getAttribute("id");
            var tds = row.findElements(By.tagName("td"));
            var lastName = tds.get(1).getText().trim();
            var firstName = tds.get(2).getText().trim();
            contacts.add(new ContactData().withId(id).withFirstAndLastNames(firstName, lastName));
        }
        return contacts;
    }

    protected void dropdownSelect(By locator, String name, String option) {
        if(option == null || option.isEmpty()) {
            return;
        }
        click(locator);
        if(!manager.isElementPresent(By.xpath("//select[@name='%s']/option[. = \"%s\"]".formatted(name, option)))) {
            manager.driver.findElement(By.xpath("//select[@name='new_group']/option[. = '[none]']")).click();
        } else {
            manager.driver.findElement(By.xpath("//select[@name='%s']/option[. = \"%s\"]".formatted(name, option))).click();
        }
    }

    private void uploadPhoto(String path){
        if(path == null  || path.isEmpty()){
            return;
        }
        WebElement uploadFile = manager.driver.findElement(By.name("photo"));
        uploadFile.sendKeys(path);
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector("input[id='%s']".formatted(contact.id())));
    }

    private void removeSelectedContact() {
        click(By.name("delete"));
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
}
