package controllers.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This Class Can Writter In File Text
 *
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class WritterInFile
        implements IWritter, IPathFiles
{
    @Override
    public final void writterInFile(File myfile, final String informationToFile) throws
            IOException
    {
        if( myfile == null || myfile.exists() )
            throw new IOException( "File No exists" );

        List<String> LineProcessed = processLine(informationToFile);
        writeLargerTextFile( myfile, LineProcessed );
    }

    private List<String> processLine( String aLine )
    {
        Scanner scanner = new Scanner(aLine);
        scanner.useDelimiter("\n");

        List<String> lines = new ArrayList<>( 0 );

        while ( scanner.hasNext() )
            lines.add( scanner.next() );
        
        return lines;
    }

    private void writeLargerTextFile(File nameFile, List<String> aLines)
            throws IOException
    {

        try (BufferedWriter writer = Files.newBufferedWriter(
                getPathFile(nameFile.getName()), Charset.defaultCharset(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING))
        {

            if (aLines.size() == 1)
            {
                writer.write(aLines.get(0));
            } else
            {
                for (String line : aLines)
                {
                    writer.write(line);
                    writer.newLine();
                }
            }

        } catch (IOException e)
        {
            throw new IOException(" Error de Escritura");
        }
    }

    //For Files  very Small
    void writeSmallTextFile(List<String> aLines, String aFileName) throws
            IOException
    {
        Path path = Paths.get(aFileName);
        Files.write(path, aLines);
    }
}