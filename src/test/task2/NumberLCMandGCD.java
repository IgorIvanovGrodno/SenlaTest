/*
 * NumberLCMandGCD
 * The class reads two input integers from the console. Then it search Least Common Multiple and Greatest Common Divisor of the two numbers entered.
 * The result display on the console.
 *
 * Author: Igor Ivanov
 * E-mail: igor.ivanov.grodno@gmail.com
 * */

package test.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberLCMandGCD {

    public static void main(String[] args) {
        int firstNumber = 0;
        int secondNumber = 0;

        //Read numbers from the console
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String firstNumberInput;
            String secondNumberInput;
            while (true) {
                System.out.println("Please, enter two numbers(integer)");
                firstNumberInput = bufferedReader.readLine();
                secondNumberInput = bufferedReader.readLine();

                //Check if the user entered an empty string
                if (firstNumberInput == null || secondNumberInput == null || firstNumberInput.isEmpty() || secondNumberInput.isEmpty()) {
                    System.out.println("Input data should not be empty");
                    continue;
                }

                //Check if user entered integers
                if (firstNumberInput.matches("^-?[0-9]+") && secondNumberInput.matches("^-?[0-9]+")) {
                    firstNumber = Integer.parseInt(firstNumberInput);
                    secondNumber = Integer.parseInt(secondNumberInput);
                    break;
                } else {
                    System.out.println("Incorrect numbers");

                }
            }

            System.out.println("least common multiple is " + lcm(firstNumber, secondNumber));
            System.out.println("greatest common divisor is " + gcd(firstNumber, secondNumber));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method search and return Least Common Multiple
     *
     * @param firstNumber
     * @param secondNumber
     * @return Least Common Multiple
     */
    public static int lcm(int firstNumber, int secondNumber) {
        return Math.abs(firstNumber * secondNumber) / gcd(firstNumber, secondNumber);
    }


    /**
     * The method search and return Greatest Common Divisor
     *
     * @param firstNumber
     * @param secondNumber
     * @return Greatest Common Divisor
     */
    public static int gcd(int firstNumber, int secondNumber) {
        if (firstNumber == 0 && secondNumber == 0) return 1;
        return secondNumber == 0 ? Math.abs(firstNumber) : gcd(secondNumber, firstNumber % secondNumber);

    }
}

