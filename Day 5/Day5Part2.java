import java.io.*;
import java.util.*;
public class Day5Part2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<Integer> boardingPasses = new ArrayList<Integer>();
        File file = new File("day5.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine())
        {
            boardingPasses.add(checkPlace(scan.nextLine()));
        }
        Collections.sort(boardingPasses);
        for(int i = 1; i < boardingPasses.size(); i++)
        {
            if (boardingPasses.get(i-1) + 1 != boardingPasses.get(i))
            {
                System.out.println("My seat: " + (boardingPasses.get(i-1) + 1));
            }
        }
    }

    public static int checkPlace(String place)
    {
        String row = place.substring(0, 7);
        String column = place.substring(7);
        int change = 128;
        int start = 0;
        int end = 127;
        for (int i = 0; i < 7; i++) {
            change = change/2;
            if (row.charAt(i) == 'F') {
                end -= change;
            } else {
                start += change;
            }
        }
        int rowInt = start;
        
        change = 8;
        start = 0;
        end = 7;
        for (int i = 0; i < 3; i++) {
            change = change/2;
            if (column.charAt(i) == 'L') {
                end -= change;
            } else {
                start += change;
            }
        }
        int columnInt = start;
        
        int seatID = rowInt * 8 + columnInt;
        return seatID;
    }
}