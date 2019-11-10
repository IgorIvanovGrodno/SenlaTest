/*
* CheckNumber
* Класс считывает вводимое целое число из консоли. Затем проверяет является ли число четным-нечетным, целым-составным.
* Результат проверки выводится на консоль
* *
* Автор: Иванов Игорь
* Контакты: igor.ivanov.grodno@gmail.com
* */

package test.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CheckNumber {

    public static void main(String[] args) {

        long number = 0;

            //Считываем число из консоли
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                String inputData;
                while (true) {
                    System.out.println("Please, enter number(integer)");
                    inputData = bufferedReader.readLine();

                    //Проверяем не ввел ли пользователь пустую строку
                    if(inputData.isEmpty()) {
                        System.out.println("Input data should not be empty");
                        continue;
                    }

                    //Проверяем ввел ли пользователь целое число
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
        checkNumberPrime(number);

    }

    /*
    *Функция для проверки числа на четность. Результат проверки выводится на консоль.
    */
    public static void checkNumberEven(long number) {

        if (number % 2 == 0) System.out.println("Number is even");
        else System.out.println("Number is odd");

    }

    /*
    *Функция проверки числа на целое-составное. Результат проверки выводится на консоль
    */
    public static void checkNumberPrime(long number) {

        //Проверяем является ли число натуральным
        if(number<=0){
            System.out.println("Number isn't natural number");
            return;
        }

        //Проверяем является личисло целым
        boolean flag = false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                flag = true;
                break;
            }
        }
        if (flag) System.out.println("Number is composite");
        else System.out.println("Number is prime");
    }


}
