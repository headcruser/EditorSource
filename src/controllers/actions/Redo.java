package controllers.actions;

import controllers.windowEditorController;
import java.awt.event.ActionEvent;

/**
 * Listener for button Redo
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class Redo extends Action
{
    private final windowEditorController wcontroller;

    public Redo(windowEditorController viewEditor) {
        this.wcontroller = viewEditor;
        viewEditor.getView().buttonRedo.setEnabled( false );
    }    
    
    @Override
    public void actionPerformed( ActionEvent event ) 
    {
        if (!  saveFilesNumberValid() ){
            wcontroller.getView().setEnabled(false);
            return;
        }
           
        wcontroller.increaseArticle();
        
            String codeBoxString= wcontroller.getOriginator().
                    RestoreFromMemento( wcontroller.getCareTaker().
                            getMemento( wcontroller.getCurrentArticle() ) );
            
            wcontroller.getView().getAreaEditor().setText(codeBoxString);
            wcontroller.getView().setEnabled(false);
    }

    private boolean saveFilesNumberValid() 
    {
        return ( wcontroller.getSaveFiles() - MINIMAL_ARTICLE ) > wcontroller.getCurrentArticle() ;
    }
}