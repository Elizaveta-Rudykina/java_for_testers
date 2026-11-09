package manager;

import model.contact.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void submitContactCreation() {
       click(By.name("submit"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.identity().firstName());
        type(By.name("middlename"), contact.identity().middleName());
        type(By.name("lastname"), contact.identity().lastName());
        type(By.name("nickname"), contact.identity().nickName());
        type(By.name("title"), contact.identity().title());
        type(By.name("address"), contact.communication().address());
        type(By.name("home"), contact.communication().homePhone());
        type(By.name("mobile"), contact.communication().mobilePhone());
        type(By.name("work"), contact.communication().workPhone());
        type(By.name("email"), contact.communication().email());
        type(By.name("email2"), contact.communication().email2());
        type(By.name("email3"), contact.communication().email3());
        type(By.name("homepage"), contact.communication().homepage());
        dropdownSelect(By.name("bday"), "bday", contact.dates().birthDay());
        dropdownSelect(By.name("bmonth"), "bmonth", contact.dates().birthMonth());
        type(By.name("byear"), contact.dates().birthYear());
        dropdownSelect(By.name("aday"), "aday", contact.dates().anniversaryDay());
        dropdownSelect(By.name("amonth"), "amonth", contact.dates().anniversaryMonth());
        type(By.name("ayear"), contact.dates().anniversaryYear());
        uploadPhoto(contact.additionalInfo().photoUrl());
        type(By.name("company"), contact.additionalInfo().company());
        dropdownSelect(By.name("new_group"), "new_group", contact.additionalInfo().group());
    }

    private void openNewContactPage() {
        if (!manager.isElementPresent(By.name("submit"))) {
            click(By.linkText("add new"));
        }
    }
    private void uploadPhoto(String path){
        WebElement uploadFile = manager.driver.findElement(By.name("photo"));
        uploadFile.sendKeys(path);
    }
}
