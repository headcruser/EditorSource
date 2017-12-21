package controllers.files;

import java.io.File;
import java.io.IOException;

/**
 * # Writing in text File for editor Source
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
interface IWritter 
{
    void writterInFile( File file , final String inTextFile ) throws IOException;
}
