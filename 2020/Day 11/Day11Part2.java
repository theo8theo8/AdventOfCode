import java.io.*;
import java.util.*;
public class Day11Part2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int counter = 0;
        ArrayList<ArrayList<Character>> seats = new ArrayList<ArrayList<Character>>();
        File file = new File("day11.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine())
        {
            ArrayList<Character> row = new ArrayList<Character>();
            String input = scan.nextLine();
            for (int i= 0; i < input.length(); i++)
            {
                row.add(input.charAt(i));
            }
            seats.add(row);
        }

        while(!seats.equals(seats = iterate(seats))){
        }
        for (int i = 0; i < seats.size(); i++)
        {
            for (int j = 0; j < seats.get(i).size(); j++)
            {
                if (seats.get(i).get(j).equals('#')){
                    counter++;
                }
            }
        }
        System.out.println("Cidfs¨fesi: " + counter);
    }
    
    public static ArrayList<ArrayList<Character>> iterate(ArrayList<ArrayList<Character>> seats)
    {
        ArrayList<ArrayList<Character>> newSeats = new ArrayList<ArrayList<Character>>();
        for (int i = 0; i < seats.size(); i++)
        {
            newSeats.add(new ArrayList<Character>());
            for (int j = 0; j < seats.get(i).size(); j++)
            {   
                newSeats.get(i).add(seats.get(i).get(j));
                if (seats.get(i).get(j).equals('L'))
                {
                    int totOcc = 0;
                    List<Character> fHalf = seats.get(i).subList(0, j);
                    List<Character> sHalf = seats.get(i).subList(j+1, seats.get(i).size());
                    
                    ArrayList<Character> revLHalf = new ArrayList<Character>();
                    for (int e = fHalf.size()-1; e >= 0; e--)
                    {
                        revLHalf.add(fHalf.get(e));
                    }
                    
                    totOcc += (checkSubRow(revLHalf) + checkSubRow(sHalf));
                    
                    fHalf = new ArrayList<Character>();
                    sHalf = new ArrayList<Character>();
                    for (int k = i-1; k >= 0; k--)
                    {
                        fHalf.add(seats.get(k).get(j));
                    }
                    for (int k = i+1; k < seats.size(); k++)
                    {
                        sHalf.add(seats.get(k).get(j));
                    }
                    totOcc += (checkSubRow(fHalf) + checkSubRow(sHalf));
                    
                    fHalf = new ArrayList<Character>();
                    sHalf = new ArrayList<Character>();
                    int l = j-1;
                    int r = j+1;
                    for (int k = i-1; k >= 0; k--)
                    {
                        if (l >= 0)
                        {
                            fHalf.add(seats.get(k).get(l));
                        }
                        if (r < seats.get(k).size())
                        sHalf.add(seats.get(k).get(r));
                        l--;
                        r++;
                    }
                    totOcc += (checkSubRow(fHalf) + checkSubRow(sHalf));
                    
                    fHalf = new ArrayList<Character>();
                    sHalf = new ArrayList<Character>();
                    l = j-1;
                    r = j+1;
                    for (int k = i+1; k < seats.size(); k++)
                    {
                        if (l >= 0)
                        {
                            fHalf.add(seats.get(k).get(l));
                        }
                        if (r < seats.get(k).size())
                        sHalf.add(seats.get(k).get(r));
                        l--;
                        r++;
                    }
                    totOcc += (checkSubRow(fHalf) + checkSubRow(sHalf));
                    
                    if (totOcc == 0)
                    {
                        newSeats.get(i).set(j, '#');
                    }
                    
                } else if (seats.get(i).get(j).equals('#'))
                {
                    int totOcc = 0;
                    List<Character> fHalf = seats.get(i).subList(0, j);
                    List<Character> sHalf = seats.get(i).subList(j+1, seats.get(i).size());
                    // System.out.println(sHalf);
                    ArrayList<Character> revLHalf = new ArrayList<Character>();
                    for (int e = fHalf.size()-1; e >= 0; e--)
                    {
                        revLHalf.add(fHalf.get(e));
                    }
                    
                    totOcc += (checkSubRow(revLHalf) + checkSubRow(sHalf));
                    
                    fHalf = new ArrayList<Character>();
                    sHalf = new ArrayList<Character>();
                    for (int k = i-1; k >= 0; k--)
                    {
                        fHalf.add(seats.get(k).get(j));
                    }
                    for (int k = i+1; k < seats.size(); k++)
                    {
                        sHalf.add(seats.get(k).get(j));
                    }
                    totOcc += (checkSubRow(fHalf) + checkSubRow(sHalf));
                    
                    fHalf = new ArrayList<Character>();
                    sHalf = new ArrayList<Character>();
                    int l = j-1;
                    int r = j+1;
                    for (int k = i-1; k >= 0; k--)
                    {
                        if (l >= 0)
                        {
                            fHalf.add(seats.get(k).get(l));
                        }
                        if (r < seats.get(k).size())
                        sHalf.add(seats.get(k).get(r));
                        l--;
                        r++;
                    }
                    totOcc += (checkSubRow(fHalf) + checkSubRow(sHalf));
                    
                    fHalf = new ArrayList<Character>();
                    sHalf = new ArrayList<Character>();
                    l = j-1;
                    r = j+1;
                    for (int k = i+1; k < seats.size(); k++)
                    {
                        if (l >= 0)
                        {
                            fHalf.add(seats.get(k).get(l));
                        }
                        if (r < seats.get(k).size())
                        sHalf.add(seats.get(k).get(r));
                        l--;
                        r++;
                    }
                    totOcc += (checkSubRow(fHalf) + checkSubRow(sHalf));
                    if ((totOcc) >= 5)
                    {
                        newSeats.get(i).set(j, 'L');
                    }
                }
            }
        }
        return newSeats;
    }
    
    public static int checkSubRow (List<Character> row)
    {
        for (int i = 0; i < row.size(); i++)
        {
            if (row.get(i).equals('L'))
            {
                return 0;
            }else if (row.get(i).equals('#'))
            {
                return 1;
            }
        }
        return 0;
    }
}