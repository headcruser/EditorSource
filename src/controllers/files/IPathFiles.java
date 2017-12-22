package controllers.files;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Paths and Files for the system
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public interface IPathFiles 
{
    public static final String FILE_CONFIGURATION=".\\sources\\config\\config.properties";
    public static final String WORKSPACE=".\\sources\\workspace\\";
    public static final String ICON_LOGO="/icons/logo.png";
    public static final String MAIN_DIRECTORY=".";
    
    default  Path getPathFile(final String fileToRead)
    {
        return Paths.get( new StringBuilder( WORKSPACE ).append( fileToRead ).toString());
    }
}