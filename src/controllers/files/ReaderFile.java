package controllers.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Reader Content to Files
 *
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public final class ReaderFile
        implements IReader, IPathFiles
{

    public ReaderFile()
    {
        super();
    }

    @Override
    public String readFile(File nameFile) throws IOException
    {
        return read(nameFile.getName());
    }

    private String read(String nameFile) throws IOException
    {
        final StringBuffer contentFileText = new StringBuffer(0);
        try (BufferedReader reader = Files.newBufferedReader(getPathFile(nameFile), Charset.defaultCharset()))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                contentFileText.append(line).append("\n");
            }

            return contentFileText.toString();
        } catch (IOException e)
        {
            throw new IOException(("ERROR DE LECTURA ".concat(e.getMessage())));
        }
    }

    public long numberLines( File nameFile )
    {
        long numLines;
        try (BufferedReader reader = Files.newBufferedReader(getPathFile(nameFile.getName()), Charset.defaultCharset()))
        {
            numLines = 0;

            while (reader.readLine() != null)
                numLines++;
            
            reader.close();
        } catch (IOException ex)
        {
            numLines = -1;
        }
        return numLines;
    }
}
