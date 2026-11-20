package tests;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData().withFullName("Eren", "Grigorievich", "Egar"),
                new ContactData().withFirstAndLastNames("Elisabeth", "Chapman"),
                new ContactData()));

        for(int i=0; i<5; i++) {
            result.add(new ContactData("", randomString(i*3), randomString(i*3), randomString(i*3),
                    randomString(i*3), randomPhotoPath(), randomString(i*3), randomString(i*3),
                    randomString(i*3), randomString(i*3), randomString(i*3), randomString(i*3),
                    randomString(i*3), randomString(i*3), randomString(i*3), randomString(i*3),
                    randomDayOfMonth(), randomMonth(), randomYear(), randomDayOfMonth(),
                    randomMonth(), randomYear(), randomString(i*3)));
        }
        return result;
    }

    /*@Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("Romanova", "Ekaterina", "Alekseevna",
                "katya", "C:\\Users\\user\\Pictures\\Screenshots\\Eren_reveals_his_cut_palm.png",
                "Mrs.", "government", "Winter Palace", "275894", "786976668593",
                "734589", "katya", "katya2", "katya3", "perevorot.ru",
                "5", "April", "1684", "7", "July", "1700", "Group name"));
    }
     */

    @ParameterizedTest
    @MethodSource("contactProvider")
    void canCreateMultiplyContacts(ContactData contact) {
        List<ContactData> oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        List<ContactData> newContacts = app.contacts().getList();
        Comparator <ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        List<ContactData> expectedList = new ArrayList<>(oldContacts);
        expectedList.add(new ContactData().withId(newContacts.getLast().id()).withFirstAndLastNames(
                contact.firstName(), contact.lastName()));
        expectedList.sort(compareById);
        Assertions.assertEquals(expectedList, newContacts);
    }
}
