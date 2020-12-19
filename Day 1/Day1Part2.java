import java.io.*;
import java.util.*;

public class Day1Part2
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
                for (int k: numbers)
                {
                    if (i+j+k == 2020)
                    {
                        counter = i*j*k;
                        break;
                    }
                }
            }
        }
        System.out.println("Counter: " + counter);
    }
}