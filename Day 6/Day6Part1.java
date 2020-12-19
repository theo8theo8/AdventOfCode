import java.io.*;
import java.util.*;

public class Day6Part1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int counter = 0;
        File file = new File("day6.txt");
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
            HashMap<Character, Character> hash = new HashMap<Character, Character>();
            for (int i = 0; i < s.length(); i++)
            {
                hash.put((Character)s.charAt(i), (Character)s.charAt(i));
            }
            counter += hash.size();
        }
        System.out.println("Counter: " + counter);
    }
}