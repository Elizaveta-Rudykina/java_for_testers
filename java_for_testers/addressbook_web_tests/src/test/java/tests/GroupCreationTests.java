package tests;

import common.CommonFunctions;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.IOException;


public class GroupCreationTests extends TestBase {

    public static List<GroupData> groupProvider() { //должен быть всегда static
        var result = new ArrayList<GroupData>();
//        for(var name : List.of("", "group name")) { //вложенные циклы, проверяют все возможные варианты
//            for(var header : List.of("", "group header")) {
//                for(var footer : List.of("", "group footer")) {
//                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
//                }
//
//            }
//        }

//        String json = "";
//        try(BufferedReader reader = new BufferedReader(new FileReader("groups.json"))) {
//            String line;
//            while((line = reader.readLine()) != null) {
//                json = json + line;
//            }
//        } catch(IOException e) {
//            System.out.println("Данные не прочитаны из файла: " + e.getMessage());
//        }
        String json = "";
        try{
            json = Files.readString(Paths.get("groups.json"));
        } catch(IOException e){
            System.err.println("Данные из файла groups.json не прочитаны: " + e.getMessage());
        }
        ObjectMapper mapper = new ObjectMapper();
        List<GroupData> value = mapper.readValue(json, new TypeReference<List<GroupData>>() {});
        result.addAll(value);
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
