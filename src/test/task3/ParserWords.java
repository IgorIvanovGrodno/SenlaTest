/*
 * ParserWords
 *
 * The class reads a string from the console.
 * Then it counts and displays the number of words in the sentence on the console, sorts the words and displays them on the console with a uppercase first letter.
 *
 * Author: Igor Ivanov
 * E-mail: igor.ivanov.grodno@gmail.com
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

        //Read a line from the console
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Please, enter text");
                text = bufferedReader.readLine();

                //Check if the user entered an empty string
                if (!text.isEmpty()) break;
                else System.out.println("Tetx should not be empty");
            }

            parser(text);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * The method parses the words in the transmitted text. Counts their number, sorts and displays them on the console with a uppercase first letter
     *
     * @param text
     */
    public static void parser(String text) {
        if (text == null) return;
        ArrayList<String> listWords = new ArrayList<>();

        //Separate words
        String[] arrayWords = text.split(" ");

        for (String word : arrayWords) {

            //We remove punctuation marks at the beginning of the word and at the end (for example, there may be commas at the end of the word or quotation marks at the beginning and at the end)
            word = word.replaceAll("^\\p{Punct}+", "").replaceAll("\\p{Punct}+$", "");

            //We check whether the word is spelled correctly: whether there are numbers or punctuation marks in the word (except for the hyphen that can be found in complex words of Царь-пушка, etc .; and the apostrophe that occurs in English words)
            if (word.matches("[^\\d№\\p{Punct}]+[-']?[^\\d№\\p{Punct}]*")) {

                //If the word is spelled correctly, add it to the final list and make the first letter capital
                listWords.add(word.substring(0, 1).toUpperCase() + word.substring(1));
            }
        }
        Collections.sort(listWords);
        System.out.println("Total number words = " + listWords.size());
        System.out.println(listWords);

    }

}
