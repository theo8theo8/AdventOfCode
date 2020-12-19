import java.io.*;
import java.util.*;
public class Day11Part1
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

        while(!seats.equals(seats = iterate(seats))){}
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
                    int preRow = 0;
                    int thisRow = 0;
                    int nextRow = 0;
                    if (i == 0)
                    {
                        thisRow = iterateHelp(seats.get(i), j);
                        nextRow = iterateHelp(seats.get(i+1), j);
                    } else if (i == seats.size()-1)
                    {
                        preRow = iterateHelp(seats.get(i-1), j);
                        thisRow = iterateHelp(seats.get(i), j);
                    } else 
                    {
                        preRow = iterateHelp(seats.get(i-1), j);
                        thisRow = iterateHelp(seats.get(i), j);
                        nextRow = iterateHelp(seats.get(i+1), j);
                    }
                    
                    if ((preRow + thisRow + nextRow) == 0)
                    {
                        newSeats.get(i).set(j, '#');
                    }
                    
                } else if (seats.get(i).get(j).equals('#'))
                {
                    int preRow = 0;
                    int thisRow = 0;
                    int nextRow = 0;
                    if (i == 0)
                    {
                        thisRow = iterateHelp(seats.get(i), j);
                        nextRow = iterateHelp(seats.get(i+1), j);
                    } else if (i == seats.size()-1)
                    {
                        preRow = iterateHelp(seats.get(i-1), j);
                        thisRow = iterateHelp(seats.get(i), j);
                    } else 
                    {
                        preRow = iterateHelp(seats.get(i-1), j);
                        thisRow = iterateHelp(seats.get(i), j);
                        nextRow = iterateHelp(seats.get(i+1), j);
                    }
                    
                    if ((preRow + thisRow + nextRow-1) >= 4)
                    {
                        newSeats.get(i).set(j, 'L');
                    }
                }
            }
        }
        return newSeats;
    }
    
    public static int iterateHelp (ArrayList<Character> row, int seatPos)
    {
        int counter = 0;
        if (seatPos == 0)
        {   
            for (int i = seatPos; i < seatPos+2; i++) {
            if (row.get(i) == '#') {
                counter ++;
            }}
            
        } else if (seatPos == row.size()-1)
        {
            for (int i = seatPos-1; i < seatPos+1; i++) {
            if (row.get(i) == '#') {
                counter ++;
            }}
        }else
        {
            for (int i = seatPos-1; i < seatPos+2; i++) {
            if (row.get(i) == '#') {
                counter ++;
            }}
        }
        
        return counter;
    }
}