import java.io.*;
import java.util.*;
public class Day12Part1
{
    private static int posSN;
    private static int posWE;
    private static int facing;
    
    public static void main(String[] args) throws FileNotFoundException
    {
        posSN = 0;
        posWE = 0;
        facing = 90;
        File file = new File("day12.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine())
        {
            changePos(scan.nextLine());
        }
        
        int sum = Math.abs(posSN) + Math.abs(posWE);
        System.out.println("This: " + sum);
    }
    
    public static void changePos(String change)
    {
        if (facing < 0)
        {
            facing = 360 + facing;
        }
        facing = facing % 360;
        char op = change.charAt(0);
        int value = Integer.parseInt(change.substring(1));
        
        switch(op) {
            case 'N':
                posSN += value;
                break;
            case 'S':
                posSN -= value;
                break;
            case 'E':
                posWE += value;
                break;
            case 'W':
                posWE -= value;
                break;
            case 'L':
                facing -= value;
                break;
            case 'R':
                facing += value;
                break;
            case 'F':
                switch(facing) {
                    case 0:
                        System.out.println("N"+value);
                        changePos("N"+value);
                        break;
                    case 90:
                        System.out.println("E"+value);
                        changePos("E"+value);
                        break;
                    case 180:
                        System.out.println("S"+value);
                        changePos("S"+value);
                        break;
                    case 270:
                        System.out.println("W"+value);
                        changePos("W"+value);
                        break;
                    default:
                }
                break;
            default:
        }
    }
}