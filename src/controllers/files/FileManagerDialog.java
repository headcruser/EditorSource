package controllers.files;

import java.io.File;
import javax.swing.JFileChooser;

public class FileManagerDialog extends JFileChooser implements IActionDialog, IPathFiles
{  
    public FileManagerDialog() {    super( WORKSPACE );     }
    
    @Override
    public File openDialog() throws Exception
    {
        setDialogType ( OPEN_DIALOG  );
        setFileFilter ( EXT );

           if ( ! isChooserValidDialogOpen()  ) 
               throw  new Exception( " Calceled" );            

           if ( ! getSelectedFile().exists() )
               throw  new Exception(  "It File not Exist " );

           return getSelectedFile();     
    }

    @Override
   public File saveDialog(  ) throws Exception
   {
        setDialogType( SAVE_DIALOG );
        setFileFilter( EXT );
        
        if( ! isChooserValidDialogSave() )
           throw new Exception( "Canceled" );
       
        return this.getSelectedFile() ;
   }
   
   private boolean isChooserValidDialogSave() { return showSaveDialog( null ) == APPROVE_OPTION ;   }
   
   private boolean isChooserValidDialogOpen() { return showOpenDialog(null ) == APPROVE_OPTION ;    }
}