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
        if(app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData().withFullName("Eren",
                    "Grigorievich", "Egar"));
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
