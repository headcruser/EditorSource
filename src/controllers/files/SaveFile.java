/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SaveFile 
{
    
    public String readerFile(File pArchivo) throws Exception
    {
        if( !pArchivo.exists()  )
            throw new FileNotFoundException("El archivo no existe ");
         
        if( ! pArchivo.canRead() )
            throw new Exception(" No Tiene permisos de lectura ");
        
        return fileConverToString( pArchivo );
    } 
    
    
  private String fileConverToString( File fileReader) throws IOException
  {
      String delimiter = "\n"; 
      StringBuilder bufferString=new StringBuilder("");

       try ( Scanner scaner=new Scanner (new FileReader(fileReader))) 
       {
               while (scaner.hasNext() ) 
                   bufferString .append( scaner.nextLine() ).append(delimiter) ;
               
       }catch( IOException e){
            throw new IOException("Error de lectura ");
       }
      return bufferString.toString();
  }
         
 public void writingFile(final File  savedFile , final String info) throws FileNotFoundException
   {
       StringBuilder PATH = new StringBuilder( savedFile.getAbsolutePath() );
        
        try ( PrintWriter printwriter = new PrintWriter( savedFile ) ) 
        {
                    printwriter.print( info );
                    printwriter.close();
        }
        if(!(PATH.toString().endsWith(".edu")))
        {
            PATH.append(".edu");
            savedFile.renameTo(  new File(  PATH.toString() )  );
        }
   }
}
