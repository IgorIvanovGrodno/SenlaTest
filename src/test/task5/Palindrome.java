package test.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    private static  int [] palindromeNumbers = {0,1,2,3,4,5,6,7,8,9,11,22,33,44,55,66,77,88,99};

    public static void main(String[] args) {
        double number = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputNumber;
            while(true){
                System.out.println("Please, enter number");
                inputNumber=bufferedReader.readLine();
                if(!inputNumber.isEmpty()&inputNumber.matches("^[0-9]+.?[0-9]*")){
                    number = Double.parseDouble(inputNumber);
                }else{
                    System.out.println("Number isn't correct");
                    continue;
                }
                if(number>=0&number<=100) break;
                else System.out.println("Number should be in range [0;100]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        outPalindromToConsole(number);

    }

    public static void outPalindromToConsole(double number){
        for (int i=0; i<palindromeNumbers.length; i++){
            if(palindromeNumbers[i]<number) System.out.println(palindromeNumbers[i]);
            else break;
        }
    }
}
