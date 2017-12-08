package controllers.buttons;

import controllers.windowEditorController;
import java.awt.event.ActionEvent;

/**
 * Button for Action Save Document
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class SaveButtonListener extends ButtonListener
{
    private final windowEditorController wController;

    public SaveButtonListener(windowEditorController controller) 
    {
        this.wController = controller;       
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        String codeInTextCode=wController.getView().getTextCode();        
        wController.getOriginator().set( codeInTextCode );        
        wController.getCareTaker().addMemento( wController.getOriginator().storeInMomento() );
        wController.increaseArticle();
        wController.increaseSaveFiles();
        wController.getView().enableUndoButton( true );        
    }
}