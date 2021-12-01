import java.io.*;
import java.util.*;

public class Day3Part1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int counter = 0;
        int pos = 0;
        int lineSize = 30; //30 max index
        File file = new File("day3.txt");
        Scanner scan = new Scanner(file);        
        String rowString = "";
        scan.nextLine();
        while (scan.hasNextLine())
        {
            rowString = scan.nextLine();
            pos += 3;
            if (pos > lineSize)
            {
                pos = pos - lineSize - 1;
            }
            if (rowString.charAt(pos) == '#')
            {
                counter ++;
            }
        }
        System.out.println("Counter: " + counter);
    }
}