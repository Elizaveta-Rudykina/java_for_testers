package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class GroupCreationTests extends TestBase {

    public static List<GroupData> groupProvider() { //должен быть всегда static
        var result = new ArrayList<GroupData>();
        for(var name : List.of("", "group name")) { //вложенные циклы, проверяют все возможные варианты
            for(var header : List.of("", "group header")) {
                for(var footer : List.of("", "group footer")) {
                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
                }

            }
        }
        for(int i=0; i<5; i++) {
            result.add(new GroupData()
                    .withName(randomString(i*10))
                    .withHeader(randomString(i*10))
                    .withFooter(randomString(i*10)));
        }
        return result;
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(new GroupData("", "group name'", "", "")));
        return result;
    }

    /* убрали тесты canCreateGroup, canCreateGroupWithEmptyName и canCreateGroupWithNameOnly,
      потому что они теперь проверяются в одном тесте canCreateMultipleGroups с использованием разных параметров
    */

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultiplyGroups(GroupData group) {
        List<GroupData> oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        List<GroupData> newGroups = app.groups().getList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        List<GroupData> expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newGroups.getLast().id()).withHeader("").withFooter(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(expectedList, newGroups);
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void cannotCreateGroup(GroupData group) {
        List<GroupData> oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        List<GroupData> newGroups = app.groups().getList();
        Assertions.assertEquals(oldGroups, newGroups);
    }
}
