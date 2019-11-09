package test.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ParserWords {
    public static void main(String[] args) {
        String text = null;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            while(true) {
                System.out.println("Please, enter text");
                text = bufferedReader.readLine();
                if(!text.isEmpty()) break;
                else System.out.println("Tetx should not be empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       parser(text);
    }

    public static void parser(String text){

        //Delete punctuation and make all words to lower case
        String buffer = text.replaceAll("\\p{Punct}", "").toLowerCase();


        String[] arrayWords = buffer.split(" ");
        Arrays.sort(arrayWords);
        for(String s: arrayWords){
            if(s.matches("[^0-9]+")) System.out.println(s.substring(0,1).toUpperCase()+s.substring(1));
        }
    }

}
