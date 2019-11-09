package test.task6;

import java.util.ArrayList;

public class Backpack {
    private int carryingCapacityMax;
    private int summaryValue;
    private ArrayList<Thing> containsThings;

    public Backpack(int carryingCapacity){
        this.carryingCapacityMax = carryingCapacity;
        containsThings = new ArrayList<Thing>();
        summaryValue=0;
    }

    /*This function add Things to backpack and maximization value/
    * We use dynamic programming.
    * We create table "matrix" and elements matrix[numberItems][carryingCapacityMax]  is maximum value of backpack.
    * Than we find and add things to the list of backpack
    */

    public void maximizationValueFilling(ArrayList<Thing> things) {
        int numberItems = things.size();

        //Create table to find maximum value
        int[][] matrix = new int[numberItems + 1][carryingCapacityMax + 1];

        //Initialization first line to 0
        for (int i = 0; i <= carryingCapacityMax; i++) {
            matrix[0][i] = 0;
        }

        //Fill table
        for (int i = 1; i <= numberItems; i++) {
            for (int j = 0; j <= carryingCapacityMax; j++) {
                if (things.get(i-1).getWeight() > j)
                    matrix[i][j] = matrix[i - 1][j];
                else
                    // We maximize value at this rank in the table
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - things.get(i-1).getWeight()] +
                            things.get(i-1).getValue());
            }
        }

        summaryValue = matrix[numberItems][carryingCapacityMax];


        //Find and add things to the backpack
        int bufValue = summaryValue;
        int bufCapacity = carryingCapacityMax;

        for (int i = numberItems; i > 0  &&  bufValue > 0; i--) {
            if (bufValue != matrix[i-1][bufCapacity]) {
                containsThings.add(things.get(i-1));
                // we remove items value and weight
                bufValue -= things.get(i-1).getValue();
                bufCapacity -= things.get(i-1).getWeight();
            }
        }
    }


    public void displayContaisThings(){
        System.out.println("Backpack capacity="+ carryingCapacityMax+" values="+summaryValue+" contains:");
        for(Thing thing:containsThings){
            System.out.println(thing);
        }
    }



    public int getCarryingCapacity() {
        return carryingCapacityMax;
    }
}
