package controllers.console;

import java.io.PrintWriter;

/**
 * Out Writes Message in Console text
 * @author Daniel Martinez<headcruser at gmail.com>
 */
public final class Console  
{
    public static final void  print( final String message)
    {
        new PrintWriter ( System.out, true ).println( message);
    }
}