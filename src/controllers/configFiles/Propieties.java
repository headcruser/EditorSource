package controllers.configFiles;
import controllers.console.Console;
import controllers.files.IPathFiles;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * Loader Properties for the system
 * @author Daniel Martinez  <headcruser at gmail.com>
 */
public final class Propieties implements IPathFiles
{
    private Propieties() { super(); }

    public static final void loader( ) throws Exception
    {
            try ( FileInputStream propFile = new FileInputStream( FILE_CONFIGURATION)  )
            {
                Properties p = new Properties( System.getProperties() );
                p.load( propFile );
                System.setProperties( p );
            } catch ( FileNotFoundException n ) {
                 throw new FileNotFoundException( " file not Foutd, check File Configutation" );
            } catch (IOException w) {
                throw  new IOException( " Fail Reader File Configuration" );
            }
           Console.print( "SUCCESSFUL FILE CONFIGURATION" );
    }
}