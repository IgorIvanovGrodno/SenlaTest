/*
 * Backpack
 * The class is a backpack of a certain carrying capacity.
 * The backpack contains a list of things placed in it and has a function,
 * which puts things in a backpack with maximization of the total value.
 *
 * Author: Igor Ivanov
 * E-mail: igor.ivanov.grodno@gmail.com
 */

package test.task6;

import java.util.ArrayList;

public class Backpack {
    private int carryingCapacityMax;
    private int summaryValue;
    private ArrayList<Thing> containsThings;

    public Backpack(int carryingCapacity) {
        this.carryingCapacityMax = carryingCapacity;
    }

    /**
     * The method accepts a list of things.
     * The method adds to containsThings
     * only those things, the addition of which will give the maximum
     * total value.
     *
     * @param things
     */
    public void maximizationValueFilling(ArrayList<Thing> things) {
        if (things == null) return;
        int numberItems = things.size();
        containsThings = new ArrayList<>();

        //We create a table of total values ​​depending on the number of elements and the carrying capacity of the backpack.
        //Using the table, we will search for the maximum total value that will be found after filling
        //in the matrix[numberItems][carryingCapacityMax]
        int[][] matrix = new int[numberItems + 1][carryingCapacityMax + 1];

        //Initialize the first line with zeros
        for (int i = 0; i <= carryingCapacityMax; i++) {
            matrix[0][i] = 0;
        }

        //Fill the table
        for (int i = 1; i <= numberItems; i++) {
            for (int j = 0; j <= carryingCapacityMax; j++) {

                //If the weight of the item is greater than the capacity of the backpack, then add the value from the previous line to the cell
                if (things.get(i - 1).getWeight() > j)
                    matrix[i][j] = matrix[i - 1][j];

                    //Else, we determine: the total value will be higher with the addition of the current element, or without its addition (value from the previous line)
                    //The cell is assigned the maximum value
                else
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - things.get(i - 1).getWeight()] +
                            things.get(i - 1).getValue());
            }
        }
        summaryValue = matrix[numberItems][carryingCapacityMax];

        //Determine the things you need to add to the backpack
        int bufValue = summaryValue;
        int bufCapacity = carryingCapacityMax;

        for (int i = numberItems; i > 0 && bufValue > 0; i--) {

            //If the value in the current cell and in the cell in the previous line are not equal, then adding the current element maximizes the total value and we add it to the backpack
            if (bufValue != matrix[i - 1][bufCapacity]) {
                containsThings.add(things.get(i - 1));

                //We pass the carrying capacity of the backpack and the total value, because item was added to backpack
                bufValue -= things.get(i - 1).getValue();
                bufCapacity -= things.get(i - 1).getWeight();
            }
        }
    }

    /**
     * The method displays the parameters of the backpack and its contents on the console
     */
    public void displayContaisThings() {
        System.out.println("Backpack capacity=" + carryingCapacityMax + " values=" + summaryValue + " contains:");
        if (containsThings == null) {
            System.out.println("backpack is empty");
            return;
        }
        for (Thing thing : containsThings) {
            System.out.println(thing);
        }
    }
}
