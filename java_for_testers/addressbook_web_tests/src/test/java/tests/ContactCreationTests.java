package tests;

import common.CommonFunctions;
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
                new ContactData().withPhoto(randomPath("src/test/resources/images")),
                new ContactData()));

        for(int i=0; i<5; i++) {
            result.add(new ContactData("", CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3),
                    randomPath("src/test/resources/images"), CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3),
                    CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3), randomDayOfMonth(),
                    randomMonth(), randomYear(), CommonFunctions.randomString(i*3)));
        }
        return result;
    }

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
