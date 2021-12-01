import java.io.*;
import java.util.*;

public class Day3Part2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        long total = algorithm(1, 1) * algorithm(1, 3) * algorithm(1, 5) * algorithm(1, 7) * algorithm(2, 1);
        System.out.println("Total: " + total);
    }
    
    public static long algorithm(int downSteps, int sideSteps) throws FileNotFoundException
    {
        int counter = 0;
        int pos = 0;
        int lineSize = 30; //30 max index
        File file = new File("day3.txt");
        Scanner scan = new Scanner(file);
        ArrayList<String> rows = new ArrayList<String>();
        while (scan.hasNextLine())
        {
            rows.add(scan.nextLine());
        }
        
        int linePos = downSteps;
        for (int i = linePos; i < rows.size();)
        {
            pos += sideSteps;
            if (pos > lineSize)
            {
                pos = pos - lineSize - 1;
            }
            if (rows.get(i).charAt(pos) == '#')
            {
                counter ++;
            }
            
            i += downSteps;
        }
        System.out.println("Count: " + counter);
        return (long)counter;
    }
}