package controllers.files;

import java.io.File;

/**
 * Actions for window Manager Dialog 
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public interface IActionDialog 
{
    enum TYPE_FILE { txt, text  }
    
     File openDialog() throws Exception;
     File saveDialog(  ) throws Exception;      
}
