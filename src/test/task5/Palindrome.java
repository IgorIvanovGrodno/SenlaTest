/*
 * Palindrome
 *
 * The class displays to the console all the numbers of the palindromes from the sequence [0; N], where N is the number entered by the user not exceeding 100.
 *
 * Author: Igor Ivanov
 * E-mail: igor.ivanov.grodno@gmail.com
 * */
package test.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    //Write all the numbers of the palindromes from a sequence from 0 to 100
    private static int[] palindromeNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99};

    public static void main(String[] args) {
        double number = 0;

        //We read from the console the number (the boundary of the sequence)
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputNumber;
            while (true) {
                System.out.println("Please, enter number");
                inputNumber = bufferedReader.readLine();

                //We check the correctness of the input of the number (according to the condition of the problem, it does not say there should be an integer or not, therefore we accept fractional ones)
                if (inputNumber != null && (!inputNumber.isEmpty()) && inputNumber.matches("^\\d+\\.?\\d*")) {
                    number = Double.parseDouble(inputNumber);
                } else {
                    System.out.println("Number isn't correct");
                    continue;
                }

                //Check if the entered number is in the given range
                if (number >= 0 && number <= 100) break;
                else System.out.println("Number should be in the range [0;100]");
            }

            outPalindromToConsole(number);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method accepts the number number and prints to the console palindromes of numbers from 0 to number
     *
     * @param number
     */
    public static void outPalindromToConsole(double number) {
        int i = 0;
        while (i < palindromeNumbers.length && palindromeNumbers[i] <= number) {
            System.out.println(palindromeNumbers[i]);
            i++;
        }
    }
}
