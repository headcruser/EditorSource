package controllers.files;

import java.io.IOException;

/**
 * # Writing in text File for editor Source
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
interface IWritter 
{
    void writterInFile(final String inTextFile ) throws IOException;
}
