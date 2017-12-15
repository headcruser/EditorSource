package controllers.utils;

import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Out Writes Message in PrinterConsoleUtils text
 * @author Daniel Martinez<headcruser at gmail.com>
 */
public final class PrinterConsoleUtils  
{
    private static PrinterConsoleUtils __instance=null;
    private PrinterConsoleUtils(){}
   
    public static synchronized PrinterConsoleUtils getInstance() {
        if( __instance == null ) 
            __instance = new PrinterConsoleUtils();
        
        return __instance;
    }
    
    public static final void  print(  final String message )
    {
        new PrintWriter ( System.out, true ).println( message);
    }
  
    public static  final void printArray( final Object valores[] )
    {
         print( Arrays.toString( valores ) );
    }
}