package com.lenyiova;

import com.lenyiova.katas.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // PhoneNumber
        System.out.println(PhoneNumber.createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));  // => returns "(123) 456-7890"

        // DRoot
        // 493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
        System.out.println(DRoot.digital_root(493193));

        // Order
        // "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
        System.out.println(Order.order("4of Fo1r pe6ople g3ood th5e the2"));

        // SortTheOdd
        // [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
        System.out.println(Arrays.toString(SortTheOdd.sortArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));

        // WhichAreIn
        String[] a1 = new String[]{"arp", "live", "strong"};
        String[] a2 = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        // returns ["arp", "live", "strong"]
        System.out.println(Arrays.toString(WhichAreIn.inArray(a1, a2)));

        // PaginationHelper
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(helper.pageCount()); //should == 2
        System.out.println(helper.itemCount()); //should == 6
        System.out.println(helper.pageItemCount(0)); //should == 4
        System.out.println(helper.pageItemCount(1)); // last page - should == 2
        System.out.println(helper.pageItemCount(2)); // should == -1 since the page is invalid

        System.out.println(helper.pageIndex(5)); //should == 1 (zero based index)
        System.out.println(helper.pageIndex(2)); //should == 0
        System.out.println(helper.pageIndex(20)); //should == -1
        System.out.println(helper.pageIndex(-10)); //should == -1

        // Directions
        Directions.dirReduc(new String[] {"west", "east", "south"});  // -> ["SOUTH"]
        Directions.dirReduc(new String[] {"NORTH", "WEST", "SOUTH", "EAST"});  // -> ["NORTH", "WEST", "SOUTH", "EAST"]
        Directions.dirReduc(new String[] {"NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"});  // -> ["WEST", "WEST"]
    }
}
