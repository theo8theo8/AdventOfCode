import java.io.*;
import java.util.*;

public class Day9Part1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int counter = 0;
        File file = new File("day9.txt");
        Scanner scan = new Scanner(file);        
        ArrayList<Integer> first25 = new ArrayList<Integer>();
        //String tmpString = "";
        
        for (int i = 0; i < 25; i++)
        {
            first25.add(scan.nextInt());
        }
        
        boolean works = false;
        while (scan.hasNextInt())
        {
            int input = scan.nextInt();
            for (int i = 0; i < 25; i++)
            {
                for (int j = 0; j < 25; j++)
                {
                    if (input == first25.get(i) + first25.get(j))
                    {
                        works = true;
                    }
                }
            }
            if (!works)
            {
                System.out.println("Input: " + input);
            }
            works = false;
            first25.remove(0);
            first25.add(input);
        }
    }
}

