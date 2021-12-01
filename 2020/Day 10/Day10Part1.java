import java.io.*;
import java.util.*;

public class Day10Part1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("day10.txt");
        Scanner scan = new Scanner(file);        
        ArrayList<Integer> adapters = new ArrayList<Integer>();
        while (scan.hasNextInt())
        {
            adapters.add(scan.nextInt());
        }
        Collections.sort(adapters);
        
        System.out.println("" + adapters);
        
        int diffOne = 0;
        int diffThree = 0;
        int currentJolt = 0;
        for (int i: adapters)
        {
            if (i - currentJolt == 1)
            {
                diffOne++;
            }else if (i - currentJolt == 3)
            {
                diffThree++;
            }
            currentJolt = i;
        }
        diffThree++;
        System.out.println("1: " + diffOne + " 3: " + diffThree);
        System.out.println("Hej: " + diffOne*diffThree);
    }
}

