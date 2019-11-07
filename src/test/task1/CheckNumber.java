package test.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckNumber {

    public static void main(String[] args) {
        String inputData = null;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            inputData=bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int number= Integer.parseInt(inputData);
    }
}
