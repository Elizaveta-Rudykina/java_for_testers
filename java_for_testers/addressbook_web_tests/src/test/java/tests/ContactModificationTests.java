package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if(app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData().withFullName("Eren",
                    "Grigorievich", "Egar"));
        }
        List<ContactData> oldContacts = app.contacts().getList();
        int index = new Random().nextInt(oldContacts.size());
        ContactData testData = new ContactData().withFirstAndLastNames("Contact", "Modified");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        List<ContactData> newContacts = app.contacts().getList();
        List<ContactData> expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(expectedList, newContacts);
    }
}
