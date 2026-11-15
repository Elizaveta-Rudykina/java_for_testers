package tests;

import model.*;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    void canRemoveContact() {
        if(! app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("Romanova", "Ekaterina", "Alekseevna",
                    "katya", "C:\\Users\\user\\Pictures\\Screenshots\\Eren_reveals_his_cut_palm.png",
                    "Mrs.", "government", "Winter Palace", "275894", "786976668593",
                    "734589", "katya", "katya2", "katya3", "perevorot.ru",
                    "5", "April", "1684", "7", "July", "1700", "Group name"));
        }
        app.contacts().removeContact();
    }
}
