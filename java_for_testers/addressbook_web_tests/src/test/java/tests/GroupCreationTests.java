package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
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
        int groupCount = app.groups().getCount();
        app.groups().createGroup(group);
        int newgroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + 1, newgroupCount);
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void cannotCreateGroup(GroupData group) {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(group);
        int newgroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount, newgroupCount);
    }
}
