import java.io.*;
import java.util.*;
/**
 * Write a description of class ReadFile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReadFromFile
{
    public static String[] readFile(String pathOfFile) 
    {
        try
        {
            File f = new File(pathOfFile);

            Scanner sc = new Scanner( f );
            
            String lines[] = new String[1000];
            
            int logicalSize = 0;
            
            while( sc.hasNext() )
            {
                lines[logicalSize] = sc.nextLine();
                logicalSize++;
            }
            
            String arrayToReturn[] = new String[logicalSize];
            
            for(int i = 0;i<logicalSize;i++ )
            {
                 arrayToReturn[i] = lines[i];
            } 
            
            sc.close();
            return arrayToReturn;
        }
        catch( Exception e )
        {
            System.out.println("This file does not exist!");
            System.out.println( e );
            return null;
        }
        
    }

}