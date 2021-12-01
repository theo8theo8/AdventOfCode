import java.io.*;
import java.util.*;

public class Day6Part2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int counter = 0;
        File file = new File("day6.txt");
        Scanner scan = new Scanner(file);        
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmpString = new ArrayList<String>();
        while (scan.hasNextLine())
        {
            String inputString = scan.nextLine();
            if (inputString.length() == 0)
            {
                rows.add(tmpString);
                tmpString = new ArrayList<String>();
            }
            else
            {
                tmpString.add(inputString);
            }
        }
        rows.add(tmpString);
        
        for (ArrayList<String> s: rows)
        {
            HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
            for (String t: s)
            {
                for (int i = 0; i < t.length(); i++)
                {
                    int currentVal = 0;
                    if (hash.containsKey(t.charAt(i)))
                    {
                        currentVal = hash.get(t.charAt(i));
                    }
                    hash.put ((Character)t.charAt(i), currentVal+1);
                }
                
            }
            
            Collection<Integer> values = hash.values();
            for (Integer i: values)
            {
                if (i == s.size())
                {
                    counter++;
                }
            }
        }
        System.out.println("Counter: " + counter);
    }
}