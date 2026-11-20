package tests;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    void canRemoveContact() {
        if(! app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("", "Romanova", "Ekaterina",
                    "Alekseevna", "katya", "C:\\Users\\user\\Pictures\\Screenshots\\Eren_reveals_his_cut_palm.png",
                    "Mrs.", "government", "Winter Palace", "275894",
                    "786976668593", "734589", "katya", "katya2", "katya3",
                    "perevorot.ru", "5", "April", "1684", "7",
                    "July", "1700", "Group name"));
        }
        List<ContactData> oldContacts = app.contacts().getList();
        int index = new Random().nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        List<ContactData> newContacts = app.contacts().getList();
        List<ContactData> expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(expectedList, newContacts);
    }
}
