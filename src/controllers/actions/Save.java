package controllers.actions;

import controllers.files.FileManagerDialog;
import controllers.windowEditorController;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Button for Action Save Document
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class Save extends Action
{
    private final windowEditorController _wController;
    private final  FileManagerDialog _dialogFile;

    public Save(windowEditorController controller) 
    {
        _wController = controller;  
        _dialogFile=new FileManagerDialog( );
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {        
        try 
        {
            File aux=_wController.document;
            _wController.writter.writterInFile( aux, _wController.getView().getTextCode() );
             _wController.getView().buttonSave.setEnabled( false );     
             
        } catch (Exception ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }
                      
//        wController.getOriginator().set( codeInTextCode );        
//        wController.getCareTaker().addMemento( wController.getOriginator().storeInMomento() );
//        wController.increaseArticle();
//        wController.increaseSaveFiles();
//        wController.getView().enableUndoButton( true );        
    }
}