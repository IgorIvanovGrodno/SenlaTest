/*
 * ParserWords
 * Класс считывает строку из консоли. Затем подсчитывает и выводит на консоль количество слов в предложении, сортирует слова и выводит их на консоль с заглавной буквы.
 *
 * Автор: Иванов Игорь
 * Контакты: igor.ivanov.grodno@gmail.com
 * */

package test.task3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ParserWords {

    public static void main(String[] args) {
        String text = null;

        //Считываем строку из консоли
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            while(true) {
                System.out.println("Please, enter text");
                text = bufferedReader.readLine();

                //Проверяем не ввел ли пользователь пустую строку
                if(!text.isEmpty()) break;
                else System.out.println("Tetx should not be empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       parser(text);
    }

    /*
    *Функция парсит слова в переданном тексте. Подсчитывает их количество, сортирует и выводит их на консоль с заглавной буквы
    */
    public static void parser(String text){
        if(text==null) return;
        ArrayList<String> listWords=new ArrayList<>();

        //Парсим слова разделенные пробелом
        String[] arrayWords = text.split(" ");

            for (String word: arrayWords){

                //Удаляем знаки пунктуации в начале слова и в конце(например могут встречаться запятые в конце слова или кавычки в начале и в конце)
               word=word.replaceAll("^\\p{Punct}+","").replaceAll("\\p{Punct}+$","");

               //Проверяем правильно ли написано слово: нет ли в слове цифр, знаков пунктуации (кроме дефиса, который может встречаться в сложных словах Царь-пушкаи т.д.; и апострофа, который встречается в английских словах)

                if(word.matches("[^0-9№\\p{Punct}]+[-']?[^0-9№\\p{Punct}]*")) {

                    //Если слово написано правильно, добавляем его в итоговый список и делаем первую букву заглавной
                    listWords.add(word.substring(0,1).toUpperCase()+word.substring(1));
                }

            }
        Collections.sort(listWords);
        System.out.println("Total number words = "+listWords.size());
        System.out.println(listWords);

    }

}
