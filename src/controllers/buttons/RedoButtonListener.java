package controllers.buttons;

import controllers.windowEditorController;
import java.awt.event.ActionEvent;

/**
 * Listener for button Redo
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class RedoButtonListener extends ButtonListener
{
    private final windowEditorController wcontroller;

    public RedoButtonListener(windowEditorController viewEditor) {
        this.wcontroller = viewEditor;
        viewEditor.getView().enableRedoButton( false );
    }    
    
    @Override
    public void actionPerformed( ActionEvent event ) 
    {
        if (!  saveFilesNumberValid() ){
            wcontroller.getView().enableRedoButton( false );
            return;
        }
           
        wcontroller.increaseArticle();
        
            String codeBoxString= wcontroller.getOriginator().
                    RestoreFromMemento( wcontroller.getCareTaker().
                            getMemento( wcontroller.getCurrentArticle() ) );
            
            wcontroller.getView().getAreaEditor().setText(codeBoxString);
            wcontroller.getView().enableUndoButton( true );
    }

    private boolean saveFilesNumberValid() 
    {
        return ( wcontroller.getSaveFiles() - MINIMAL_ARTICLE ) > wcontroller.getCurrentArticle() ;
    }
}