import org.junit.jupiter.api.Test;


public class GroupRemovalTests extends TestBase{

  @Test
  public void canRemoveGroup() {
    openGroupPage();
    if (!isGroupPresent()) {
      createGroup("Group name", "Group header", "Group footer");
    }
    removeGroup();
  }

}
