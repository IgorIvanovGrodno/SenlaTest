package test.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberLCMandGCD {

    public static void main(String[] args) {
        int firstNumber=0;
        int secondNumber=0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String firstNumberInput;
            String secondNumberInput;
            while (true) {
                System.out.println("Please, enter two numbers(integer)");
                firstNumberInput = bufferedReader.readLine();
                secondNumberInput = bufferedReader.readLine();

                if (firstNumberInput.matches("^-?[0-9]+")&secondNumberInput.matches("^-?[0-9]+")) {
                    firstNumber = Integer.parseInt(firstNumberInput);
                    secondNumber = Integer.parseInt(secondNumberInput);
                    break;
                } else {
                    System.out.println("Incorrect numbers");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("least common multiple is "+lcm(firstNumber, secondNumber));
        System.out.println("greatest common divisor is "+gcd(firstNumber, secondNumber));

    }

    //Function for search least common multiple

    public static int lcm(int firstNumber, int secondNumber){
        return Math.abs(firstNumber * secondNumber) / gcd(firstNumber, secondNumber) ;
    }


    // Function for search greatest common divisor

    public static int gcd(int firstNumber, int secondNumber){
        if(firstNumber==0&secondNumber==0) return 1;
        return secondNumber == 0 ? Math.abs(firstNumber) : gcd(secondNumber, firstNumber % secondNumber);

    }
}

