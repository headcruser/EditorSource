package controllers.buttons;

import controllers.files.FileManagerDialog;
import gui.WindowEditor;
import java.awt.event.ActionEvent;

/**
 * Button for Action Save Document
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class SaveButtonListener extends ButtonListener
{
    private final WindowEditor viewEditor;

    public SaveButtonListener(WindowEditor viewEdirtor) 
    {
        this.viewEditor = viewEdirtor;        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String codeInTextCode=viewEditor.getTextCode();        
        viewEditor.getOriginator().set( codeInTextCode );        
        viewEditor.getCareTaker().addMemento( viewEditor.getOriginator().storeInMomento() );
        viewEditor.increaseArticle();
        viewEditor.increaseSaveFiles();
        viewEditor.enableUndoButton( true );        
    }

}
