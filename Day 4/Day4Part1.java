import java.io.*;
import java.util.*;

public class Day4Part1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int counter = 0;
        File file = new File("day4.txt");
        Scanner scan = new Scanner(file);        
        ArrayList<String> rows = new ArrayList<String>();
        String tmpString = "";
        while (scan.hasNextLine())
        {
            String inputString = scan.nextLine();
            if (inputString.length() == 0)
            {
                rows.add(tmpString);
                tmpString = "";
            }
            else
            {
                tmpString = tmpString.concat(inputString);
            }
        }
        rows.add(tmpString);
        
        for (String s: rows)
        {
            if (s.contains("byr") && s.contains("iyr") && s.contains("eyr") && s.contains("hgt") && s.contains("hcl") && s.contains("ecl") && s.contains("pid"))
            {
                counter++;
            }
        }
        System.out.println("Counter: " + counter);
    }
}