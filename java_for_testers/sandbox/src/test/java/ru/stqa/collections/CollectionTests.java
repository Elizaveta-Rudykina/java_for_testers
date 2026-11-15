package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {

    @Test
    void arrayTests() {
        String[] array = {"a", "b", "c"};
        Assertions.assertEquals("a", array[0]);

        array[0] = "z";
        Assertions.assertEquals("z", array[0]);
        Assertions.assertEquals(3, array.length);
    }

    @Test
    void ListTests() {
        //ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>(List.of("a", "b", "c"));

        //list.add("a");
        //list.add("b");
        //list.add("c");

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("a", list.get(0));

        list.set(0, "z");
    }
}
