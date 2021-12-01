import java.io.*;
import java.util.*;

public class Day1Part1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int counter = 0;
        File file = new File("day1.txt");
        Scanner scan = new Scanner(file);        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (scan.hasNextInt())
        {
            numbers.add(scan.nextInt());
        }
        
        for (int i: numbers)
        {
            for (int j: numbers)
            {
                if (i+j == 2020)
                {
                    counter = i*j;
                    break;
                }
            }
        }
        
        System.out.println("Counter: " + counter);
    }
}