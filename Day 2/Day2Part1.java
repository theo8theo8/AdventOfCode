import java.io.*;
import java.util.*;

public class Day2Part1
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
            for (int i = 0; i < password.length(); i++)
            {
                if (password.charAt(i) == letter)
                {
                    count ++;
                }
            }
            if (count >= firstNum && count <= secNum)
            {
                counter ++;
            }
        }
        System.out.println("Counter: " + counter);
    }
}