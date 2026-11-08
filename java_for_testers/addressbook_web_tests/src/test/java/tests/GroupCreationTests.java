package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        TestBase.app.openGroupPage();
        TestBase.app.createGroup(new GroupData("Group name", "Group header", "Group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        TestBase.app.openGroupPage();
        TestBase.app.createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        TestBase.app.openGroupPage();
        TestBase.app.createGroup(new GroupData().withName("Some name"));
    }

}
