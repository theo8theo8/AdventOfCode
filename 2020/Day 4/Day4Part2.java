import java.io.*;
import java.util.*;
public class Day4Part2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int counter = 0;
        File file = new File("day4.txt");
        Scanner scan = new Scanner(file);
        String tmpString = "";
        while (scan.hasNextLine())
        {
            String inputString = scan.nextLine();
            if (inputString.length() == 0)
            {
                if (checkPassport(tmpString))
                {
                    counter ++;
                }
                tmpString = "";
            }
            else
            {
                tmpString = tmpString.concat(" ");
                tmpString = tmpString.concat(inputString);
            }
        }
        if (checkPassport(tmpString))
        {
            counter ++;
        }
        System.out.println("Countewrer: " + counter);
    }
    
    public static boolean checkPassport(String pass)
    {
        if (pass.contains("byr") && pass.contains("iyr") && pass.contains("eyr") && pass.contains("hgt") && pass.contains("hcl") && pass.contains("ecl") && pass.contains("pid"))
        {
            String[] parts = pass.split(" ");
            for (String part: parts)
            {
                
                String[] key = part.split(":");
                if (key[0].equals("byr"))
                {
                    int value = Integer.parseInt(key[1]);
                    if (value <= 2002 && value >= 1920)
                    {
                        continue;
                        
                    }else
                    {
                        return false;
                    }
                }else if (key[0].equals("iyr"))
                {
                    int value = Integer.parseInt(key[1]);
                    if (value <= 2020 && value >= 2010)
                    {
                        continue;
                    }else
                    {
                        return false;
                    }
                }else if (key[0].equals("eyr"))
                {
                    int value = Integer.parseInt(key[1]);
                    if (value <= 2030 && value >= 2020)
                    {
                        continue;
                    }else
                    {
                        return false;
                    }
                }else if (key[0].equals("hgt"))
                {
                    int length = key[1].length();
                    if (key[1].endsWith("in") || key[1].endsWith("cm"))
                    {
                        int value = Integer.parseInt(key[1].substring(0, length-2));
                        
                        if (key[1].endsWith("in"))
                        {
                            if (value <= 76 && value >= 59)
                            {
                                continue;
                            }
                            else
                            {
                                return false;
                            }
                            
                        }else if (key[1].endsWith("cm"))
                        {
                            if (value <= 193 && value >= 150)
                            {
                                continue;
                            }
                            else
                            {
                                return false;
                            }
                        }
                    }else
                    {
                        System.out.println("1");
                        return false;
                    }
                }else if (key[0].equals("hcl"))
                {
                    if (key[1].charAt(0) == '#')
                    {
                        String color = key[1].substring(1, key[1].length());
                        if (color.length() == 6)
                        {
                            for (int i = 0; i < color.length(); i++)
                            {
                                int thisChar = (int)color.charAt(i);
                                if ((thisChar <= 57 && thisChar >= 48) || (thisChar <= 102 && thisChar >= 97))
                                {
                                    continue;
                                }
                                else
                                {
                                    return false;
                                }
                            }
                        }else
                        {   
                            System.out.println("2");
                            return false;
                        }
                    }else
                    {
                        System.out.println("3");
                        return false;
                    }
                }else if (key[0].equals("ecl"))
                {
                    if (key[1].equals("amb") ^ key[1].equals("blu") ^ key[1].equals("brn") ^ key[1].equals("gry") ^ key[1].equals("grn") ^ key[1].equals("hzl") ^ key[1].equals("oth"))
                    {
                        continue;
                    }
                    else
                    {
                        return false;
                    }
                }else if (key[0].equals("pid"))
                {
                    String code = key[1].substring(0, key[1].length());
                    
                    if (code.length() == 9)
                    {
                        for (int i = 0; i < code.length(); i++)
                        {
                            int thisChar = (int)code.charAt(i);
                            if ((thisChar <= 57 && thisChar >= 48))
                            {
                                continue;
                            }
                            else
                            {
                                return false;
                            }
                        }
                    } else
                    {
                        return false;
                    }
                }else
                {
                    continue;
                }
            }
            return true;
        }
        return false;
    }
}