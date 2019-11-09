package test.task6;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Thing> listThing = new ArrayList<>();
        listThing.add(new Thing(6,18,"compass"));
        listThing.add(new Thing(6,10,"knife"));
        listThing.add(new Thing(5,10,"water"));
        Backpack backpack = new Backpack(10);
        backpack.maximizationValueFilling(listThing);
        backpack.displayContaisThings();

    }


}
