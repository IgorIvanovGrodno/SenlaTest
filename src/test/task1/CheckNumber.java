/*
 * CheckNumber
 * The class reads the input integer from the console. Then it checks if the number is even-odd, integer-composite.
 * The result of the verification is displayed on the console.
 *
 * Author: Igor Ivanov
 * E-mail: igor.ivanov.grodno@gmail.com
 * */

package test.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CheckNumber {

    public static void main(String[] args) {

        //The conditions of the task do not discuss the range of input data, so we use int instead of BigInteger
        //Test comment
        int number = 0;

        //Read the number from the console
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputData;
            while (true) {
                System.out.println("Please, enter number(integer)");
                inputData = bufferedReader.readLine();

                //Check if the user entered an empty string
                if (inputData == null || inputData.isEmpty()) {
                    System.out.println("Input data should not be empty");
                    continue;
                }

                //Check if the user entered an integer
                if (inputData.matches("^-?\\d+")) {
                    number = Integer.parseInt(inputData);
                    break;
                } else {
                    System.out.println("Incorrect number");

                }
            }
            checkNumberEven(number);
            checkNumberPrime(number);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * The method for checking the number for even-odd. The result of the verification is displayed on the console.
     *
     * @param number
     */
    public static void checkNumberEven(int number) {

        if (number % 2 == 0) System.out.println("Number is even");
        else System.out.println("Number is odd");

    }

    /**
     * The method for checking the number for prime-composite. The result of the verification is displayed on the console.
     *
     * @param number
     */
    public static void checkNumberPrime(int number) {

        //Check if the number is a natural.
        if (number <= 0) {
            System.out.println("Number isn't natural number");
            return;
        }

        //Check if the number is a prime.
        String strResult = "prime";
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                strResult = "composite";
                break;
            }
        }

        System.out.println("Number is " + strResult);
    }


}
