package tests;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;


public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData().withFullNameOnly("Eren", "Grigorievich", "Egar"),
                new ContactData().withNameAndPhoneOnly("Elisabeth", "79505050505"),
                new ContactData()));

        for(int i=0; i<5; i++) {
            result.add(new ContactData(randomString(i*5), randomString(i*5), randomString(i*5),
                    randomString(i*5), randomPhotoPath(), randomString(i*5), randomString(i*5),
                    randomString(i*5), randomString(i*5), randomString(i*5), randomString(i*5),
                    randomString(i*5), randomString(i*5), randomString(i*5), randomString(i*5),
                    randomDayOfMonth(), randomMonth(), randomYear(), randomDayOfMonth(),
                    randomMonth(), randomYear(), randomString(i*5)));
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
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount+1, newContactCount);
    }
}
