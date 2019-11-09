package test.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CheckNumber {

    public static void main(String[] args) {

        long number = 0;
            bigIntegerNumber();
            /*try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                String inputData;
                while (true) {
                    System.out.println("Please, enter number(integer)");
                    inputData = bufferedReader.readLine();
                    if (inputData.matches("^-?[0-9]+")) {
                        number = Long.parseLong(inputData);
                        break;
                    } else {
                        System.out.println("Incorrect number");

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        checkNumberEven(number);
        checkNumberPrime(number);*/

    }

    public static void checkNumberEven(long number) {

        if (number % 2 == 0) System.out.println("Number is even");
        else System.out.println("Number is odd");

    }

    public static void checkNumberPrime(long number) {
        boolean flag = false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                flag = true;
                break;
            }
        }
        if (flag) System.out.println("Number is prime");
        else System.out.println("Number is composite");
    }

    public static void bigIntegerNumber(){
        BigInteger number = null;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputData;
            while (true) {
                System.out.println("Please, enter number(integer)");
                inputData = bufferedReader.readLine();
                if (inputData.matches("^-?[0-9]+")) {
                    number = new BigInteger(inputData);
                    break;
                } else {
                    System.out.println("Incorrect number");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        checkNumberEven(number);
        checkNumberPrime(number);
    }

    public static void checkNumberEven(BigInteger number) {
        BigInteger numberTwo = new BigInteger("2");

        if (number.divideAndRemainder(numberTwo)[1].toString().equals("0")) System.out.println("Number is even");
        else System.out.println("Number is odd");

    }

    public static void checkNumberPrime(BigInteger number) {
        if(number.toString().equals("0")|number.toString().equals("1")|number.toString().equals("-1")) {
            System.out.println("Number is composite");
            return;
        }
        boolean flag = false;
        BigInteger numberDivide = new BigInteger("2");
        BigInteger increment = new BigInteger("1");

        while(!number.toString().equals(numberDivide.toString())){
            if(number.divideAndRemainder(numberDivide)[1].equals("0")) {
                flag=true;
                break;
            }
            numberDivide=numberDivide.add(increment);

        }
        if (flag) System.out.println("Number is prime");
        else System.out.println("Number is composite");
    }


}
