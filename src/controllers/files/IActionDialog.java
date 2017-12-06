package controllers.files;

import java.io.File;

/**
 * Actions for window Manager Dialog 
 * @autor Daniel Martinez Sierra 
 */
interface IActionDialog 
{
    static final String MAIN_DIRECTORY=".";
    enum TYPE_FILE { txt, text  }
    
     File openDialog() throws Exception;
     File saveDialog(  ) throws Exception;      
}
