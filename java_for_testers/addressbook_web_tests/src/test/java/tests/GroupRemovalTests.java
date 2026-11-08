package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;


public class GroupRemovalTests extends TestBase {

  @Test
  public void canRemoveGroup() {
    TestBase.app.openGroupPage();
    if (!TestBase.app.isGroupPresent()) {
      TestBase.app.createGroup(new GroupData("Group name", "Group header", "Group footer"));
    }
    TestBase.app.removeGroup();
  }
}
