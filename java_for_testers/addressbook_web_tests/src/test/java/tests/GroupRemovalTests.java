package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GroupRemovalTests extends TestBase {

  @Test
  public void canRemoveGroup() {
    if (app.groups().getCount() == 0) {
      app.groups().createGroup(new GroupData().withName("Group name").withHeader("Group header").withFooter("Group footer"));
    }
    List<GroupData> oldGroups = app.groups().getList();
    int index = new Random().nextInt(oldGroups.size());
    app.groups().removeGroup(oldGroups.get(index));
    List<GroupData> newGroups = app.groups().getList();
    List<GroupData> expectedList = new ArrayList<>(oldGroups);
    expectedList.remove(index);
    Assertions.assertEquals(expectedList, newGroups);
  }

  @Test
  void canRemoveAllGroupsAtOnce() {
    if (app.groups().getCount() == 0) {
      app.groups().createGroup(new GroupData().withName("Group name").withHeader("Group header").withFooter("Group footer"));
    }
    app.groups().removeAllGroups();
    Assertions.assertEquals(0, app.groups().getCount());
  }
}
