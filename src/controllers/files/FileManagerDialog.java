package controllers.files;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileManagerDialog extends JFileChooser
{
    private enum TYPE_FILE 
    {
        txt,text
     }
    public FileManagerDialog() {
        super(".");
    }
    
    public File openDialog() throws Exception
    {
        setDialogType ( OPEN_DIALOG  );
        setFileFilter ( new FileNameExtensionFilter( "Archivo de texto", TYPE_FILE.txt.toString(),  TYPE_FILE.text.toString() ) );

           if ( ! isChooserValidDialogOpen()  ) 
               throw  new Exception(" Cancelo el archivo " );            

           if ( ! getSelectedFile().exists() )
               throw  new Exception( "No selecciono nada" );

           return getSelectedFile();     
    }

   public File saveDialog(  ) throws Exception
   {
        setDialogType( SAVE_DIALOG );
        setFileFilter( new FileNameExtensionFilter( "todos los archivos *.EDU", TYPE_FILE.txt.toString(),  TYPE_FILE.text.toString() ) );
        
        if( ! isChooserValidDialogSave() )
           throw new Exception("Cancelar..");
       
        return this.getSelectedFile() ;
   }
   
   private boolean isChooserValidDialogSave()
   {
        return showSaveDialog( null ) == APPROVE_OPTION ;
   }
   
   private boolean isChooserValidDialogOpen()
   {
        return showOpenDialog(null ) == APPROVE_OPTION ;
   }
}
