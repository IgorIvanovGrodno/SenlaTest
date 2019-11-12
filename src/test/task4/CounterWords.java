/*
 * CounterWords
 * The class reads text from the console and the search word.
 * Then it counts and displays on the console how many times a given word occurs in the text, not case sensitive.
 *
 * Author: Igor Ivanov
 * E-mail: igor.ivanov.grodno@gmail.com
 * */
package test.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CounterWords {

    public static void main(String[] args) {
        String text = null;
        String pattern = null;

        //We read the text and the word to search from the console
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Please, enter text");
                text = bufferedReader.readLine();
                System.out.println("Please, enter pattern word for count");
                pattern = bufferedReader.readLine();

                //Check if user entered empty lines
                if (!(text.isEmpty() || pattern.isEmpty())) break;
                else System.out.println("Text and pattern should not be empty");
            }

            System.out.println("Word repeat " + countWord(text, pattern));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * The method takes the text and the word to search and returns how many times the word occurs in the text
     *
     * @param text
     * @param pattern
     * @return int
     */
    public static int countWord(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        String[] arr = ("  " + text + "  ").toLowerCase().split("[\\p{Space}\\p{Punct}]" + pattern.toLowerCase() + "[\\p{Space}\\p{Punct}]");
        return arr.length - 1;

    }
}
