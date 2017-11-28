package controllers.buttons;

import gui.WindowEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Button for Action Save Document
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class SaveButtonListener implements ActionListener
{
    private final WindowEditor viewEditor;

    public SaveButtonListener(WindowEditor viewEdirtor) {
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
