package controllers.files;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Reader Content to Files
 * 
 */
public class ReaderFile implements IReader, IWorkSpace
{
    //./sources/workspace/ejemplo.txt
    private final StringBuffer contentFileText;
    private final String nameFile;
    private long numLines;

    public ReaderFile(String ReadToFile) 
    {
        contentFileText=new StringBuffer(0);
        nameFile=ReadToFile;
        numLines=0;
    }
    
    @Override
    public void readFile() throws IOException 
    {        
        try (BufferedReader reader = Files.newBufferedReader( getPath( nameFile ), Charset.defaultCharset() ) ) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
                contentFileText.append(line).append("\n");
            
            reader.close();
        }
        catch (IOException e) 
        {
           throw new IOException(( "ERROR DE LECTURA ".concat(e.getMessage() )));
        }
    }
    
    private Path getPath( final String fileToRead )
    {
            return  Paths.get( new StringBuilder( WORKSPACE ).append( fileToRead ).toString() );            
    }
    
    public long numberLines()
    {
        try (BufferedReader reader = Files.newBufferedReader( getPath( nameFile ), Charset.defaultCharset() ) )  
        {    
            numLines=0;
            
            while ( reader.readLine () != null )
                numLines++;
           
            reader.close();
        } catch (IOException ex) {
            numLines=-1;
        }
        return numLines;
    }
    
    public String printInfoFile()
    {
            return contentFileText.toString();
    }

}