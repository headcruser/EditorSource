package controllers.files;

import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Actions for window Manager Dialog 
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public interface IActionDialog 
{
    static final FileNameExtensionFilter EXT = 
            new FileNameExtensionFilter( "Files txt", TYPE_FILE.txt.toString(),  TYPE_FILE.text.toString() );
    
    enum TYPE_FILE { txt, text  }
    
     File openDialog() throws Exception;
     File saveDialog(  ) throws Exception; 
     
}
