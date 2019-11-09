package test.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CounterWords {

    public static void main(String[] args) {
        String text = null;
        String pattern = null;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            while(true) {
                System.out.println("Please, enter text");
                text = bufferedReader.readLine();
                System.out.println("Please, enter pattern word for count");
                pattern = bufferedReader.readLine();
                if(!(text.isEmpty()&pattern.isEmpty())) break;
                else System.out.println("Tetx and pattern should not be empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Word repeat "+countWord(text, pattern));
    }

    public static int countWord(String text, String pattern){
        text=text.replaceAll("\\p{Punct}", "").toLowerCase();
        text = " "+text+" ";
        pattern =" "+pattern.toLowerCase()+" ";
        int count = 0;

        int index = text.indexOf(pattern);

        while (index >= 0) {
            count++;
            index = text.indexOf(pattern, index + 1);
        }
        return count;
    }
}