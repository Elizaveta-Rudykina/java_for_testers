package manager;

import model.ContactData;
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

    public void removeContact() {
        openHomePage();
        selectContact();
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

    private void selectContact() {
        click(By.name("selected[]"));
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
}
