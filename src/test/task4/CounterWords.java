/*
 * CounterWords
 * Класс считывает текст из консоли и слово для поиска. Затем подсчитывает ивыводит на консоль сколько раз встречается заданное слово в тексте без учета регистра.
 *
 * Автор: Иванов Игорь
 * Контакты: igor.ivanov.grodno@gmail.com
 * */
package test.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CounterWords {

    public static void main(String[] args) {
        String text = null;
        String pattern = null;

        //Считываем текст и слово для поиска из консоли
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            while(true) {
                System.out.println("Please, enter text");
                text = bufferedReader.readLine();
                System.out.println("Please, enter pattern word for count");
                pattern = bufferedReader.readLine();

                //Проверяем не ввел ли пользователь пустые строки
                if(!(text.isEmpty()|pattern.isEmpty())) break;
                else System.out.println("Text and pattern should not be empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Word repeat "+countWord(text, pattern));
    }

    /*
    *Функция принимает текст и слово для поиска и возвращает сколько раз слово встречается в тексте
    */
    public static int countWord(String text, String pattern){
        if(text==null|pattern==null) return -1;
        String[] arr = ("  "+text+"  ").toLowerCase().split("[\\p{Space}\\p{Punct}]"+pattern.toLowerCase()+"[\\p{Space}\\p{Punct}]");
        return arr.length-1;

       /* text=text.replaceAll("[\\p{Punct}&&[^-']]", " ").toLowerCase();
        text = " "+text+" ";
        pattern =" "+pattern.toLowerCase()+" ";
        int count = 0;

        int index = text.indexOf(pattern);

        while (index >= 0) {
            count++;
            index = text.indexOf(pattern, index + 1);
        }
        return count;*/
    }
}
