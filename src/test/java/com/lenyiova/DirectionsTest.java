package com.lenyiova;

import com.lenyiova.katas.Directions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Collections;

public class DirectionsTest {

    @Test
    public void testEmptyArrayInput() {
        Object[] emptyArray = Collections.EMPTY_LIST.toArray();

        String[] resultArray = Directions.dirReduc(new String[] {});

        Assertions.assertEquals(emptyArray.length, resultArray.length, "The empty input array should be returned.");
    }

    @Test
    public void inputMustBeValid() {
        String[] invalidInput = new String[] {"north", "WEST", "strawberry", "SOUTH"};

        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Directions.dirReduc(invalidInput);
            }
        });
    }

    @Test
    public void testOneItemArray() {
        String[] oneItemArray = new String[] {"WEST"};

        String[] resultArray = Directions.dirReduc(oneItemArray);

        Assertions.assertEquals(oneItemArray.length, resultArray.length);
    }

    @Test
    public void testSixItemArray() {
        String[] array = new String[] {"NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"};

        String[] resultArray = Directions.dirReduc(array);

        Assertions.assertTrue(resultArray.length == 2 && resultArray[0].equals("WEST"));
    }
}
