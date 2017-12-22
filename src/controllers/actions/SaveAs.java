package controllers.actions;

import controllers.files.FileManagerDialog;
import controllers.windowEditorController;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Button for Action Save As Document Editor
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class SaveAs extends Action
{
    private final windowEditorController wController;
    private final  FileManagerDialog _dialogFile;

    public SaveAs(windowEditorController controller) 
    {
        wController = controller;  
        _dialogFile=new FileManagerDialog( );
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        
        try 
        {
            File aux=_dialogFile.saveDialog();
            wController.writter.writterInFile( aux, wController.getView().getTextCode() );
             wController.getView().enableSaveButton(false);     
             wController.document=aux;
            
        } catch (Exception ex) {
        }
    }
}