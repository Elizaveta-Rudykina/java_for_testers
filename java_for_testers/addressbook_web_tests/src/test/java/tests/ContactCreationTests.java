package tests;

import model.contact.*;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData(new Identity("Romanova", "Ekaterina", "Alekseevna", "katya", "Mrs."),
                new Communication("Winter Palace", "275894", "786976668593", "734589", "katya", "katya2", "katya3", "perevorot.ru"),
                new Dates("5", "April", "1684", "7", "July", "1700"),
                new AdditionalInfo( "government", "Group name", "C:\\Users\\user\\Pictures\\Screenshots\\Eren_reveals_his_cut_palm.png")));
    }
}
