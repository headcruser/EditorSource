package controllers.buttons;

import controllers.windowEditorController;
import java.awt.event.ActionEvent;

/**
 * Listener for Button Undo
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class UndoButtonListener extends ButtonListener
{
     private final windowEditorController wController;

    public UndoButtonListener( windowEditorController viewEdirtor ) 
    {
        this.wController = viewEdirtor;
        wController.getView().enableUndoButton( false );
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        if (!  articleNumberValid() )
        {
            wController.getView().enableUndoButton( false );
            return;
        }
        
        wController.decreaseArticle();            
        wController.getView().getAreaEditor().setText( getBoxString() );
        wController.getView().enableRedoButton( true );
    }

    private String getBoxString() 
    {
        String codeBoxString= wController.getOriginator().
                RestoreFromMemento( wController.getCareTaker().
                        getMemento( wController.getCurrentArticle() ) );
        return codeBoxString;
    }
    
    private boolean articleNumberValid(){
        return wController.getCurrentArticle() >=MINIMAL_ARTICLE;
    }
}