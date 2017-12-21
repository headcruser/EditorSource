package controllers.files;

import java.io.File;
import java.io.IOException;

/**
 * # Define a text file reader for Edirtor Source 
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public interface IReader 
{
    String readFile( final File nameFile) throws  IOException;   
}