import java.io.*;
import java.util.*;
public class Day12Part2
{
    private static int posSN;
    private static int posWE;
    private static int wayPosSN;
    private static int wayPosWE;
    //private static int facing;
    
    public static void main(String[] args) throws FileNotFoundException
    {
        posSN = 0;
        posWE = 0;
        wayPosSN = 1;
        wayPosWE = 10;
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
        char op = change.charAt(0);
        int value = Integer.parseInt(change.substring(1));
        
        switch(op) {
            case 'N':
                wayPosSN += value;
                break;
            case 'S':
                wayPosSN -= value;
                break;
            case 'E':
                wayPosWE += value;
                break;
            case 'W':
                wayPosWE -= value;
                break;
            case 'L':
                value = value % 360;
                switch(value) {
                    case 0:
                        break;
                    case 90:
                        int tmp = wayPosSN;
                        wayPosSN = wayPosWE;
                        wayPosWE = -tmp;
                        break;
                    case 180:
                        wayPosSN = -wayPosSN;
                        wayPosWE = -wayPosWE;
                        break;
                    case 270:
                        int tmp2 = wayPosSN;
                        wayPosSN = -wayPosWE;
                        wayPosWE = tmp2;
                        break;
                    default:
                }
                break;
            case 'R':
                value = value % 360;
                switch(value) {
                    case 0:
                        break;
                    case 90:
                        int tmp = wayPosSN;
                        wayPosSN = -wayPosWE;
                        wayPosWE = tmp;
                        break;
                    case 180:
                        wayPosSN = -wayPosSN;
                        wayPosWE = -wayPosWE;
                        break;
                    case 270:
                        int tmp2 = wayPosSN;
                        wayPosSN = wayPosWE;
                        wayPosWE = -tmp2;
                        break;
                    default:
                }
                break;
            case 'F':
                posSN += wayPosSN*value;
                posWE += wayPosWE*value;
                break;
            default:
        }
    }
}