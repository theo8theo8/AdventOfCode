import java.io.*;
import java.util.*;

public class Day2Part2 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int counter = 0;
        File file = new File("day2.txt");
        Scanner scan = new Scanner(file);        
        String inputString = "";
        while (scan.hasNextLine())
        {
            inputString = scan.nextLine();
            int firstNum = Integer.parseInt(inputString.split("\\-", 0)[0]);
            int secNum = Integer.parseInt(inputString.split("\\-", 0)[1].split(" ", 0)[0]);
            char letter = inputString.split(" ", 0)[1].charAt(0);
            String password = inputString.split(" ", 0)[2];
            
            int count = 0;
            if (password.charAt(firstNum-1) == letter ^ password.charAt(secNum-1) == letter)
            {
                counter++;
            }
        }
        System.out.println("Counter part 2: " + counter);
    }
}