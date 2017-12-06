package controllers.files;

import java.io.BufferedWriter;
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
 * This Class Can Writter In File Textr
 * 
 */
public class WritterInFile implements IWritter, IWorkSpace
{         
    private final String nameFile;
    
    public WritterInFile(final String fileToWriting) 
    {
         nameFile=fileToWriting.trim();
    }

    @Override
    public final void writterInFile( final String informationToFile) throws IOException 
    {
        if( nameFile.isEmpty() || nameFile.equals("") || nameFile==null)
            throw new IOException(" Especifica un nombre para el archivo ");
        
        List<String > LineProcessed=processLine( informationToFile );
        writeLargerTextFile( LineProcessed );
    }  
    
    private  List<String> processLine(String aLine)
    {
      Scanner scanner = new Scanner(aLine);
      scanner.useDelimiter("\n");
       
       List<String> lines= new ArrayList<>( 0 );
        
      while (scanner.hasNext())
        lines.add(  scanner.next());
    
      return lines;
  }
 
private void writeLargerTextFile(List<String> aLines) 
               throws IOException 
       {	

        try (BufferedWriter writer = Files.newBufferedWriter( getPath( nameFile )  , Charset .defaultCharset(),
                                                                                                                              StandardOpenOption.WRITE ,
                                                                                                                              StandardOpenOption.CREATE ,
                                                                                                                              StandardOpenOption.TRUNCATE_EXISTING) )
        {

            for(String line : aLines){
              writer.write(line);
              writer.newLine();
            }

        }catch( IOException e){ throw  new IOException( " Error de Escritura" );}	
    }
    
    private Path getPath( final String fileToRead )
    {
            return  Paths.get( new StringBuilder( WORKSPACE ).append( fileToRead ).toString() );            
    }
    
    //For Files  very Small
    void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException 
    {
          Path path = Paths.get(aFileName);
          Files.write(path, aLines);
    }
}