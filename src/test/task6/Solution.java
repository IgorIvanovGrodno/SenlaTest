/*
 * Solution
 * The class creates a list of things (Thing) intended for placement in a backpack (Backpack).
 * And passes this list to the Backpack method to place things with maximized total value
 *
 * Author: Igor Ivanov
 * E-mail: igor.ivanov.grodno@gmail.com
 */
package test.task6;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        //Create a list of items that will be handed over for packing in a backpack
        ArrayList<Thing> listThing = new ArrayList<>();
        listThing.add(new Thing(5, 3, "compass"));
        listThing.add(new Thing(10, 5, "knife"));
        listThing.add(new Thing(6, 4, "water"));
        listThing.add(new Thing(5, 2, "smartphone"));

        //Create a backpack with a carrying capacity of 14
        Backpack backpack = new Backpack(14);


        // Pass a list of things to put them in a backpack with maximizing the total value
        backpack.maximizationValueFilling(listThing);


        // Print the contents of the backpack to the console
        backpack.displayContaisThings();

    }


}
