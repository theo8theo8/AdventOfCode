import java.io.*;
import java.util.*;

public class Day9Part2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int crypt = 0;
        File file = new File("day9.txt");
        Scanner scan = new Scanner(file);        
        ArrayList<Integer> first25 = new ArrayList<Integer>();
        ArrayList<Integer> everything = new ArrayList<Integer>();
        
        for (int i = 0; i < 25; i++)
        {
            int a = scan.nextInt();
            first25.add(a);
            everything.add(a);
        }
        
        boolean works = false;
        while (scan.hasNextInt())
        {
            int input = scan.nextInt();
            everything.add(input);
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
                crypt = input;
            }
            works = false;
            first25.remove(0);
            first25.add(input);
        }
        
        int tmp = 0;
        ArrayList<Integer> tmpRn = new ArrayList<Integer>();
        int j = 0;
        while (true)
        {
            for (int i = j; i < everything.size(); i++)
            {
                
                if (tmp == crypt)
                {
                    System.out.println("OOGA: " + (Collections.min(tmpRn) + Collections.max(tmpRn)));
                    return;
                }else if (tmp > crypt)
                {
                    tmpRn = new ArrayList<Integer>();
                    tmp = 0;
                    j++;
                    break;
                }else
                {
                    tmp = tmp + everything.get(i);
                    tmpRn.add(everything.get(i));
                }
            }
        }
        
        
    }
}

