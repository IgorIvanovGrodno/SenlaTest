/*
 * Palindrome
 * Класс выводит на консоль все числа палиндромы из последовательности [0; N], где N число введенное пользователем не превышающее N.
 *
 * Автор: Иванов Игорь
 * Контакты: igor.ivanov.grodno@gmail.com
 * */
package test.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    //Для повышения производительности записываем все числа палиндромы из последовательности от 0 до 100
    private static  int [] palindromeNumbers = {0,1,2,3,4,5,6,7,8,9,11,22,33,44,55,66,77,88,99};

    public static void main(String[] args) {
        double number = 0;

        //Считываем из консоли число, границу последовательности
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputNumber;
            while(true){
                System.out.println("Please, enter number");
                inputNumber=bufferedReader.readLine();

                //Проверяем корректность ввода числа(по условию задачи не сказано должно быть целое число или нет, поэтому принимаем и дробные)
                if((!inputNumber.isEmpty())&inputNumber.matches("^[0-9]+\\.?[0-9]*")){
                    number = Double.parseDouble(inputNumber);
                }else{
                    System.out.println("Number isn't correct");
                    continue;
                }

                //Проверяем входит ли введенное число в заданные диапазон
                if(number>=0&number<=100) break;
                else System.out.println("Number should be in the range [0;100]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        outPalindromToConsole(number);

    }

    /*
    *Функция принимает число number и выводит на консоль палиндромы чисел от 0 до number
    */
    public static void outPalindromToConsole(double number){
        int i=0;
        while(i<palindromeNumbers.length&&palindromeNumbers[i]<=number){
            System.out.println(palindromeNumbers[i]);
            i++;
        }
    }
}
