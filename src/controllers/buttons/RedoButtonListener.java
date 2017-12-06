package controllers.buttons;

import gui.WindowEditor;
import java.awt.event.ActionEvent;

/**
 * Listener for button Redo
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class RedoButtonListener extends ButtonListener
{
    private final WindowEditor viewEditor;

    public RedoButtonListener(WindowEditor viewEditor) {
        this.viewEditor = viewEditor;
        viewEditor.enableRedoButton( false );
    }    
    
    @Override
    public void actionPerformed( ActionEvent e ) 
    {
        if (!  saveFilesNumberValid() ){
            viewEditor.enableRedoButton( false );
            return;
        }
           
        viewEditor.increaseArticle();
        
            String codeBoxString= viewEditor.getOriginator().
                    RestoreFromMemento( viewEditor.getCareTaker().
                            getMemento( viewEditor.getCurrentArticle() ) );
            
            viewEditor.getAreaEditor().setText(codeBoxString);
            viewEditor.enableUndoButton( true );
    }

    private boolean saveFilesNumberValid() { return (viewEditor.getSaveFiles()- 1 ) > viewEditor.getCurrentArticle() ;}
}